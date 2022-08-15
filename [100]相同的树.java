

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
	public boolean isSameTree(TreeNode p, TreeNode q) {
		/*
		 * 思路：结构和值都一样才是相等
		 */
		//两棵树都是空的，可以返回一样
		if (p == null && q == null) {
			return true;
			//不一样
		}else if(p == null || q == null){
			return false;
			//值不一样，不能认为相同
		}else if(p.val!=q.val){
			return  false;
		}else{
			return isSameTree( p.left,q.left)&& isSameTree( p.right,q.right);
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)
