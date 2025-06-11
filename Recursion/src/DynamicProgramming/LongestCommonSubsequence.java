package DynamicProgramming;

import static java.lang.Math.max;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "ABC";
        String s2 = "QBCD";
        // GTAB - LCS - length 4
        System.out.println( findLengthOfLCS(s1, s2, s1.length(), s2.length()) );
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
}
