//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;

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
	public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
		//	构建一个hashmap
		HashMap<Integer, Integer> valIndex = new HashMap<>();
		for (int i = 0; i < postorder.length; i++) {
			valIndex.put(postorder[i], i);
		}
		return build(valIndex, preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);

	}

	// 定义：根据 preorder[preStart..preEnd] 和 postorder[postStart..postEnd]
	// 构建二叉树，并返回根节点。
	TreeNode build(HashMap<Integer, Integer> valIndex, int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
		//base case
		if (preStart > preEnd) {
			return null;
		}

		if (preStart == preEnd) {
			return new TreeNode(preorder[preStart]);
		}
		// System.out.print(postStart+":"+postEnd);

		// 构建根节点
		TreeNode root = new TreeNode(preorder[preStart]);

		// 获取左子树的根节点
		int index = valIndex.get(preorder[preStart+1]);

		// 左子树的数量
		int leftSize = index - postStart+1;
		System.out.print(leftSize+"  ");

		root.left = build(valIndex, preorder, preStart+1,preStart+leftSize,postorder,postStart,index);
		root.right = build(valIndex, preorder, preStart+leftSize+1,preEnd,postorder,index+1,postEnd-1);
		return root;

	}
}
//leetcode submit region end(Prohibit modification and deletion)
