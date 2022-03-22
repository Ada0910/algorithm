

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int strStr(String haystack, String needle) {
		if (needle.isEmpty()) {
			return 0;
		}

		if (haystack.isEmpty()) {
			return -1;
		}

		if (haystack.length() < needle.length()) {
			return -1;
		}

		if (haystack.length() == needle.length() && !haystack.equals(needle)) {
			return -1;
		}


		char[] a = haystack.toCharArray();
		char[] b = needle.toCharArray();

		for (int i = 0; i < a.length; i++) {
			if (a[i] == b[0]) {
				if (needle.equals(haystack.substring(i, i + needle.length()-1))) {
					return i;
				}
			}
		}

		return -1;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
