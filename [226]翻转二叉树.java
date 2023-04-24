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
	public TreeNode invertTree(TreeNode root) {

		// 思路一：遍历

		traverse(root);
		return root;
	}

	// 遍历的框架
	public void traverse(TreeNode root) {

		if (root == null) {
			return;
		}

		//交换节点
		TreeNode temp = root.left;
		root.left = root.right;
		root.right =  temp ;

		// 遍历框架
		traverse(root.left);
		traverse(root.right);
	}


}
//leetcode submit region end(Prohibit modification and deletion)
