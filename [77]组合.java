import java.util.ArrayList;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	List<List<Integer>> res = new ArrayList<>();
	LinkedList<Integer> track = new LinkedList<>();

	public List<List<Integer>> combine(int n, int k) {
		backtrack(n, k, 1);
		return res;
	}

	public void backtrack(int n, int k, int start) {
		if (k == track.size()) {
			res.add(new LinkedList<>(track));
			return;
		}

		for (int i = start; i <= n; i++) {
			track.add(i);
			backtrack(n, k, i + 1);
			track.removeLast();
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)
