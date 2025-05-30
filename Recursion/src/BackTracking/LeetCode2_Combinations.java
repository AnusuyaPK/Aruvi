package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class LeetCode2_Combinations {
    public static void main(String[] args) {
        combinationSum(new int[]{2,3,6,7}, 7);
    }

    /**
     * 39. Combination Sum
     * Given an array of distinct integers candidates and a target integer target, return a list of all
     * unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
     * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if
     * the frequency of at least one of the chosen numbers is different.
     */

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> finalListOfCombinations = new ArrayList<>();
        findCombinations(candidates,target, new ArrayList<>(), 0, finalListOfCombinations, 0);
        System.out.println(finalListOfCombinations);
        return finalListOfCombinations;
    }

    /**
     * findCombinations - finds list of combinations satisfying the given condition
     * @param candidates - list of elements
     * @param target - target sum
     * @param accumulator - temporary list to store the combination
     * @param sumSoFar - temporary variable for sum
     * @param finalListOfCombinations - final list
     * @param currentIndex - current element that is seen
     */
    public static void findCombinations(int[] candidates, int target, ArrayList<Integer> accumulator, int sumSoFar, List<List<Integer>> finalListOfCombinations, int currentIndex) {
        // Base Condition
        if(sumSoFar == target) {
            finalListOfCombinations.add(new ArrayList<>(accumulator) );
            return;
        }
        if( (currentIndex >= candidates.length) || (sumSoFar > target) ) {
            return;
        }

        // Decision Making
        // Take
        ArrayList<Integer> takeArray = new ArrayList<>(accumulator);
        takeArray.add(candidates[currentIndex]);
        findCombinations(candidates, target, takeArray, sumSoFar+candidates[currentIndex], finalListOfCombinations, currentIndex);

        // Don't Take
        ArrayList<Integer> dontTakeArray = new ArrayList<>(accumulator);
        findCombinations(candidates, target, dontTakeArray, sumSoFar, finalListOfCombinations, currentIndex+1);
    }
}