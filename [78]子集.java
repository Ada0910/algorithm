import java.util.ArrayList;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	List<List<Integer>> res = new ArrayList<>();
	LinkedList temp = new LinkedList();

	public List<List<Integer>> subsets(int[] nums) {
		backtrack(nums, 0);
		return res;
	}

	public void backtrack(int[] nums, int start) {

		res.add(new LinkedList<>(temp));


		for (int i = start; i < nums.length; i++) {
			temp.add(nums[i]);
			backtrack(nums, i + 1);
			temp.removeLast();
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)
