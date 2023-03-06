

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
	public ListNode partition(ListNode head, int x) {
		//两个临时节点
		ListNode dummy1 = new ListNode(-1);
		ListNode dummy2 = new ListNode(-1);

		//两个指针
		ListNode p1 = dummy1;
		ListNode p2 = dummy2;

		//一个指针遍历原数组
		ListNode p = head;

		//以指针p来遍历
		while (p != null) {
			//移动到p2链表
			if (p.val >= x) {
				p2.next = p;
				p2 = p2.next;
			} else {
				//移动到p1链表
				p1.next = p;
				p1 = p1.next;
			}

			// 断开链表(但是值不能断，需要有一个赋值操作)
			ListNode temp = p.next;
			p.next = null;
			p = temp;
		}

		//链接两个链表
		p1.next = dummy2.next;


		//返回p1的指针
		return dummy1.next;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
