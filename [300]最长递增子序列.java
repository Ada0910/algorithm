import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	//nums = [10,9,2,5,3,7,101,18],最长递增子序列是 [2,3,7,101]，因此长度为 4

	public int lengthOfLIS(int[] nums) {
		// 以i为下标的最长递增子序列的长度
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);

		for (int i = 0; i < nums.length;i++){
			// 假设j是dp数组的最后一个，则前面的数的计算为
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int res = 0;
		for (int i = 0; i < dp.length; i++) {
			res = Math.max(res, dp[i]);
		}
		System.out.println(Arrays.toString(dp));

		return res;
	}


}
//leetcode submit region end(Prohibit modification and deletion)
