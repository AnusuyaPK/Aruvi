package DynamicProgramming;

import java.util.Arrays;

import static java.lang.Math.max;

public class Knapsack {
    public static int noOfFuncCallsUsingRec = 0;
    public static int noOfFuncCallsUsingDP = 0;

    public static void main(String[] args) {
        int[] itemProfitArray = {10,20,30,40,50,60};
        int[] itemWeightArray = {1,1,1,1,2,1};
        int maxCapacityOfBag = 4;
        System.out.println( findMaxProfitUsingRec(maxCapacityOfBag, itemProfitArray, itemWeightArray, maxCapacityOfBag, itemProfitArray.length) );

        int[][] memo = new int[maxCapacityOfBag+1][itemProfitArray.length+1];
        for(int[] row: memo) {
            Arrays.fill(row, -1);
        }
        System.out.println( findMaxProfitUsingDP(maxCapacityOfBag, itemProfitArray, itemWeightArray, maxCapacityOfBag, itemProfitArray.length, memo) );

        System.out.println("No of func calls in rec: "+noOfFuncCallsUsingRec);
        System.out.println("No of func calls in DP: "+noOfFuncCallsUsingDP);
    }

    public static int findMaxProfitUsingRec(int maxCapacityOfBag, int[] itemProfitArray, int[] itemWeightArray, int avlCapacity, int n ) {
        noOfFuncCallsUsingRec+=1;
        // Base Condition
        if(n == 0 || avlCapacity == 0)  {
            return 0;
        }
        // Main Logic
        if( itemWeightArray[n-1] > avlCapacity) {
            return findMaxProfitUsingRec(maxCapacityOfBag, itemProfitArray, itemWeightArray, avlCapacity, n-1);
        }
        // Take
        int maxProfitByTakingItem = itemProfitArray[n-1] + findMaxProfitUsingRec(maxCapacityOfBag, itemProfitArray, itemWeightArray, avlCapacity-itemWeightArray[n-1], n-1);
        // Don't Take
        int maxProfitByNotTakingItem = findMaxProfitUsingRec(maxCapacityOfBag, itemProfitArray, itemWeightArray, avlCapacity, n-1);

//        System.out.println(n+" "+max(maxProfitByTakingItem, maxProfitByNotTakingItem));
        return max(maxProfitByTakingItem, maxProfitByNotTakingItem);

    }

    public static int findMaxProfitUsingDP( int maxCapacityOfBag, int[] itemProfitArray, int[] itemWeightArray, int avlCapacity, int n, int[][] memo) {
        noOfFuncCallsUsingDP+=1;
        // Base Condition
        if(n == 0 || avlCapacity == 0)  {
            return 0;
        }

        if(memo[avlCapacity][n] != -1) {
            return memo[avlCapacity][n];
        }

        // Main Logic
        if( itemWeightArray[n-1] > avlCapacity) {
            memo[avlCapacity][n] = findMaxProfitUsingDP(maxCapacityOfBag, itemProfitArray, itemWeightArray, avlCapacity, n-1, memo);
            return memo[avlCapacity][n];
        }
        // Take
        int maxProfitByTakingItem = itemProfitArray[n-1] + findMaxProfitUsingDP(maxCapacityOfBag, itemProfitArray, itemWeightArray, avlCapacity-itemWeightArray[n-1], n-1, memo);
        // Don't Take
        int maxProfitByNotTakingItem = findMaxProfitUsingDP(maxCapacityOfBag, itemProfitArray, itemWeightArray, avlCapacity, n-1, memo);

//        System.out.println(n+" "+max(maxProfitByTakingItem, maxProfitByNotTakingItem));
        memo[avlCapacity][n] = max(maxProfitByTakingItem, maxProfitByNotTakingItem);
        return memo[avlCapacity][n];

    }
}
