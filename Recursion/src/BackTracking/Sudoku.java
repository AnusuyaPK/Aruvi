package BackTracking;

public class Sudoku {
    public static void main(String[] args) {
        int[][] puzzle = {
                {0, 5, 0, 0, 0, 6, 0, 1, 0},
                {0, 7, 0, 2, 0, 0, 9, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 4, 7, 0, 2, 0, 0, 6, 0},
                {0, 0, 0, 3, 0, 0, 0, 4, 0},
                {0, 1, 0, 9, 0, 0, 0, 7, 0},
                {0, 2, 0, 5, 0, 0, 8, 0, 0},
                {4, 0, 3, 0, 0, 0, 0, 0, 0},
                {5, 0, 0, 0, 3, 0, 1, 0, 0}
        };
        boolean isSolvable = solveSudokuPuzzle(puzzle, 0, 0);
        if(isSolvable) {
            for(int i=0; i < puzzle.length; i++) {
                for(int j=0; j < puzzle.length; j++) {
                    System.out.print(puzzle[i][j] + "  ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Opps! Puzzle cannot be solved!");
        }
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

        // 3. check the small box
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

        // column becomes out of bounds
        if(currentColumn == 9) {
            currentRow += 1;
            currentColumn = 0;
        }

        // Main logic
        // 1. If number is already present
        if(puzzle[currentRow][currentColumn] != 0) {
            return solveSudokuPuzzle(puzzle, currentRow, currentColumn+1);
        }

        // 2. The box is empty for us to fill
        // 1-9 check all numbers
        for(int number = 1; number <= 9; number++) {
            if(isValid(puzzle, currentRow, currentColumn, number)) {
                puzzle[currentRow][currentColumn] = number;
                boolean isSolvable = solveSudokuPuzzle(puzzle, currentRow, currentColumn+1);
                if(isSolvable) {
                    return true;
                }
                puzzle[currentRow][currentColumn] = 0;
            }
        }
        // no number is satisfied
        return false;
    }
}
