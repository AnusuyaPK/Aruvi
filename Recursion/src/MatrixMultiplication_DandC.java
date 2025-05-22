public class MatrixMultiplication_DandC {
    public static void main(String[] args) {
        //Matrix Multiplication using D & C
        int[][] A = {{1,2},{3,4}};
        int[][] B = {{1,2},{3,4}};
        int[][] result = multiplyMatrices(A,B,2);
        for(int i=0; i<2; i++) {
            for(int j=0; j<2; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

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

    // Using recursion - divide and conquer
    // Matrix Addition
    public static int[][] addMatrices(int[][] A, int[][] B, int n) {
        int[][] result = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    public static int[][] multiplyMatrices(int[][] A, int[][] B, int n){
        int[][] finalResult = new int[n][n];

        // Base Condition
        if(n==1) {
            finalResult[0][0] = A[0][0] * B[0][0];
            return finalResult;
        }

        // 1. Sub Matrices
        int[][][] arrayOfSubMatrices = new int[8][n/2][n/2];
        for(int i=0; i<n/2; i++) {
            for(int j=0; j<n/2; j++) {
                arrayOfSubMatrices[0][i][j] = A[i][j]; // Submatrix A
                arrayOfSubMatrices[1][i][j] = A[i][j+n/2]; // Submatrix B
                arrayOfSubMatrices[2][i][j] = A[i+n/2][j]; // Submatrix C
                arrayOfSubMatrices[3][i][j] = A[i+n/2][j+n/2]; // Submatrix D
                arrayOfSubMatrices[4][i][j] = B[i][j]; // Submatrix E
                arrayOfSubMatrices[5][i][j] = B[i][j+n/2]; // Submatrix F
                arrayOfSubMatrices[6][i][j] = B[i+n/2][j]; // Submatrix G
                arrayOfSubMatrices[7][i][j] = B[i+n/2][j+n/2]; // Submatrix H

            }
        }

//        A*E + B*G => arrayOfSubMatrices[0] * arrayOfSubMatrices[4] + arrayOfSubMatrices[1] * arrayOfSubMatrices[6]
//        A*F + B*H => arrayOfSubMatrices[0] * arrayOfSubMatrices[5] + arrayOfSubMatrices[1] * arrayOfSubMatrices[7]
//        C*E + D*G => arrayOfSubMatrices[2] * arrayOfSubMatrices[4] + arrayOfSubMatrices[3] * arrayOfSubMatrices[6]
//        C*F + D*H => arrayOfSubMatrices[2] * arrayOfSubMatrices[5] + arrayOfSubMatrices[3] * arrayOfSubMatrices[7]

        // 2. Temp Result
        // Recursive calls are made here, during each sub matrix multiplication
        int[][][] tempResult = new int[4][n/2][n/2];
        tempResult[0] = addMatrices(multiplyMatrices(arrayOfSubMatrices[0], arrayOfSubMatrices[4], n/2) ,
                multiplyMatrices(arrayOfSubMatrices[1], arrayOfSubMatrices[6], n/2), n/2);
        tempResult[1] = addMatrices(multiplyMatrices(arrayOfSubMatrices[0], arrayOfSubMatrices[5], n/2) ,
                multiplyMatrices(arrayOfSubMatrices[1], arrayOfSubMatrices[7], n/2), n/2);
        tempResult[2] = addMatrices(multiplyMatrices(arrayOfSubMatrices[2], arrayOfSubMatrices[4], n/2) ,
                multiplyMatrices(arrayOfSubMatrices[3], arrayOfSubMatrices[6], n/2), n/2);
        tempResult[3] = addMatrices(multiplyMatrices(arrayOfSubMatrices[2], arrayOfSubMatrices[5], n/2) ,
                multiplyMatrices(arrayOfSubMatrices[3], arrayOfSubMatrices[7], n/2), n/2);

        // 3. Final Result
        for(int i=0; i<n/2; i++) {
            for(int j=0; j<n/2; j++) {
                finalResult[i][j] = tempResult[0][i][j];
                finalResult[i][j+n/2] = tempResult[1][i][j];
                finalResult[i+n/2][j] = tempResult[2][i][j];
                finalResult[i+n/2][j+n/2] = tempResult[3][i][j];
            }
        }

        return finalResult;

    }



}