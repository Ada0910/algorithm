import java.util.Random;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int findKthLargest(int[] nums, int k) {
		//写一个随机函数，打乱数组
		suffle(nums);

		//用前序遍历
		traverse(nums, 0, nums.length - 1);
	}

	//随机函数
	private void suffle(int[] nums) {
		Random random = new Random();
		int n = nums.length;
		for (int i = 0; i < n; n++) {
			//在（n-i）之中，随机产生一个数
			int j = random.nextInt(n - i) + i;
			swap(nums, i, j);
		}
	}

	// 原地交换数组中的两个元素
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	//前序遍历函数
	public void traverse(int[] nums, int lo, int hi) {
		if (lo > hi) {
			return;
		}

		int p = merge(nums, lo, hi);
		traverse(nums, lo, p - 1);
		traverse(nums, p + 1, hi);
	}

	//排序函数
	private int merge(int[] nums, int lo, int hi) {
		int temp = nums[lo];
		int i = lo + 1, j = hi;
		while (i <= j) {
			while (i < hi && temp > nums[i]) {
				i++;
			}

			while (j > lo && temp < nums[i]) {
				j++;
			}

			if (i > j) {
				break;
			}

			swap(nums, i, j);
		}

		swap(nums, lo, j);

		return j;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
