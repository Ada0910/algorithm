//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
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
	//返回结果集
	List<TreeNode> res = new ArrayList<>();
	//子树
	HashMap<String, Integer> subTreeMap = new HashMap<>();
	String SEP = ",";
	String NULL = "#";

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		traverse(root);
		return res;
	}

	/* 辅助函数 */
	String traverse(TreeNode root) {
		//将树序列化成字符串
		if (root == null) {
			return NULL;
		}

		String left = traverse(root.left);
		String right = traverse(root.right);

		String subTree = left + SEP + right + SEP + root.val;

		//然后用一个hashMap,判断是否有重复的子树，是则加到结果列表中
		int times =subTreeMap.getOrDefault(subTree,0);
		if(times == 1){
			res.add(root);
		}
		subTreeMap.put(subTree,times+1);

		//返回结果列表
		return subTree;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
