import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        //左边界
        int left = 0;
        //右边界
        int right = n -1;
        int up = 0;
        int low = n- 1;
        int num = 1;
        while (num <= n * n) {
            if (up <= low) {
                for (int i = left; i <=  right; i++) {
                   matrix[up][i]=num++;
                }
                up++;
            }

            if (left <= right) {
                for (int j = up; j <= low; j++) {
                    matrix[j][right]= num++;
                }
                right--;
            }

            if (up <= low) {
                for (int i = right; i  >= left; i --) {
                    matrix[low][i]= num++;
                }
                low--;
            }

            if (left <= right) {
                for (int j  = low; j  >= up; j --) {
                    matrix[j][left] = num++;
                }
                left++;
            }

        }

        return matrix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
