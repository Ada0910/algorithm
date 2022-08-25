

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
	public TreeNode sortedArrayToBST(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}

	public TreeNode helper(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}
		// 总是选择中间位置左边的数字作为根节点
		int mid = (left + right) / 2;

		TreeNode root = new TreeNode(nums[mid]);
		root.left =helper(nums, left, mid - 1);
		root.right =helper(nums, mid + 1, right);
		return root;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
