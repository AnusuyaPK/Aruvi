package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_Combinations {
    public static void main(String[] args) {
        combine(7, 2);
    }

    /**
     * 77) Combinations
     * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
     * You may return the answer in any order.
     */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> finalList = new ArrayList<>();
        findCombinations(n,k,0, finalList, new ArrayList<>());
        System.out.println(finalList);
        return finalList;
    }

    /**
     * Recursive function to find required combinations
     * @param n - array of 1 to n
     * @param k - length of each combination
     * @param startingIndex - index to start iteration
     * @param finalList - final list of combinations
     * @param accumulator - accumulates a possible combination
     */
    public static void findCombinations(int n, int k, int startingIndex, List<List<Integer>> finalList, List<Integer> accumulator) {
        // Base Condition
        if(accumulator.size() ==  k ) {
            finalList.add(accumulator);
            return;
        }
        // loop
        // 1, 2, 3, 4
        for(int i=startingIndex; i<n; i++) {
            accumulator.add(i+1);
            List<Integer> passingCopy = new ArrayList<>(accumulator);
            findCombinations(n,k,i+1, finalList, passingCopy);
            accumulator.remove(accumulator.size()-1);
        }
    }
}
