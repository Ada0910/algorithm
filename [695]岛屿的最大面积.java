//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	int res = 0;

	public int maxAreaOfIsland(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					res = Math.max(res, dfs(grid, i, j));
				}
			}
		}
		return res;
	}

	// 淹没与 (i, j) 相邻的陆地，并返回淹没的陆地⾯积
	int dfs(int[][] grid, int i, int j) {
		int m = grid.length, n = grid[0].length;
		if (i < 0 || j < 0 || i >= m || j >= n) {
// 超出索引边界
			return 0;
		}
		if (grid[i][j] == 0) {
// 已经是海⽔了
			return 0;
		}
// 将 (i, j) 变成海⽔
		grid[i][j] = 0;
		return dfs(grid, i + 1, j) + dfs(grid, i, j + 1) + dfs(grid, i - 1, j) + dfs(grid, i, j - 1) + 1;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
