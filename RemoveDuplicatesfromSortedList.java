public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        ListNode j = head;
        ListNode i = head.next;
        while(i != null) {
            if(j.val != i.val) {
                j = j.next;
                j.val = i.val;
            }
            i = i.next;
        }
        j.next = null;
        return head;
    }
}