

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
	public TreeNode searchBST(TreeNode root, int val) {
		return traverse2(root, val);
	}

	//辅助函数,全部遍历
	public TreeNode traverse(TreeNode root, int val) {
		if (root == null) {
			return null;
		}
		TreeNode left = traverse(root.left, val);
		System.out.println(root.val);
		//中序的位置
		if (val == root.val) {
			System.out.println("val" + root.val);
			return root;
		}
		TreeNode right = traverse(root.right, val);
		return left != null ? left : right;
	}

	//解法二：
	public TreeNode traverse2(TreeNode root, int val) {
		if (root == null) {
			return null;
		}
		if (root.val > val) {
			return traverse2(root.left, val);
		}

		if (root.val < val) {
			return traverse2(root.right,val);
		}
		return root;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
