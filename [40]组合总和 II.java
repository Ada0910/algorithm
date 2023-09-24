import java.util.ArrayList;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		//记录「路径」
		LinkedList<Integer> track = new LinkedList<>();
		boolean[] used = new boolean[candidates.length];
		int trackSum = 0;
		Arrays.sort(candidates);
		backtrack(res, candidates, track, used, 0, target, trackSum);
		return res;
	}

	//回溯算法
	public void backtrack(List<List<Integer>> res, int[] nums, LinkedList<Integer> track, boolean[] used, int start, int target, int trackSum) {
		if (target == trackSum) {
			res.add(new LinkedList(track));
			return;
		}

		if (target < trackSum) {
			return;
		}


		for (int i = start; i < nums.length; i++) {
			if (used[i]) {
				continue;
			}

			if (i > start && nums[i] == nums[i - 1]) {
				continue;
			}


			track.add(nums[i]);
			trackSum = trackSum + nums[i];
			used[i] = true;
			//选择
			backtrack(res, nums, track, used, i + 1,target,trackSum);
			//撤销选择
			track.removeLast();
			trackSum = trackSum - nums[i];
			used[i] = false;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)
