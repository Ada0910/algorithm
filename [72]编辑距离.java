import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	int memo[][];

	public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		memo = new int[m][n];
		for (int[] row : memo) {
			Arrays.fill(row, -1);
		}
		return dp(word1, m - 1, word2, n - 1);

	}

	// 定义：返回 s1[0..i] 和 s2[0..j] 的最小编辑距离
	public int dp(String s1, int i, String s2, int j) {
		//	base case
		if (i == -1) {
			return j + 1;
		}

		if (j == -1) {
			return i + 1;
		}

		if (memo[i][j] != -1) {
			return memo[i][j];
		}

		if (s1.charAt(i) == s2.charAt(j)) {
			memo[i][j] = dp(s1, i - 1, s2, j - 1);
			return memo[i][j];
		} else {
			memo[i][j] = min(dp(s1, i, s2, j - 1) + 1, dp(s1, i - 1, s2, j) + 1, dp(s1, i - 1, s2, j - 1) + 1);
			return memo[i][j];
		}


	}

	public int min(int i, int j, int k) {
		return Math.min(i, Math.min(j, k));
	}
}
//leetcode submit region end(Prohibit modification and deletion)
