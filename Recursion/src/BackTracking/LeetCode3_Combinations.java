package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode3_Combinations {
    public static void main(String[] args) {
        combinationSum(new int[]{2,5,2,1,2}, 5);
    }

    /**
     * 40. Combination Sum ||
     * Given a collection of candidate numbers (candidates) and a target number (target), find all
     * unique combinations in candidates where the candidate numbers sum to target.
     * Each number in candidates may only be used once in the combination.
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> finalListOfCombinations = new ArrayList<>();
        //bubble sort
        for(int i=0; i<candidates.length-1; i++) {
            for (int j = 0; j < candidates.length - 1 - i; j++) {
                if (candidates[j] > candidates[j + 1]) {
                    int temp = candidates[j];
                    candidates[j] = candidates[j + 1];
                    candidates[j + 1] = temp;
                }
            }
        }
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
        findCombinations(candidates, target, takeArray, sumSoFar+candidates[currentIndex], finalListOfCombinations, currentIndex+1);

        // Don't Take
        ArrayList<Integer> dontTakeArray = new ArrayList<>(accumulator);
        // 1 1 1 1 3
        int targetIndex = currentIndex;
        while ((targetIndex < candidates.length) && (candidates[currentIndex] == candidates[targetIndex])) {
            targetIndex+=1;
        }
        findCombinations(candidates, target, dontTakeArray, sumSoFar, finalListOfCombinations, targetIndex);
    }
}
