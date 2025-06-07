package BackTracking;

public class travelInLandmines {
    static int noOfDirections = 4;
    static int[] rowUpdates = {-1, 1, 0, 0};
    static int[] colUpdates = {0, 0, -1, 1};
    static int minimumDistance = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] land = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 } };

        findShortestPath(land);

    }

    public static void findShortestPath(int[][] land) {
        int totalRows = land.length;
        int totalColumns = land[0].length;

        // Mark the unsafe areas
        for(int row = 0; row < totalRows; row++) {
            for(int col = 0; col < totalColumns; col++) {
                if(land[row][col] == 0){
                    // put -1 in adjacent cells
                    for(int direction = 0; direction < noOfDirections; direction++ ){
                        int newRow = row+rowUpdates[direction];
                        int newCol = col+colUpdates[direction];
                        if(isValid(land, newRow,newCol)){
                            land[newRow][newCol] = -1;
                        }
                    }
                }
            }
        }
//        printLand(land);

        // start from each row
        for(int row = 0; row < totalRows; row++) {
            if(land[row][0] != 0 && land[row][0] != -1) { // ensure that it's safe
                findShortestPathSpecificToEachRow(land, row, 0, 0);
            }
        }
    }

    // recursive finction
    public static void findShortestPathSpecificToEachRow(int[][] land, int currentRow, int currentCol, int distanceSoFar) {
        int totalRows = land.length;
        int totalColumns = land[0].length;

        // base condition
        if(currentCol == totalColumns-1) {
            if(distanceSoFar < minimumDistance) {
                minimumDistance = distanceSoFar;
            }
            return;
        }

        // Main Logic
        // exploring 4 direction


    }

    public static boolean isValid(int[][] land, int row, int col) {
        int totalRows = land.length;
        int totalColumns = land[0].length;
        if(row >= 0 && col >= 0 && row < totalRows && col < totalColumns) {
            return true;
        }
        return false;
    }

    public static void printLand(int[][] land) {
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[0].length; j++) {
                System.out.print(land[i][j] + "   ");
            }
            System.out.println();
        }
     }


}
