

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.PriorityQueue;

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
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length ==0){
			return null;
		}
		//使用优先级队列（用最小堆）
		PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
		//有一个虚拟子节点
		ListNode dummy = new ListNode(-1);
		//有一个指针
		ListNode p =dummy;

		//循环，入优先级队列
		for (ListNode head : lists) {
			if (head != null) {
				pq.add(head);
			}

		}

		//把优先级队列最小的给赋值到虚拟的下一个指针上
		while (!pq.isEmpty()) {
			ListNode node = pq.poll();
			p.next = node;
			//下一个如果不为空，则继续入优先级队列
			if (node.next != null) {
				pq.add(node.next);
			}
			//移动指针到下一个
			p= p.next;
		}
		//返回有序列表
		return dummy.next;
	}
}

//leetcode submit region end(Prohibit modification and deletion)
