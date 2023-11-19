

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	//解法一：
	//public int coinChange(int[] coins, int amount) {
	//	return dp(coins, amount);
	//}
	//
	////DP函数 凑齐amount的零钱需要dp（amount,coins）+1个硬币
	//public int dp(int[] coins, int amount) {
	//	// base case 
	//	if (amount == 0) {
	//		return 0;
	//	}
	//	if (amount < 0) {
	//		return -1;
	//	}
	//
	//	int res = Integer.MAX_VALUE;
	//	for (int coin : coins) {
	//		int subProblem = dp(coins, amount - coin);
	//		if (subProblem == -1) {
	//			continue;
	//		}
	//		res = Math.min(res, subProblem + 1);
	//	}
	//
	//	return res == Integer.MAX_VALUE ? -1 : res;
	//}
	
	// 存
	int[] memo;
	//解法二：带备忘录的解法
	public int coinChange(int[] coins, int amount) {
		memo = new int[amount + 1];
		Arrays.fill(memo, -666);
		return dp(coins, amount);
	}

	//DP函数 凑齐amount的零钱需要dp（amount,coins）+1个硬币
	public int dp(int[] coins, int amount) {
		// base case 
		if (amount == 0) {
			return 0;
		}
		if (amount < 0) {
			return -1;
		}
		
		if(memo[amount]!= -666){
			return memo[amount];
		}

		int res = Integer.MAX_VALUE;
		for (int coin : coins) {
			int subProblem = dp(coins, amount - coin);
			if (subProblem == -1) {
				continue;
			}
			res = Math.min(res, subProblem + 1);
		}
		
		res = res == Integer.MAX_VALUE ? -1: res;
		memo[amount] =res;
		return memo[amount];
	}
}
//leetcode submit region end(Prohibit modification and deletion)
