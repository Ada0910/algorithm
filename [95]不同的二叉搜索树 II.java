//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;

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
	public List<TreeNode> generateTrees(int n) {
		if (n == 0) {
			return new ArrayList<>();
		}
		return build(1, n);

	}

	/* 构造闭区间 [lo, hi] 组成的 BST */
	List<TreeNode> build(int lo, int hi) {
		List<TreeNode> res = new ArrayList<>();

		//base case 为空则直接返回
		if (lo > hi) {
			res.add(null);
		}

		//遍历树节点
		for (int i = lo; i <= hi; i++) {
			List<TreeNode> leftTree = build(lo, i - 1);
			List<TreeNode> rightTree = build(i + 1, hi);

			for (TreeNode left : leftTree) {
				for (TreeNode right : rightTree) {
					TreeNode tree = new TreeNode(i);
					tree.left = left;
					tree.right = right;
					res.add(tree);
				}
			}
		}
		return res;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
