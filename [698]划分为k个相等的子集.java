//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public boolean canPartitionKSubsets(int[] nums, int k) {
		if (k > nums.length) {
			return false;
		}
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			res = res + nums[i];
		}

		if (res % k != 0) {
			return false;
		}

		int target = res / k;

		boolean[] used = new boolean[nums.length];
		return backtrack(k, 0, nums, 0, used, target);
	}

	public boolean backtrack(int k, int bucket, int[] nums, int start, boolean[] used, int target) {
		if (k == 0) {
			return true;
		}


		if (bucket == target) {
			return backtrack(k - 1, 0, nums, 0, used, target);
		}

		for (int i = start; i < nums.length; i++) {
			if (used[i]) {
				continue;
			}

			if (bucket + nums[i] > target) {
				continue;
			}

			used[i] = true;
			bucket = bucket + nums[i];
			boolean f = backtrack(k, bucket, nums, i + 1, used, target);
			if (f) {
				return true;
			}
			used[i] = false;
			bucket = bucket - nums[i];
		}

		return false;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
