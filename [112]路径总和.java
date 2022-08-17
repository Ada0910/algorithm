

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
	public boolean hasPathSum(TreeNode root, int targetSum) {
		//当前节点为空，则直接返回false
		if (root == null) {
			return false;
		}

		//判断叶子节点是不是跟最后的数相等
		if (root.left == null && root.right == null) {
			return targetSum == root.val;
		}

		return hasPathSum(root.left,targetSum-root.val )||hasPathSum(root.right,targetSum-root.val );
	}

}
//leetcode submit region end(Prohibit modification and deletion)
