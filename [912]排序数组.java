import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	// 用于辅助合并有序数组
	private static int[] temp;

	public int[] sortArray(int[] nums) {
		temp = new int[nums.length];
		sort(nums, 0, nums.length - 1);
		return nums;
	}

	/* 排序函数*/
	public void sort(int[] nums, int lo, int hi) {
		if (lo == hi) {
			return;
		}

		int mid = lo + (hi - lo) / 2;
		sort(nums, lo, mid);
		sort(nums, mid + 1, hi);
		merge(nums, lo, mid, hi);
	}

	/* 合并之后排序函数*/
	public void merge(int[] nums, int lo, int mid, int hi) {
		System.out.println("merge"+ lo +":"+ mid +":"+ hi );
		for (int i = lo; i <= hi; i++) {
			temp[i] = nums[i];
		}
		//i是会加的，从lo开始
		int i = lo;
		// j也是会递增的，从mid+1开始
		int j = mid + 1;

		for (int p = lo; p <= hi; p++) {
			// 左边的合并完了，右边直接合并过去
			if (i == mid + 1) {
				nums[p] = temp[j++];
			} else if (j == hi + 1) {
				nums[p] = temp[i++];
			} else if (temp[i] > temp[j]) {
				nums[p] = temp[j++];
			} else {
				nums[p] = temp[i++];
			}

		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)
