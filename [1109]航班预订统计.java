//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int[] corpFlightBookings(int[][] bookings, int n) {
	    int[] nums = new int[n];
		Difference difference = new Difference(nums);
		for (int i = 0; i < bookings.length; i++) {
			int i1 = bookings[i][0]-1;
			int j = bookings[i][1]-1;
			int val = bookings[i][2];
			difference.increment(i1, j, val);
		}

		return difference.result();

	}
}

// 封装成一个类
class Difference {

	// 差分数组
	private int[] diff;

	// 构造方法初始化
	public Difference(int[] nums) {
		//初始化数组
		diff = new int[nums.length];

		diff[0] = nums[0];
		// 构建差分数组
		for (int i = 1; i < nums.length; i++) {
			diff[i] =  nums[i]-nums[i - 1] ;
		}
	}

	/* 给闭区间 [i, j] 增加 val（可以是负数）*/
	public void increment(int i, int j, int val) {
		diff[i] = diff[i] + val;
		if (j+1 < diff.length) {
			diff[j+1] = diff[j+1] - val;
		}

	}

	/* 返回结果数组 */
	public int[] result() {
		int[] res = new int[diff.length];
		res[0]=diff[0];
		for (int i = 1; i < diff.length; i++) {
			res[i]= diff[i]+res[i-1];
		}
		return res;

	}
}

//leetcode submit region end(Prohibit modification and deletion)
