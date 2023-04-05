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
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return build(nums, 0, nums.length - 1);
	}

	// 构建一个函数,排序left,right的数组，返回根节点
	public TreeNode build(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}

		// 1.先找出数组的最大值
		int maxValue = nums.length == 0 ? Integer.MIN_VALUE : nums[left];
		int index = left;
		// 这里的循环要以left，right作为边界
		for (int i = left; i <= right; i++) {
			if (maxValue < nums[i]) {
				maxValue = nums[i];
				index = i;
			}
		}

		//2.以最大点的值构建二叉树
		TreeNode root = new TreeNode(maxValue);

		// 3.递归左子树
		root.left = build(nums, left, index - 1);

		// 4.递归右子树
		root.right = build(nums, index + 1, right);

		// 5.返回递归后的节点
		return root;
	}

}
//leetcode submit region end(Prohibit modification and deletion)
