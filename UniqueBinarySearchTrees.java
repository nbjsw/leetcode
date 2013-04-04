/*
3 approaches listed here:

1. naive recursion: f(n) = \sum_{i=1}^n f(i-1) * f(n-i), f(0) = 1, f(1) = 1;
2. This is nature for DP (see below).
3. f(n) = (2n)!/n!*(n+1)!, called Catalan number

*/

public class Solution {
    // First approach
    public int numTrees(int n) {
        if(n<=1) return 1;
        if(n==2) return 2;
        int res = 0;
        for(int i=1; i<=n; i++)
            res += numTrees(i-1)*numTrees(n-i);
        
        return res;
    }

    // Second approach
    int numTrees(int n) {
        int[] num = new int[n+1];
        num[0] = 1;
        if(n > 0) num[1] = 1;
        for(int i = 2; i < n+1; i++) {
            for(int j = 0; j < i; j++) {
                num[i] += num[j]*num[i-j-1];
            }
        }
        return num[n];
    }
    
    //Third approach
    public int numTrees(int n) {
        int c = 1;
        for (int i = 2; i <= n; i++)
            c = 2*(2*i-1)*c/(i+1);
 
        return c;
    }
}