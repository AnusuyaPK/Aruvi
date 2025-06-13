package DynamicProgramming;

import static java.lang.Math.max;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "BANANA";
        System.out.println(findLengthOfLPSUsingRec(s,0,s.length()-1));

        int[][] memo = new int[s.length()][s.length()];
        for(int i=0; i<memo.length; i++) {
            for(int j=0; j<memo.length; j++) {
                memo[i][j] = -1;
            }
        }
        System.out.println(findLengthOfLPSUsingDP(s,0,s.length()-1, memo));
        for(int i=0; i<memo.length; i++) {
            for(int j=0; j<memo.length; j++) {
                System.out.print(memo[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int findLengthOfLPSUsingRec(String s, int low, int high) {
        // Base Condition
        if(low > high) {
            return 0;
        }
        if(low == high) {
            return 1;
        }
        // Main Logic
        // 1. char are same
        if(s.charAt(low) == s.charAt(high)) {
            return 2+findLengthOfLPSUsingRec(s, low+1, high-1);
        }
        // 2. char are different
        else {
            int option1 = findLengthOfLPSUsingRec(s, low, high-1);
            int option2 = findLengthOfLPSUsingRec(s, low+1, high);
            return max(option1, option2);
        }
    }
    public static int findLengthOfLPSUsingDP(String s, int low, int high, int[][] memo) {
        if(memo[low][high] != -1) {
            return memo[low][high];
        }
        // Base Condition
        if(low > high) {
            memo[low][high] = 0;
            return memo[low][high];
        }
        if(low == high) {
            memo[low][high] = 1;
            return memo[low][high];
        }
        // Main Logic
        // 1. char are same
        if(s.charAt(low) == s.charAt(high)) {
            memo[low][high] = 2+findLengthOfLPSUsingRec(s, low+1, high-1);
            return memo[low][high];
        }
        // 2. char are different
        else {
            int option1 = findLengthOfLPSUsingRec(s, low, high-1);
            int option2 = findLengthOfLPSUsingRec(s, low+1, high);
            memo[low][high] = max(option1, option2);
            return memo[low][high];
        }
    }
}
