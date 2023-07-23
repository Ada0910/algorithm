//leetcode submit region begin(Prohibit modification and deletion)

/**
 * DFS算法遍历
 */
class Solution {
	public int numIslands(char[][] grid) {
		// 行
		int m = grid.length;
		// 列数量
		int n = grid[0].length;
		// 结果
		int res = 0;
		//遍历
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					res++;
					dfs(grid, i, j);
				}
			}
		}


		return res;
	}

	// DFS
	public void dfs(char[][] grid, int i, int j) {
		//边界问题
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
			return;
		}

		if (grid[i][j] == '0') {
			return;
		}

		grid[i][j] = '0';

		dfs(grid, i + 1, j);
		dfs(grid, i - 1, j);
		dfs(grid, i, j - 1);
		dfs(grid, i, j + 1);
	}
}
//leetcode submit region end(Prohibit modification and deletion)
