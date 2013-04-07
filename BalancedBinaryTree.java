/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        int[] h = new int[1];
        return isBalancedHelper(root, h);
    }

    //This is a O(n) solution, avoiding revisiting the same node 
    private boolean isBalancedHelper(TreeNode root, int[] h) {
        boolean l; // Is left subtree balanced?
        boolean r; // Is right subtree balanced?
        
        int[] lh = new int[1]; // height of left subtree
        int[] rh = new int[1]; // height of right subtree
        
        if (null == root) {
            h[0] = 0;
            return true;
        }
        
        l = isBalancedHelper(root.left, lh);
        r = isBalancedHelper(root.right, rh);
        
        if (l == false || r == false) return false;

        if ( (lh[0] - rh[0]) > 1 || (rh[0] - lh[0]) > 1 ) return false;
        
        h[0] = Math.max(lh[0], rh[0]) + 1;

        return true;
    }
}