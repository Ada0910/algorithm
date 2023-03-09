

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
	public ListNode middleNode(ListNode head) {
		//用快慢指针
		ListNode fast = head;
		ListNode slow = head;

		//快指针每次走两步，慢指针每次走一步
		while (fast != null&& fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next ;
		}
	

		//返回慢指针就是中间节点
		return slow;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
