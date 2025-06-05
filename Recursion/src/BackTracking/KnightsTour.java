package BackTracking;

public class KnightsTour {
    // moving in 8 directions
    // 0th index - one direction, 1st index - another direction
    static int noOfDirections = 8;
    static int[] rowChanges = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] colChanges = {-1, 1, 2, 2, 1, -1, -2, -2};
    public static void main(String[] args) {
        int n = 4;

        // chessboard initial construction
        int[][] chessBoard = new int[n][n];
        for(int i=0; i<chessBoard.length; i++) {
            for(int j=0; j<chessBoard.length; j++) {
                chessBoard[i][j] = -1;
            }
        }

        chessBoard[0][0] = 0;
        boolean isFullVisitPossible = findPattern(chessBoard, 0, 0, 1);
        if(isFullVisitPossible) {
            for(int i=0; i<chessBoard.length; i++) {
                for(int j=0; j<chessBoard.length; j++) {
                    System.out.print(chessBoard[i][j]+"  ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Full visit is not possible!");
        }

    }
    public static boolean isValid(int[][] chessBoard, int row, int col) {
        int n = chessBoard.length;
        if(row >= 0 && row<=n-1 && col >= 0 && col<=n-1 && chessBoard[row][col] == -1) {
            return true;
        }
        return false;
    }
    public static boolean findPattern(int[][] chessBoard, int currentRow, int currentCol, int step) {
        // Base Condition
        int n = chessBoard.length;
        if(step == (n*n)) {
            //mission success
            System.out.println(currentRow + " " + currentCol);
            return true;
        }

        // Main Logic
        // check in 8 direction
        for(int i=0; i<noOfDirections; i++) {
            int newRow = currentRow+rowChanges[i];
            int newCol = currentCol+colChanges[i];
            if(isValid(chessBoard, newRow, newCol)) {
                chessBoard[newRow][newCol] = step;
                boolean isFullVisitPossible = findPattern(chessBoard, newRow, newCol, step+1);
                if(isFullVisitPossible) {
                    return true;
                }
                chessBoard[newRow][newCol] = -1; // reset the chess box and go for next direction
            }
        }
        return false;
    }
}
