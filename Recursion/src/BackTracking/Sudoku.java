package BackTracking;

public class Sudoku {
    public static void main(String[] args) {

    }

    public static boolean isValid(int[][] puzzle, int currentRow, int currentColumn, int number){
        // 1. check row
        for(int col=0; col<9; col++){
            if( puzzle[currentRow][col] == number) {
                return false;
            }
        }

        // 2. check column
        for(int row=0; row<9; row++){
            if( puzzle[row][currentColumn] == number) {
                return false;
            }
        }

        // 3. check the small small
        int startRow = currentRow - (currentRow%3);
        int startCol = currentColumn - (currentColumn%3);
        for(int i=0; i<=2; i++) {
            for(int j=0; j<=2; j++) {
                if(puzzle[startRow + i][startCol + j] == number){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean solveSudokuPuzzle(int[][] puzzle, int currentRow, int currentColumn){
        // base condition
        if(currentRow == 8 && currentColumn == 9) {
            // mission success
            return true;
        }

        // Main logic
        // 1-9 check all numbers
        for(int i=1; i<=9; i++) {

        }

        // Tomorrow's class 


    }
}
