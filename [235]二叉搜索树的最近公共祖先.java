

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		int min = Math.min(q.val, p.val);
		int max = Math.max(q.val, p.val);
		return find(root, max, min);
	}

	//查找函数
	TreeNode find(TreeNode root, int max, int min) {
		//	base case 
		if (root == null) {
			return null;
		}

		if (root.val > max) {
			//找左子树
			return find(root.left, max, min);
		} else if (root.val < min) {
			return find(root.right, max, min);
		}

		return root;


	}
}
//leetcode submit region end(Prohibit modification and deletion)
