

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public boolean carPooling(int[][] trips, int capacity) {

		int[] nums = new int[1001];
		Difference difference = new Difference(nums);
		for (int[] trip : trips) {
			int i = trip[1] ;
			int j = trip[2] - 1;
			int val = trip[0];
			difference.increment(i, j, val);
		}

		int[] a = difference.result();
		//货车自始至终都不能超载
		for (int i = 0; i < a.length; i++) {
			if (a[i] > capacity) {
				return false;
			}

		}
		return true;
	}
}

// 封装成一个类
class Difference {

	// 差分数组
	private int[] diff;

	// 构造方法初始化
	public Difference(int[] nums) {
		diff = new int[nums.length];
		diff[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			diff[i] = nums[i] - nums[i - 1];
		}

	}

	/* 给闭区间 [i, j] 增加 val（可以是负数）*/
	public void increment(int i, int j, int val) {
		diff[i] = diff[i] + val;
		if (j + 1 < diff.length) {
			diff[j + 1] = diff[j+1] - val;
		}
	}

	/* 返回结果数组 */
	public int[] result() {
		int[] res = new int[diff.length];
		res[0] = diff[0];
		for (int i = 1; i < diff.length; i++) {
			res[i] = res[i - 1] + diff[i];
		}
		return res;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
