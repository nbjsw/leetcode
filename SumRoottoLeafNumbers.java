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
    public int sumNumbers(TreeNode root) {
        return sumHelper(root, 0);
    }
    
    private int sumHelper(TreeNode root, int parent) {
        if (null == root) return 0;
        else if (null == root.left && null == root.right) {
            return parent * 10 + root.val;
        } else if (null == root.left) {
            return sumHelper(root.right, parent * 10 + root.val);    
        } else if (null == root.right) {
            return sumHelper(root.left, parent * 10 + root.val);    
        } else {
          return sumHelper(root.left, parent * 10 + root.val) + sumHelper(root.right, parent * 10 + root.val);
        }
    }
}