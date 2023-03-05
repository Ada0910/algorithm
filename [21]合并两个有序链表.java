//leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;

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
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		// 	if (list1 == null) {
		// 		return list2;
		// 	}
		//
		// 	if (list2 == null) {
		// 		return list1;
		// 	}
		//
		// 	if (list1.val < list2.val) {
		// 		list1.next = mergeTwoLists(list1.next, list2);
		// 		return list1;
		// 	}
		//
		// 	list2.next = mergeTwoLists(list1, list2.next);
		// 	return list2;
		//
		//
		// }

		// 有一个虚拟的头结点
		ListNode dummy = new ListNode(-1);
		ListNode p = dummy;

		// 有两个指针，可以比较分别比较并移动
		ListNode p1 = list1; ListNode p2 = list2;

		while (p1 != null && p2 != null) {
			// 如果是p1大，则让dummy指向p2
			if (p1.val > p2.val) {
				p.next = p2;
				p2 = p2.next;

				// 如果是p2大，则让dummy指向p1
			} else {
				p.next = p1;
				p1 = p1.next;

			}
			p = p.next;
		}


		// 如果是p1有剩，则直接加到链表后面
		if (p1 != null) {
			 p.next=p1;
		}

		//如果是p2有剩，则直接加到链表后面
		if (p2 != null) {
			 p.next=p2;
		}

		return dummy.next;

	}

}
//leetcode submit region end(Prohibit modification and deletion)
