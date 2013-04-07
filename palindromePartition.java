/*
 * This is a dynamic programming problem
 * At first, I treat it as a variant of matrix chain multiplication.
 * Time complexity thus is O(n^3)
 * It, however, can be simplied a little bit as follows:
 * Let dp[i] = min cut for substring [i...n], where n is the length of input string.
 * Then    dp[i] = 0, if substring[i..n] itself is a palindrome
 *            or = 1 + dp[j+1], if substring(i, j) is a palindrome ( i < j < n )
 * Moreover, checking palindrome can be solved by dynamic-programming as well
 * substring(i, j) is palindrome if charAt(i) == charAt(j-1) && subtring(i+1,j-1) is palindrome.
 * => O(n^2)
 */
 
public class Solution {
    public int minCut(String s) {
        if (null ==s) return 0;
        int len = s.length();
        if (1 == len) return 0;
        
        int[] cut = new int[len+1];
        // This is for corner case where k = last element and (i, k) is a palindrome
        // we need to make 1 + cut[k+1] == 0 since the cut needed in this case is cut[i]
        cut[len] = -1;
        boolean[][] p = new boolean[len][len];
        
        // a single char must be palindrome
        for(int i = 0; i < len; i++) {
            p[i][i] = true;
        }
        
        // intialize p matrix 
        for(int L = 2; L <= len; L++) {
            for(int i = 0; i < len - L + 1; i++) {
                int j = i + L - 1;
                if(2 == L) p[i][j] = (s.charAt(i) == s.charAt(j));
                else p[i][j] = (s.charAt(i) == s.charAt(j)) && p[i+1][j-1];
            }
        }
        
        for(int i = len - 2; i >= 0; i--) {
            cut[i] = Integer.MAX_VALUE;
            for(int k = len - 1; k >= i; k--) {
                if( p[i][k] ) {
                    cut[i] = Math.min( cut[i], 1 + cut[k+1] );
                    
                }
                
            }
            
        }
        return cut[0];
    }
}
