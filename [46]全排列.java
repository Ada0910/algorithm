import java.util.ArrayList;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		//记录「路径」
		LinkedList<Integer> track = new LinkedList<>();
		boolean[] used = new boolean[nums.length];
		backtrack(res, nums, track,used);
		return res;
	}

	//回溯算法
	public void backtrack(List<List<Integer>> res, int[] nums, LinkedList<Integer> track, boolean[] used) {

		//条件为空
		if (track.size() == nums.length) {
			res.add(new LinkedList(track));
			return;
		}


		for (int i = 0; i < nums.length; i++) {
			if (used[i]) {
				continue;
			}


			track.add(nums[i]);
			used[i] = true;
			//选择
			backtrack(res, nums, track, used);
			//撤销选择
			track.removeLast();
			used[i] = false;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)
