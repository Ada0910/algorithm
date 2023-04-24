//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public void rotate(int[][] matrix) {
		//1.先镜像对称
		mirrorRerverse(matrix);
		//2.然后再反转
		for (int[] row : matrix) {
			reverseRow(row);
		}
	}

	//镜像对称函数
	public void mirrorRerverse(int[][] matrix) {
		int n = matrix.length;

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

	//反转每一行函数
	public void reverseRow(int[] matrix) {
		int i = 0,j=matrix.length-1;
		while(i<j){
			int temp = matrix[i];
			 matrix[i] = matrix[j];
			 matrix[j] = temp;
			i++;
			j--;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)
