//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
	public List<Integer> largestValues(TreeNode root) {
		// 层序遍历的模板
		//base case
		if (root == null) {
			return new ArrayList<>();
		}

		List<Integer> res = new LinkedList<>();

		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			int maxVal = Integer.MIN_VALUE;
			// 每一层
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				maxVal = Math.max(cur.val ,maxVal);

				if (cur.left != null){
					queue.offer(cur.left);
				}

				if (cur.right != null){
					queue.offer(cur.right);
				}
			}
			res.add(maxVal);
		}

		return res;

	}
}
//leetcode submit region end(Prohibit modification and deletion)
