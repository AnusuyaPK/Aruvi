package BackTracking;

import java.util.ArrayList;

public class RatInMaze {
    static String directions = "UDLR";
    static int[] rowChanges = {-1, 1, 0, 0};
    static int[] colChanges = {0, 0, -1, 1};

    public static void main(String[] args) {
        int[][] maze = { {1, 0, 0, 0},
                         {1, 1, 1, 1},
                         {1, 1, 1, 0},
                         {0, 1, 1, 1}};
        ArrayList<String> finalPathList = new ArrayList<>();
        findPaths(maze, 0, 0, "", finalPathList);
        for(int i=0; i<finalPathList.size(); i++) {
            System.out.println(finalPathList.get(i));
        }
        if(finalPathList.size() == 0) {
            System.out.println("No path found!!");
        }

    }
    public static void findPaths(int[][] maze, int currentRow, int currentColumn, String pathAccumulator, ArrayList<String> finalPathList) {
        int n = maze.length;
        //base condition:
        if(currentRow == n-1 && currentColumn == n-1) {
            finalPathList.add(pathAccumulator);
            return;
        }
        //Main Logic - explore all 4 directions
        //we must avoid hard cording
        maze[currentRow][currentColumn] = 0; // damage control
        for(int i = 0; i < directions.length(); i++ ) {
            int newRow = currentRow+rowChanges[i];
            int newCol = currentColumn+colChanges[i];
            if(isValid(newRow, newCol, maze)) {
                findPaths(maze, newRow, newCol, pathAccumulator+directions.charAt(i), finalPathList);
            }
        }
        maze[currentRow][currentColumn] = 1; // damage control
    }

    public static boolean isValid(int row, int column, int[][] maze) {
        int n = maze.length;
        if(row >= 0 && column >= 0 && row <= n-1 && column <= n-1 && maze[row][column] != 0){
            return true;
        }
        return false;
    }

}
