

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }

    //递归函数
    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.right);
        System.out.println(root.val);
        sum = sum+root.val;
        root.val = sum;
        traverse(root.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
