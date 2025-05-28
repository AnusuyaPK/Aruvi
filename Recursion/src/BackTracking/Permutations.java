package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {
    public static void main(String[] args) {
        String[] array = {"A","B","C","12"};
        ArrayList<String> listOfAllPossiblePermutations = new ArrayList<>();
        findPermutations(array, 0, listOfAllPossiblePermutations);
        System.out.println(listOfAllPossiblePermutations);
    }
    public static void findPermutations(String[] array, int currentIndex, ArrayList<String> listOfAllPossiblePermutations) {
        //Base Condition
        if(currentIndex == array.length) {
            listOfAllPossiblePermutations.add(Arrays.toString(array));
            return;
        }
        // ABC
        // loop 1 => ABC
        // loop 2 => BAC
        // loop 3 => CBA
        // Recursive call inside a loop
        for(int i=currentIndex; i<array.length; i++) {
            swap(array, currentIndex, i);
            findPermutations(array, currentIndex+1, listOfAllPossiblePermutations);
            swap(array, currentIndex, i); // damage control
        }
    }
    public static void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
