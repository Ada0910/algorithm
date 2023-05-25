//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	//解法一：直接暴力遍历
	//public int fib(int n) {
	//	if (n == 0) {
	//		return 0;
	//	}
	//
	//	if (n == 1) {
	//		return 1;
	//	}
	//
	//	return fib(n - 1) + fib(n - 2);
	//
	//}

	//解法二：带备忘录的遍历


	public int fib(int n) {
		int[] memo = new int[n+1   ];
		return dp(n,memo);
	}

	public int dp(int n,int[] memo){
		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}

		if (memo[n] != 0){
			return memo[n];
		}

		memo[n] = dp(n-1,memo)+dp(n-2,memo);

		return memo[n];
	}

}
//leetcode submit region end(Prohibit modification and deletion)
