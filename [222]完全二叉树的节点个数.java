

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
	List<TreeNode> resLists = new ArrayList<>();

	public int countNodes(TreeNode root) {
		getCount(root);
		return resLists.size();
	}

	//用一个递归函数
	public void getCount(TreeNode root) {
		if (root == null) {
			return;
		}

		resLists.add(root);
		getCount(root.left);
		getCount(root.right);
	}
}
//leetcode submit region end(Prohibit modification and deletion)
