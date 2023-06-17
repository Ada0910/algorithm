import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	int memo[][];

	public int minDistance(String word1, String word2) {
		int lcs = longestCommonSubsequence(word1, word2);
		return word1.length() - lcs + word2.length() - lcs;

	}

	int longestCommonSubsequence(String word1, String word2) {
		memo = new int[word1.length()][word2.length()];
		for (int[] row : memo) {
			Arrays.fill(row, -1);
		}
		return dp(word1, 0, word2, 0);
	}

	// 定义：计算 s1[i..] 和 s2[j..] 的最长公共子序列长度
	int dp(String s1, int i, String s2, int j) {
		//     base case
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
			memo[i][j] = Math.max(
					// 情况一、s1[i] 不在 lcs 中
					dp(s1, i + 1, s2, j),
					// 情况二、s2[j] 不在 lcs 中
					dp(s1, i, s2, j + 1));
			return memo[i][j];
		}
	}

	public int max(int i, int j, int k) {
		return Math.min(i, Math.max(j, k));
	}
}
//leetcode submit region end(Prohibit modification and deletion)
