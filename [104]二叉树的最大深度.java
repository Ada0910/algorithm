

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
	//解法二：遍历一遍二叉树

	//数的最大深度
	int depth = 0;
	//返回的结果
	int res = 0;

	//解法二：后序遍历
	public int maxDepth(TreeNode root) {
		traverse(root);
		return res;
	}

	//递归
	public void traverse(TreeNode root) {
		if (root == null) {
			return ;
		}
		depth++;
		traverse(root.left);
		if (root.left == null && root.right == null) {
			res = Math.max(res, depth);
		}
		traverse(root.right);
		//这里是后序的位置，相当于离开节点的位置，需要减一
		depth--;
		
	}


	//解法一：后序遍历
	//public int maxDepth(TreeNode root) {
	//	if (root == null) {
	//		return 0;
	//	}
	//	//能不能一遍遍历，或者用递归的子问题解决，就能解决原问题
	//	int left = maxDepth(root.left);
	//	int right = maxDepth(root.right);
	//	int res = Math.max(left, right) + 1;
	//	return res;
	//}


}
//leetcode submit region end(Prohibit modification and deletion)
