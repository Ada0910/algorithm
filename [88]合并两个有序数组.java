import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		for (int i = 0; i != n; ++i) {
			nums1[m + i] = nums2[i];
		}

		//临时数组
		int[] temp = new int[m + n];
		//nums1指针
		int i = 0;
		//mums2指针
		int j = m;
		int k = 0;
		while (i <= m-1 && j <= m+n-1) {
			if (nums1[i] <= nums1[j]) {
				temp[k++] = nums1[i++];
			} else {
				temp[k++] = nums1[j++];
			}
		}

		// 把左边剩余的数移入数组
		while (i <= m-1) {
			temp[k++] = nums1[i++];
		}
		// 把右边边剩余的数移入数组
		while (j <= m+n-1) {
			temp[k++] = nums1[j++];
		}
		// 把新数组中的数覆盖nums数组
		for (int k2 = 0; k2 < temp.length; k2++) {
			nums1[k2 ] = temp[k2];
		}

	}
}
//leetcode submit region end(Prohibit modification and deletion)
