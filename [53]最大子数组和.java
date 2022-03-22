

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int maxSubArray(int[] nums) {
		// dp[i]表示以 nums[i] 结尾 的 连续 子数组的最大和。
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		
	/** 状态转移方程
 	 *  dp[i] = dp[i - 1] + nums[i], dp[i - 1] > 0
	 *  dp[i] = nums[i],  dp[i - 1] <0
     */
		for (int i = 1; i < nums.length; i++) {
			if (dp[i - 1] > 0) {
				dp[i] = dp[i - 1] + nums[i];
			} else {
				dp[i] = nums[i];
			}
		}

		int result = dp[0];
		for (int i = 0; i < dp.length; i++) {
			result = Math.max(result, dp[i]);
		}

		return result;

	}
}
//leetcode submit region end(Prohibit modification and deletion)
