

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int mySqrt(int x) {
		//0和1快速返回，节省效率
		if (x == 0 || x == 1) {
			return x;
		}

		//左指针
		int left = 1;
		//右指针(因为除0 1 之外，其他的数的平方不会比他的二分之一大)
		int right = x/2;
		//二分法
		while (left <= right) {
			//中间值
			int middle = (left + right) / 2;

			//用除法可以有效的防止溢出
			if (middle == x/middle) {
				return middle;
			}
			//x的值在middle右边
			if (middle < x/middle) {
				left = middle + 1;
			} else {
				//x的值的大小在middle左边
				right = middle - 1;
			}

		}
		return left - 1;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
