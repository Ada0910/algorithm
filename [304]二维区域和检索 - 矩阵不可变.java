

//leetcode submit region begin(Prohibit modification and deletion)
//class NumMatrix {

////维护一个二维数组
//int[][] preSum;
//
//public NumMatrix(int[][] matrix) {
//    //初始化
//    //行数
//    int m = matrix.length;
//    //列数
//    int n = matrix[0].length;
//    
//    //base case
//    if(m == 0|| n==0){
//        return ;
//    }
//    
//    preSum = new int[m+1][n+1];
//    for (int i = 0; i < m; i++) {
//        for (int j = 0; j < n; j++) {
//            //preSum记录的是以ij为原点的值
//            preSum[i+1][j+1] =preSum[i+1][j]+preSum[i][j+1] -preSum[i][j] + matrix[i][j];
//        }
//        
//    }
//}
//
//public int sumRegion(int row1, int col1, int row2, int col2) {
//    return preSum[row2+1][col2+1] -preSum[row1+1][col2]-preSum[row2][col1+1]+preSum[row1][col1];
//}

//}

class NumMatrix {
	int[][] sums;

	public NumMatrix(int[][] matrix) {
		int m = matrix.length;
		if (m > 0) {
			int n = matrix[0].length;
			sums = new int[m + 1][n + 1];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + matrix[i][j];
				}
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];}
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)
