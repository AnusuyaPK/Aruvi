package BackTracking;

public class Combinations {
    public static void main(String[] args) {
        String[] array = {"Cake","Cookies","Chocolates","Bread"};
        findCombinations(array, 0, "");

    }
    public static void findCombinations(String[] array, int currentIndex, String accumulator) {
        //base condition
        if(currentIndex == array.length) {
            if(accumulator == ""){
                System.out.println("I don't want anything!!");
                return;
            }
            System.out.println(accumulator);
            return;
        }
        // Take
        String takeString = accumulator + " " + array[currentIndex];
        findCombinations(array, currentIndex+1, takeString);
        // Don't Take
        String dontTakeString = accumulator;
        findCombinations(array, currentIndex+1, dontTakeString);

    }
}
