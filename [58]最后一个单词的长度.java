

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int lengthOfLastWord(String s) {
		String[] res = s.split(" ");
		return res[res.length-1].length();
	}
}
//leetcode submit region end(Prohibit modification and deletion)
