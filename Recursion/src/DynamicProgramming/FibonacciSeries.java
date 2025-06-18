package DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FibonacciSeries {
    public static void main(String[] args) {
        int n = 5;
        System.out.println( findNumberInFibonacciSeriesUsingBasicRecursion(n) );
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        System.out.println( findNumberInFibonacciSeriesUsingTopDown(n, memo) );
        // follow up task - print number of function calls and compare
        System.out.println( findNumberInFibonacciSeriesUsingBottomUp(n) );

    }

    //Basic Recursion
    public static int findNumberInFibonacciSeriesUsingBasicRecursion(int index) {
        // base condn:
        if(index == 0) {
            return 0;
        }
        if(index == 1) {
            return 1;
        }
        return findNumberInFibonacciSeriesUsingBasicRecursion(index-1) + findNumberInFibonacciSeriesUsingBasicRecursion(index-2);
    }

    //Dynamic Prog - Top down (Memoization)
    public static int findNumberInFibonacciSeriesUsingTopDown(int index, int[] memo) {
        // base condn:
        if(index == 0) {
            return 0;
        }
        if(index == 1) {
            return 1;
        }
        int valueAtIndexminus1;
        if(memo[index-1] != -1) {
            valueAtIndexminus1 = memo[index-1];
        } else {
            valueAtIndexminus1 = findNumberInFibonacciSeriesUsingBasicRecursion(index-1);
        }
        int valueAtIndexminus2;
        if(memo[index-2] != -1) {
            valueAtIndexminus2 = memo[index-2];
        } else {
            valueAtIndexminus2 = findNumberInFibonacciSeriesUsingBasicRecursion(index-2);
        }
        int valueAtIndex = valueAtIndexminus1 + valueAtIndexminus2;
        memo[index] = valueAtIndex;
        return memo[index];
    }

    //bottom up / tabulation
    public static int findNumberInFibonacciSeriesUsingBottomUp(int n) {
        int[] table = new int[n+1];
        table[0] = 0; table[1] = 1;
        for(int i=2; i<=n; i++) {
            table[i] = table[i-1]+table[i-2];
        }
        return table[n];
    }
}
