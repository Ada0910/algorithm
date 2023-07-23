//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int closedIsland(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		//排除掉边缘(上下)
		for (int i = 0; i < n; i++) {
			dfs(grid, 0, i);
			dfs(grid, m - 1, i);
		}

		//排除掉左右
		for (int j = 0; j < m; j++) {
			dfs(grid, j, 0);
			dfs(grid, j, n - 1);
		}

		// 结果
		int res = 0;
		//遍历
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0) {
					res++;
					dfs(grid, i, j);
				}
			}
		}

		return res;

	}

	// DFS
	public void dfs(int[][] grid, int i, int j) {
		//边界问题
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
			return;
		}

		if (grid[i][j] == 1) {
			return;
		}

		grid[i][j] = 1;

		dfs(grid, i + 1, j);
		dfs(grid, i - 1, j);
		dfs(grid, i, j - 1);
		dfs(grid, i, j + 1);
	}
}
//leetcode submit region end(Prohibit modification and deletion)
