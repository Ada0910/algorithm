

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //指针1，进行遍历
        ListNode p1 = headA;
                
        //指针2,进行遍历
        ListNode p2 = headB;
        
        while(p1!=p2){
            //p1为空，则指向p2
            if (p1 == null ) {
                p1 = headB;
            }else{
                p1 = p1.next;
            }
            
            //同理，p2为空，则指向p1
            if (p2 == null ) {
                p2 = headA;
            }else{
                p2 = p2.next;
            }
        }
        
        return  p1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
