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
    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        } else {
            return symmetricHelper(root.left, root.right);
        }
    }
    
    private boolean symmetricHelper(TreeNode left, TreeNode right) {
        if (null == left && null == right) {
            return true;
        } else if (null == left) {
            return false;
        } else if (null == right) {
            return false;
        } else {            
            if (left.val == right.val &&
                symmetricHelper(left.left, right.right) &&
                symmetricHelper(left.right, right.left)) {
                return true;
            } else {
                return false;
            }
        }
    }
}