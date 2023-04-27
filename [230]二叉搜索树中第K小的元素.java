

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
	int res = 0;
	int resVal = 0;

	public int kthSmallest(TreeNode root, int k) {
		traverse(root, k);
		return resVal;
	}

	//中序遍历函数
	public void traverse(TreeNode root, int k) {
		//base case
		if (root == null) {
			return;
		}
		
		traverse(root.left, k);
		System.out.println(root.val);
		//中序位置
		res++;
		if (k == res) {
			resVal = root.val;
			return;
		}

		//中序遍历的位置
		traverse(root.right, k);
	}
}
//leetcode submit region end(Prohibit modification and deletion)
