

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public String addBinary(String a, String b) {
		//结果中间值
		int sum = 0;

		//结果集
		StringBuffer res = new StringBuffer();
		//从字符串的低位向高位遍历，所以计算的结果是需要反转的
		for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
			sum = sum + (i>=0?a.charAt(i) - '0':0);
			sum = sum + (j>=0? b.charAt(j) - '0':0);
			res.append(sum % 2);
			sum = sum / 2;
		}
		res.append(sum==1?sum:"");

		return res.reverse().toString();

	}
}
//leetcode submit region end(Prohibit modification and deletion)
