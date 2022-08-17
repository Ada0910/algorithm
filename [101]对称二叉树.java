

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
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		} else {
			return dsf(root.left, root.right);
		}
	}

	/**
	 * 终止的条件：
	 * （1）都为空
	 *  (2)左右只有一个为空
	 *  (3)左右的值不相等
	 */
	private Boolean dsf(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}

		if (left == null || right == null) {
			return false;
		}

		if (left.val != right.val) {
			return false;
		}

		return dsf(left.left,right.right)&& dsf(left.right,right.left);

	}
}
//leetcode submit region end(Prohibit modification and deletion)
