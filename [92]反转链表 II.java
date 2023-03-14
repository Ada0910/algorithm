

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
	
	ListNode sucessor = null;
	//前N个反转
	ListNode reverseN(ListNode head, int n){
		if(n==1){
			sucessor = head.next;
			return head;
		}
		
		ListNode last = reverseN(head.next,n-1);
		head.next.next = head;
		head.next = sucessor;
		return last;
		
	}
	public ListNode reverseBetween(ListNode head, int left, int right) {
		//left == 1时，就是反转前N个
		if(left==1){
			return reverseN(head,right);
		}
		
		//当left!=1时，设法用上上面的

		//反转列表
		head.next = reverseBetween(head.next, left-1, right - 1);
		
		return head;

	}
}
//leetcode submit region end(Prohibit modification and deletion)
