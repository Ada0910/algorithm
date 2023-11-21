import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	int[][] memo;

	public int minFallingPathSum(int[][] matrix) {
		int res = Integer.MAX_VALUE;
		int n = matrix.length;
		memo = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(memo[i], 66666);
		}

		for (int i = 0; i < n; i++) {
			res = Math.min(res, dp(memo, matrix, n - 1, i));
		}
		return res;
	}

	//dp函数的含义是dp(matrix,i,j)表示matrix[0][.....] 到matrix[i][j]的最短路径和
	public int dp(int[][] memo, int[][] matrix, int i, int j) {

		// 非法索引检查
		if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length ) {
			// 返回一个特殊值
			System.out.println(i+":"+j);
			return 66666;
		}

		// base case
		if (i == 0) {
			return matrix[0][j];
		}


		if (memo[i][j] != 66666) {
			return memo[i][j];
		}

		if (j == 0) {
			memo[i][j] = matrix[i][j] + Math.min(dp(memo, matrix, i - 1, j + 1), dp(memo, matrix, i - 1, j));
			return memo[i][j];
		}

		memo[i][j] = matrix[i][j] + Math.min(dp(memo, matrix, i - 1, j), Math.min(dp(memo, matrix, i - 1, j + 1), dp(memo, matrix, i - 1, j - 1)));
		return memo[i][j];
	}
}
//leetcode submit region end(Prohibit modification and deletion)
