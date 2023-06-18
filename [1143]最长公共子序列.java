import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	int[][] memo;

	public int longestCommonSubsequence(String text1, String text2) {
		memo = new int[text1.length()][text2.length()];
		for (int[] row : memo) {
			Arrays.fill(row, -1);
		}
		return dp(text1, 0, text2, 0);

	}

	// 定义：计算 s1[i..] 和 s2[j..] 的最长公共子序列长度
	int dp(String s1, int i, String s2, int j) {
		//base case
		if (i == s1.length() || j == s2.length()) {
			return 0;
		}

		if (memo[i][j] != -1) {
			return memo[i][j];
		}

		if (s1.charAt(i) == s2.charAt(j)) {
			memo[i][j] = 1 + dp(s1, i + 1, s2, j + 1);
			return memo[i][j];
		} else {

			memo[i][j] = Math.max(dp(s1, i, s2, j + 1), dp(s1, i + 1, s2, j));
			return memo[i][j];
		}


	}
}
//leetcode submit region end(Prohibit modification and deletion)
