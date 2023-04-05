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
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		// 构造这个哈希值，是为了优化效率
		HashMap<Integer, Integer> valIndex = new HashMap<>();
		for (int i = 0; i < inorder.length ; i++) {
			valIndex.put(inorder[i], i);
		}
		return build(valIndex,preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	/*
	build 函数的定义：
	若前序遍历数组为 preorder[preStart..preEnd]，
	中序遍历数组为 inorder[inStart..inEnd]，
	构造二叉树，返回该二叉树的根节点
*/
	TreeNode build(HashMap<Integer, Integer> valIndex ,int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {

		// base case
		if ((preStart > preEnd)) {
			return null;
		}

		//找到根节点(先序遍历第一个节点就是根节点)
		int rootVal = preorder[preStart];
		System.out.println(rootVal);

		// 	根据根节点在中序遍历中找到根节点的下标
		int rootIndex = valIndex.get(rootVal);
		// 左子树的数量可以推倒出
		int leftSize = rootIndex-inStart;

		TreeNode root = new TreeNode(rootVal);

		// 构建左子树
		root.left = build(valIndex,preorder, preStart+1, preStart+leftSize, inorder, inStart, rootIndex - 1);

		// 构建右子树
		root.right = build(valIndex,preorder, preStart+leftSize+1,preEnd , inorder, rootIndex + 1, inEnd);
		return root;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
