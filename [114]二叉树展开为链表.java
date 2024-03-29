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
	public void flatten(TreeNode root) {

		// base case
		if (root == null) return;

		// 把左右子树拉平
		flatten(root.left);
		flatten(root.right);

		/**** 后序遍历位置 ****/
		// 1、左右子树已经被拉平成一条链表
		TreeNode left = root.left;
		TreeNode right = root.right;

		// 2、将左子树作为右子树
		root.left = null;
		root.right = left;

		// 3、将原先的右子树接到当前右子树的末端
		TreeNode p = root;
		while (p.right!=null){
			p = p.right;
		}
		p.right = right;
	}




}
//leetcode submit region end(Prohibit modification and deletion)
