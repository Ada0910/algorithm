import java.util.Arrays;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	LinkedList<String> track = new LinkedList();
	int[] memo;

	public boolean wordBreak(String s, List<String> wordDict) {
		memo = new int[s.length()];
		Arrays.fill(memo, -1);
		return backtrack(s, 0, wordDict);
	}

	boolean backtrack(String s, int i, List<String> wordDict) {
		if (i == s.length()) {
			return true;
		}

		if (memo[i] != -1){
			return memo[i] == 0 ? false : true;
		}

		for (int len = 1; i + len <= s.length(); len++) {
			String prefix = s.substring(i, i + len);
			if (wordDict.contains(prefix)) {
				if (backtrack(s, i + len, wordDict) == true) {
					memo[i] = 1;
					return true;
				}
			}

		}
		memo[i] = 0;
		return false;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
