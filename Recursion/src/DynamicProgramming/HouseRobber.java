package DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

import static java.lang.Math.max;

public class HouseRobber {
    public static int noOfFuncCallsInRec = 0;
    public static int noOfFuncCallsInDP = 0;

    public static void main(String[] args) {
        int[] arrayOfHouses = {6, 7, 1, 3, 8, 2, 4};
        System.out.println( findMaxSum(arrayOfHouses, arrayOfHouses.length) );

        int[] memo = new int[arrayOfHouses.length+1];
        Arrays.fill(memo, -1);
        System.out.println( findMaxSumUsingDP(arrayOfHouses, arrayOfHouses.length, memo) );

        System.out.println(noOfFuncCallsInRec + " " + noOfFuncCallsInDP);
        // 41/3 = 13; Using Dp, we have reduced the func call 3 times
        // larger the input size, more its made efficiet 
    }

    // 1. Using Recursion
    public static int findMaxSum(int[] arrayOfHouses, int n) {
        noOfFuncCallsInRec+=1;
        // Base Condition
        if(n <= 0) {
            return 0;
        }
        if(n == 1) {
            return arrayOfHouses[n-1];
        }

        // Main Logic
        int maxSumFromRobbing = arrayOfHouses[n-1] + findMaxSum(arrayOfHouses, n-2);
        int maxSumFromNotRobbing = findMaxSum(arrayOfHouses, n-1);
        return max(maxSumFromRobbing, maxSumFromNotRobbing);
    }
    // 2. Using DP
    public static int findMaxSumUsingDP(int[] arrayOfHouses, int n, int[] memo) {
        noOfFuncCallsInDP+=1;
        // Base Condition
        if(n <= 0) {
            return 0;
        }
        if(n == 1) {
            return arrayOfHouses[n-1];
        }

        // DP
        if(memo[n] != -1) {
            return memo[n];
        }

        // Main Logic
        int maxSumFromRobbing = arrayOfHouses[n-1] + findMaxSumUsingDP(arrayOfHouses, n-2, memo);
        int maxSumFromNotRobbing = findMaxSumUsingDP(arrayOfHouses, n-1, memo);
        memo[n] = max(maxSumFromRobbing, maxSumFromNotRobbing);
        return memo[n];

    }

}
