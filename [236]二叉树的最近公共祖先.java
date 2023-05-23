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
		//这个思路是，如果p.val和q.val能够在找到，则说明是他们的公共祖先
		return find(root, p.val, q.val);
	}

	//查找函数（前序遍历框架）
	public TreeNode find(TreeNode root, int p, int q) {
		//	base case
		if (root == null) {
			return null;
		}
		if (root.val == p || root.val == q) {
			return root;
		}

		TreeNode left = find(root.left, p, q);
		TreeNode right = find(root.right, p, q);

		if (left != null && right != null){
			return root;
		}

		return left != null ? left : right;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
