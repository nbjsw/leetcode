/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode *sortedArrayToBST(vector<int> &num) {
        return sortedArrayToBSTRecur(num, 0, num.size()-1);
    }

private:
    TreeNode *sortedArrayToBSTRecur(vector<int> &num, int start, int end) {
        if (start > end) return NULL;
        
        int len = end - start + 1;

        TreeNode *leftSubTree = sortedArrayToBSTRecur(num, start, start + len/2 - 1);
        
        TreeNode *root = new TreeNode(num[start + len/2]);
        root->left = leftSubTree;
        root->right = sortedArrayToBSTRecur(num, start + len/2 + 1, end);
        
        return root;
    }
};