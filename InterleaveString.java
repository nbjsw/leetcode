public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s1.length() + s2.length() != s3.length()) return false;
    
        boolean [][] isInter = new boolean[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if ( i == 0 && j == 0 ) {
                    isInter[0][0] = true;
                } else if (i == 0) {
                    isInter[i][j] = isInter[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    isInter[i][j] = isInter[i-1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    isInter[i][j] = ( isInter[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1) ) || 
                                    ( isInter[i-1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1) );
                }
            }
        }

        return isInter[s1.length()][s2.length()];
    }
}