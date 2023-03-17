

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

	//左指针
	ListNode left;

	public boolean isPalindrome(ListNode head) {

		/*
		 * 问题，指针不跟数组一样，可以倒着遍历，也就无法用双指针技巧
		 * 那该如何解决好呢？
		 * 思路：借助二叉树后序遍历的思路，不需要显示反转原始链表也是倒序遍历链表
		 */
		//解法一：用后序遍历来解决，但是效率上没那么高
		//left = head;
		//return traverse(head);

		//	解法二：用快慢指针找出中点，然后从中点开始往两边遍历

		//步骤一：用快慢指针中找出中点
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		//步骤二：如果中点是奇数，则需要前进一位
		if(fast!=null){
			slow = slow.next;
		}
		//步骤三：反转slow 链表
		ListNode right = reverseList(slow);
		
		//步骤四：确定左指针的位置
		ListNode left = head;
		
		while ( right!=null){
			if(left.val !=right.val ){
				return false;
			}
			
			//移动指针
			left = left.next;
			right = right.next;
		}
		return true;

	}

	//解法一：
	//用后序遍历来解决指针倒序的问题
	boolean traverse(ListNode right) {
		//遍历到最后一个，说明都正确
		if (right == null) {
			return true;
		}
		Boolean res = traverse(right.next);
		System.out.println(right.val);
		//后序遍历，就是倒着来
		res = res && (right.val == left.val);
		//移动指针
		left = left.next;
		return res;
	}

	//反转链表
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
