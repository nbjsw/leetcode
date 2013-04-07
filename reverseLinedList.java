/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (null == head || null == head.next || m == n) return head;
        
	ListNode current = head;
	int count = m - 1;
	ListNode prev = null;
	while (count > 0) {
	    prev = current;
	    current = current.next;
	    count--;
	}//current�� Ҫ�ƶ��ĵ�һ����prev��ǰ�Ų��ƶ������һ��
	
	
	int delta = n - m + 1;
	ListNode cur = current; // cur�������ƶ����м��ƶ���
	ListNode curPrev = null;// cur��prev
	ListNode curNext = null;// cur��next

	while (delta > 0) {
	    curNext = cur.next;
	    cur.next = curPrev;
	    curPrev = cur;
	    cur = curNext;
	    delta--;
	}
	
	if (null != prev) prev.next = curPrev;
	
	if (curNext != null ) current.next = curNext;
	
	if (m == 1) return curPrev;
	
	return head;
    }
}