package DynamicProgramming;

import java.util.Arrays;

import static java.lang.Math.max;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        // GTAB - LCS - length 4
        System.out.println( findLengthOfLCS(s1, s2, s1.length(), s2.length()) );

        int[][] memo = new int[s1.length()+1][s2.length()+1];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }

        System.out.println( findLengthOfLCSUsingDP(s1, s2, s1.length(), s2.length(), memo) );
    }
    public static int findLengthOfLCS(String s1, String s2, int length1, int length2) {
        // base condition
        if(length1 == 0 || length2 == 0) {
            return 0;
        }

        // Main Logic
        // 1. last char is same
        if( s1.charAt(length1-1) == s2.charAt(length2-1) ) {
            int lengthInFront = findLengthOfLCS(s1, s2, length1-1, length2-1);
            return 1+lengthInFront;
        }
        // 2. if char are not same
        else {
            // s1 | s2-go front
            int lengthOption1 = findLengthOfLCS(s1, s2, length1, length2-1);
            // s1-go front | s2
            int lengthOption2 = findLengthOfLCS(s1, s2, length1-1, length2);
            return max(lengthOption1, lengthOption2);
        }
    }

    public static int findLengthOfLCSUsingDP(String s1, String s2, int length1, int length2, int[][] memo) {
        // base condition
        if(length1 == 0 || length2 == 0) {
            memo[length1][length2] = 0;
            return memo[length1][length2];
        }

        //DP logic
        if(memo[length1][length2] != -1) {
            return memo[length1][length2];
        }

        // Main Logic
        // 1. last char is same
        if( s1.charAt(length1-1) == s2.charAt(length2-1) ) {
            int lengthInFront = findLengthOfLCS(s1, s2, length1-1, length2-1);
            memo[length1][length2] = 1+lengthInFront;
            return memo[length1][length2];
        }
        // 2. if char are not same
        else {
            // s1 | s2-go front
            int lengthOption1 = findLengthOfLCS(s1, s2, length1, length2-1);
            // s1-go front | s2
            int lengthOption2 = findLengthOfLCS(s1, s2, length1-1, length2);
            memo[length1][length2] = max(lengthOption1, lengthOption2);
            return memo[length1][length2];
        }
    }
}
