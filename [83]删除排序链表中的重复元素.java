

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
	public ListNode deleteDuplicates(ListNode head) {
		//为空判断
		if (head == null) {
			return head;
		}

		ListNode curNode = head;
		//遍历列表
		while (curNode.next != null) {
			//如果相邻元素相等，则将下一个的指针指向上一个（移除）
			if (curNode.val == curNode.next.val) {
				curNode.next = curNode.next.next;
			}else{
				//指针移动
				curNode= curNode.next;
			}
		}


		return head;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
