package DynamicProgramming;

import static java.lang.Math.max;

public class Knapsack {
    public static void main(String[] args) {
        int[] itemProfitArray = {4,5,6};
        int[] itemWeightArray = {1,2,3};
        int maxCapacityOfBag = 4;
        System.out.println( findMaxProfit(maxCapacityOfBag, itemProfitArray, itemWeightArray, maxCapacityOfBag, itemProfitArray.length) );
    }

    public static int findMaxProfit( int maxCapacityOfBag, int[] itemProfitArray, int[] itemWeightArray, int avlCapacity, int n ) {
        // Base Condition
        if(n == 0 || avlCapacity == 0)  {
            return 0;
        }
        // Main Logic
        if( itemWeightArray[n-1] > avlCapacity) {
            return findMaxProfit(maxCapacityOfBag, itemProfitArray, itemWeightArray, avlCapacity, n-1);
        }
        // Take
        int maxProfitByTakingItem = itemProfitArray[n-1] + findMaxProfit(maxCapacityOfBag, itemProfitArray, itemWeightArray, avlCapacity-itemWeightArray[n-1], n-1);
        // Don't Take
        int maxProfitByNotTakingItem = findMaxProfit(maxCapacityOfBag, itemProfitArray, itemWeightArray, avlCapacity, n-1);

        System.out.println(n+" "+max(maxProfitByTakingItem, maxProfitByNotTakingItem));
        return max(maxProfitByTakingItem, maxProfitByNotTakingItem);

    }
}
