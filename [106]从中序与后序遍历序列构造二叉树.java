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
	public TreeNode buildTree(int[] inorder, int[] postorder) {

		// 用一个hashmap来存中序遍历的结果，避免重复循环
		HashMap<Integer, Integer> valIndexMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			valIndexMap.put(inorder[i], i);
		}
		return build(valIndexMap, inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}

	/*
	build 函数的定义：
	后序遍历数组为 postorder[postStart..postEnd]，
	中序遍历数组为 inorder[inStart..inEnd]，
	构造二叉树，返回该二叉树的根节点
*/
	TreeNode build(HashMap<Integer, Integer> valIndexMap, int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
		// base case
		if (inStart > inEnd) {
			return null;
		}

		// 找到中序遍历的下标
		int index = valIndexMap.get(postorder[postEnd]);
		System.out.print(postorder[postEnd]+"="+index+",");


		// 构建根节点
		TreeNode root = new TreeNode(postorder[postEnd]);

		//中序遍历中找到leftSize的大小，从而能在后续遍历中确定下标的范围
		int leftSize = index - inStart;
		System.out.print("<"+leftSize+">");

		// 递归构建左子树
		root.left = build(valIndexMap, inorder, inStart, index - 1, postorder, postStart, postStart + leftSize-1);

		// 递归构建右子树
		root.right = build(valIndexMap, inorder, index + 1, inEnd, postorder, postStart + leftSize , postEnd - 1);
		return root;
	}


}
//leetcode submit region end(Prohibit modification and deletion)
