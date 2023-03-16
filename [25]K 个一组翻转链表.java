

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
		//base case
		if (head == null ) {
			return null;
		}
		
		ListNode a = head;
		ListNode b = head;

		//k的数值大于链表的长度,则不需要反转
		for (int i = 0; i < k; i++) {
			if(b==null){
				return head;
			}
			b = b.next;
		}

		ListNode temp = reverse(a, b);
		a.next = reverseKGroup(b, k);
		return temp;

	}

	//反转整个链表a到b的链表，返回链表的头结点
	ListNode reverse(ListNode a, ListNode b) {
		ListNode pre = null;
		ListNode nxt = a;
		ListNode cur = a;
		while (cur != b) {
			nxt = cur.next;
			cur.next = pre;
			pre = cur;
			cur = nxt;
		}
		return pre;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
