

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //虚拟子节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //找到n+1个节点
        ListNode node = findFromEnd(dummy,n+1);
        node.next  = node.next.next;
        
        //返回链表
        return dummy.next;
    }

    private ListNode findFromEnd(ListNode head, int k) {
        //指针p1指向到n
        ListNode p1 = head;

        //p1指针走到n的位置
        for(int i = 0;i<k;i++){
            p1 = p1.next;
        }

        //指针p2指向到head,然后走k-n步，就是倒数第n个
        ListNode p2 = head;

        while(p1!=null){
            p1 = p1.next;
            p2 = p2.next;

        }
        return p2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
