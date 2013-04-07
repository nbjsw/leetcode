public class Solution {
    // I don't know how to implement it if Newton iteration is disallowed.
    // Try later
    public int sqrt(int x) {
        if (x < 0) return -1;
        if (x == 0) return 0;
        
        double y = ((double)x)/2.;
        
        while( Math.abs(y*y-x) > 0.00001 ){
            y=(y+x/y)/2.;
        }
        
        return (int) y;
    }
}