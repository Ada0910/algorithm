

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
	//解法一：
	//public ListNode reverseList(ListNode head) {
	//	//    base  case
	//	if (head == null || head.next == null) {
	//		return head;
	//	}
	//
	//
	//	//先定义一个反转链表的函数，其意义是给一个头指针，然后返回一个反转链表的尾指针
	//	ListNode last = reverseList(head.next);
	//
	//	//指针反向指向
	//	head.next.next = head;
	//
	//	//head指向NULL
	//	head.next = null;
	//	return last;
	//
	//}

	//解法二：
	public ListNode reverseList(ListNode head) {
		//三个指针
		ListNode pre = null;
		ListNode nxt = head;
		ListNode cur = head;

		while (cur != null) {
			//nxt指针移动到下一位
			nxt = cur.next;
			//pre指向到nxt指针
			cur.next = pre;
			pre = cur;
			//nxt就是当前的指针
			cur = nxt;
			
			
		}
		
		return pre;

	}
}
//leetcode submit region end(Prohibit modification and deletion)
