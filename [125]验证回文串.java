

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public boolean isPalindrome(String s) {
		//1.先转化成小写,并处理好特殊符号
		s = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
		System.out.println(s);
		//2.转化成字符数组
		char[] arr = s.toCharArray();
		//长度
		int length = s.length();
		for (int i = 0, j = length - 1; i <= length / 2 &&  j >= (length +1)/ 2; i++, j--) {
			if (arr[i] != arr[j]) {
				return false;
			} else {
				continue;
			}
		}
		return true;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
