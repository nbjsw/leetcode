/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
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
    TreeNode *sortedListToBST(ListNode *head) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int size = countList(head);
        
        return sortedListToBSTRecur(&head, size);
    }
    
private:
    // construct the tree bottum-up
    TreeNode *sortedListToBSTRecur(ListNode **headPtr, int n) {
        //base case:
        if (n <= 0) return NULL;
        
        TreeNode *leftSubTree = sortedListToBSTRecur(headPtr, n/2);
        
        //Note, *headPtr is already changed by the previous recursive call.
        TreeNode *root = new TreeNode( (*headPtr)->val );
        root->left = leftSubTree;
        
        //move to next node
        *headPtr = (*headPtr)->next;
        
        root->right = sortedListToBSTRecur(headPtr, n - n/2 - 1);
        
        return root;
    }
    
    int countList(ListNode *head) {
        int count = 0;
        
        while (head != NULL) {
            count++;
            head = head->next;
        }
        
        return count;
    }
};