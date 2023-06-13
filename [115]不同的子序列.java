import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	int[][] memo;

	public int numDistinct(String s, String t) {
		memo = new int[s.length()][t.length()];
		for (int i = 0; i < s.length(); i++) {
			Arrays.fill(memo[i], -1);
		}
		return dp(s, 0, t, 0);
	}

	//dp函数的定义 以s[i....]中t[j....]的子序列有dp(s,i,t,j)个
	public int dp(String s, int i, String t, int j) {
		//base case 
		if (j == t.length()) {
			return 1;
		}

		//base case2
		if (s.length() - i < t.length() - j) {
			return 0;
		}

		if (memo[i][j] != -1) {
			return memo[i][j];
		}

		int sum = 0;
		for (int k = i; k < s.length(); k++) {
			if (s.charAt(k) == t.charAt(j)) {
				sum = sum + dp(s, k + 1, t, j + 1);
			}
		}
		memo[i][j] = sum;
		return sum;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
