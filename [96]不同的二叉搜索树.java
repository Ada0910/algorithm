//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	public int numTrees(int n) {
		//声明一个备忘录
		int[][] memo = new  int[n+1][n+1];
		return count( memo,1, n);
	}

	// 定义：闭区间 [lo, hi] 的数字能组成 count(lo, hi) 种 BST
	int count(int[][] memo,int lo, int hi) {
		if (lo > hi) {
			return 1;
		}

		//先查备忘录
		if(memo[lo][hi] != 0){
			return memo[lo][hi];
		}

		int res = 0;
		for (int i = lo; i <= hi; i++) {
			int left = count(memo,lo, i - 1);
			int right = count(memo,i + 1, hi);
			res = res + left * right;
			memo[lo][hi] = res;
		}

		return res;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
