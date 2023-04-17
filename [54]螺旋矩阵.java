import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		int m = matrix.length;
		int n = matrix[0].length;
		//左边界
		int left = 0;
		//右边界
		int right = n -1;
		int up = 0;
		int low = m- 1;
		while (res.size() < m * n) {
			if (up <= low) {
				for (int i = left; i <=  right; i++) {
					System.out.println("i:"+i);
					res.add(matrix[up][i]);
					System.out.println("up++"+matrix[up][i]);
				}
				up++;
			}

			if (left <= right) {
				for (int j = up; j <= low; j++) {
					res.add(matrix[j][right]);
					System.out.println("right--"+matrix[j][right]);
				}
				right--;
			}

			if (up <= low) {
				for (int i = right; i  >= left; i --) {
					res.add(matrix[low][i]);
					System.out.println("low"+matrix[low][i]);
				}
				low--;
			}

			if (left <= right) {
				for (int j  = low; j  >= up; j --) {
					res.add(matrix[j][left]);
					System.out.println("left++"+matrix[j][left]);
				}
				left++;
			}

		}

		return res;

		//
		//int m = matrix.length, n = matrix[0].length;
		//int upper_bound = 0, lower_bound = m - 1;
		//int left_bound = 0, right_bound = n - 1;
		//List<Integer> res = new LinkedList<>();
		//// res.size() == m * n 则遍历完整个数组
		//while (res.size() < m * n) {
		//	if (upper_bound <= lower_bound) {
		//		// 在顶部从左向右遍历
		//		for (int j = left_bound; j <= right_bound; j++) {
		//			res.add(matrix[upper_bound][j]);
		//			System.out.println("up++"+matrix[upper_bound][j]);
		//			//		}
		//		}
		//		// 上边界下移
		//		upper_bound++;
		//	}
		//
		//	if (left_bound <= right_bound) {
		//		// 在右侧从上向下遍历
		//		for (int i = upper_bound; i <= lower_bound; i++) {
		//			res.add(matrix[i][right_bound]);
		//		}
		//		// 右边界左移
		//		right_bound--;
		//	}
		//
		//	if (upper_bound <= lower_bound) {
		//		// 在底部从右向左遍历
		//		for (int j = right_bound; j >= left_bound; j--) {
		//			res.add(matrix[lower_bound][j]);
		//		}
		//		// 下边界上移
		//		lower_bound--;
		//	}
		//
		//	if (left_bound <= right_bound) {
		//		// 在左侧从下向上遍历
		//		for (int i = lower_bound; i >= upper_bound; i--) {
		//			res.add(matrix[i][left_bound]);
		//		}
		//		// 左边界右移
		//		left_bound++;
		//	}
		//}
		//return res;



	}
}
//leetcode submit region end(Prohibit modification and deletion)
