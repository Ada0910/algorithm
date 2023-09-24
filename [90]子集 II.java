import java.util.ArrayList;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		//记录「路径」
		LinkedList<Integer> track = new LinkedList<>();
		boolean[] used = new boolean[nums.length];
		Arrays.sort(nums);
		backtrack(res, nums, track, used, 0);
		return res;
	}

	//回溯算法
	public void backtrack(List<List<Integer>> res, int[] nums, LinkedList<Integer> track, boolean[] used, int start) {

		res.add(new LinkedList(track));

		for (int i = start; i < nums.length; i++) {
			if (used[i]) {
				continue;
			}

			if (i > start && nums[i] == nums[i - 1]) {
				continue;
			}


			track.add(nums[i]);
			used[i] = true;
			//选择
			backtrack(res, nums, track, used, i + 1);
			//撤销选择
			track.removeLast();
			used[i] = false;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)
