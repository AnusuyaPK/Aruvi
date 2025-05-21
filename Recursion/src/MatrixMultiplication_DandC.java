public class MatrixMultiplication_DandC {
    public static void main(String[] args) {
        //To be continued
    }

    //Basic Multiplication Using Loops
    public static int[][] multiply(int[][] arr, int[][] brr) {
        int n = arr.length;

        // to store the resultant matrix
        int[][] res = new int[n][n];

        for (int i = 0; i < n; i++) { //rows
            for (int j = 0; j < n; j++) { //columns
                for (int k = 0; k < n; k++) { //just an iterator
                    res[i][j] += arr[i][k] * brr[k][j];
                }
            }
        }

        return res;
    }

    //Using recursion - divide and conquer
    // Matrix Addition
    public static int[][] matrixAddition(int[][] A, int[][] B, int n) {
        int[][] result = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }



}