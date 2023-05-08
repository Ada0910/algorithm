import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
// 解法一：
//class Solution {
//	// 用于辅助合并有序数组
//	private static int[] temp;
//
//	public int[] sortArray(int[] nums) {
//		temp = new int[nums.length];
//		sort(nums, 0, nums.length - 1);
//		return nums;
//	}
//
//	/* 排序函数*/
//	public void sort(int[] nums, int lo, int hi) {
//		if (lo == hi) {
//			return;
//		}
//
//		int mid = lo + (hi - lo) / 2;
//		sort(nums, lo, mid);
//		sort(nums, mid + 1, hi);
//		merge(nums, lo, mid, hi);
//	}
//
//	/* 合并之后排序函数*/
//	public void merge(int[] nums, int lo, int mid, int hi) {
//		System.out.println("merge"+ lo +":"+ mid +":"+ hi );
//		for (int i = lo; i <= hi; i++) {
//			temp[i] = nums[i];
//		}
//		//i是会加的，从lo开始
//		int i = lo;
//		// j也是会递增的，从mid+1开始
//		int j = mid + 1;
//
//		for (int p = lo; p <= hi; p++) {
//			// 左边的合并完了，右边直接合并过去
//			if (i == mid + 1) {
//				nums[p] = temp[j++];
//			} else if (j == hi + 1) {
//				nums[p] = temp[i++];
//			} else if (temp[i] > temp[j]) {
//				nums[p] = temp[j++];
//			} else {
//				nums[p] = temp[i++];
//			}
//
//		}
//	}
//}

//解法二：
class Solution {
	public int[] sortArray(int[] nums) {
		//	//写一个随机函数，打乱数组
		suffle(nums);
		sort(nums, 0, nums.length - 1);
		return nums;
	}

	////随机函数
	private void suffle(int[] nums) {
		Random random = new Random();
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			//在（n-i）之中，随机产生一个数
			int j = random.nextInt(n - i) + i;
			swap(nums, i, j);
		}
	}

	//// 原地交换数组中的两个元素
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	////前序遍历函数
	public void sort(int[] nums, int lo, int hi) {
		if (lo >= hi) {
			return;
		}

		int p = merge(nums, lo, hi);
		sort(nums, lo, p - 1);
		sort(nums, p + 1, hi);
	}

	////排序函数
	private int merge(int[] nums, int lo, int hi) {
		int temp = nums[lo];
		int i = lo + 1, j = hi;
		while (i <= j) {
			while (i < hi && temp >= nums[i]) {
				i++;
			}

			while (j > lo && temp < nums[j]) {
				j--;
			}

			if (i >= j) {
				break;
			}

			swap(nums, i, j);
		}

		swap(nums, lo, j);

		return j;
	}


}
//leetcode submit region end(Prohibit modification and deletion)
