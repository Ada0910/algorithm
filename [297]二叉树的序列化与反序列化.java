//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		//解法一：前序遍历解法
		StringBuilder  result = new StringBuilder();
		traverse(root,result);
		return result.toString();

	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] array = data.split(",");
		LinkedList<String> nodes = new LinkedList<>();
		for (String node : array) {
			nodes.add(node);
		}
		return deserialize(nodes);
	}


	//解法一：前序遍历解法
	void traverse(TreeNode root, StringBuilder  result) {
		if (root == null) {
			result.append("#,");
			return;
		}

		result.append(root.val).append(",") ;
		traverse(root.left,result);
		traverse(root.right,result);

	}

	/* 辅助函数，通过 nodes 列表构造二叉树 */
	TreeNode deserialize(LinkedList<String> nodes) {
		//base case
		if (nodes.isEmpty()) {
			return null;
		}
		/****** 前序遍历位置 ******/
		// 列表最左侧就是根节点
		String first = nodes.removeFirst();
		if (first.equals("#")){
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(first));
		root.left = deserialize(nodes);
		root.right = deserialize(nodes);
		return root;
	}

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
