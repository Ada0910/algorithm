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
// class Solution {
// 	// 思路一：分配求出最深的左右节点之和，加起来，然后再递归，然后不断更新最大值
// 	public int diameterOfBinaryTree(TreeNode root) {
//
// 		if (root == null) {
// 			return 0;
// 		}
//
// 		int leftMax = depth(root.left);
// 		int rightMax = depth(root.right);
//
// 		int res = leftMax + rightMax;
// 		int maxSum = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
//
// 		return Math.max(res, maxSum);
//
// 	}
//
// 	// 求出深度
// 	public int depth(TreeNode root) {
// 		if (root == null) {
// 			return 0;
// 		}
//
// 		int left = depth(root.left);
// 		int right = depth(root.right);
// 		int res = Math.max(left, right) + 1;
// 		return res;
// 	}
//
//
// }

// 思路二:
class Solution {

	// 设置一个全局的变量
	int maxSum = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		depth(root);
		return maxSum;
	}

	// 求出深度
	public int depth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		-+
		int left = depth(root.left);
		int right = depth(root.right);
		// // 后序遍历位置顺便计算最大直径
		maxSum = Math.max((left + right), maxSum);
		return 1 + Math.max(left, right);
	}
}
//leetcode submit region end(Prohibit modification and deletion)
