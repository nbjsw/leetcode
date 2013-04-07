/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//在写代码之前，我们先分析思路
//最长路径无非三种
//   maxPathSum of tree use left as root (can pass through left)
//or maxPathSum of tree use right as root (can pass through right)
//or maxPathSum of tree use root as root (left + root + right)
public class Solution {
    public int maxPathSum(TreeNode root) {
        int[] a = maxPathSumHelper(root);
    	return Math.max(a[0], a[1]);
    }
    
    //a[0] left or right 直线到头; a[1] 绕弯
    private int[] maxPathSumHelper(TreeNode root) {
    	if (null == root) {
    		int[] a = new int[2];
    		a[0] = 0; a[1] = 0;
    		return a;
    	} else if (null == root.left && null == root.right)  {
    		int[] a = new int[2];
    		a[0] = root.val; a[1] = root.val;
    		return a;
    	} else if (null == root.left) {
    		int[] a = new int[2];
    		int[] right = maxPathSumHelper(root.right);
    		a[0] = Math.max(right[0] + root.val, root.val);
            a[1] = Math.max(a[0], right[1]);
    		return a;
    	} else if (null == root.right) {
    		int[] a = new int[2];
    		int[] left = maxPathSumHelper(root.left);
    		a[0] = Math.max(left[0] + root.val, root.val);
            a[1] = Math.max(a[0], left[1]);
    		return a;
    	} else {
    		int[] a = new int[2];
    		int[] right = maxPathSumHelper(root.right);
    		int[] left = maxPathSumHelper(root.left);

            a[0] = Math.max(Math.max(right[0] + root.val, left[0] + root.val), root.val);
            
            int tmp = root.val;
            if (right[0] > 0) tmp += right[0];
            if (left[0] > 0) tmp += left[0];
            a[1] = Math.max( Math.max(left[1], right[1]), tmp );

            return a;
    	}
    }
}