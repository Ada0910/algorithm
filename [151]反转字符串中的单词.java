//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public String reverseWords(String s) {
		//思路
		s= s.replaceAll("\\s+"," ").trim();
		s=reverse(s).trim();
		System.out.println("第一个S："+s);

		StringBuffer buffer = new StringBuffer();
		for (String s1 : s.split(" ")) {
			System.out.println("原："+s1+",转化 ："+reverse(s1));
			buffer.append(reverse(s1)).append(" ");
		}
		return  buffer.toString().trim();
	}

	/*辅助函数*/
	//函数的定义，传入一个字符串，然后将字符串反转输出
	String reverse(String s) {
		char[] chars = s.toCharArray();
		int i = 0, j = chars.length- 1;
		while (j > i) {
			char temp =chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
			i++;
			j--;
		} return String.valueOf(chars);
	}
}
//leetcode submit region end(Prohibit modification and deletion)
