//<p>我们定义，在以下情况时，单词的大写用法是正确的：</p>
//
//<ul>
//	<li>全部字母都是大写，比如 <code>"USA"</code> 。</li>
//	<li>单词中所有字母都不是大写，比如 <code>"leetcode"</code> 。</li>
//	<li>如果单词不只含有一个字母，只有首字母大写，&nbsp;比如&nbsp;<code>"Google"</code> 。</li>
//</ul>
//
//<p>给你一个字符串 <code>word</code> 。如果大写用法正确，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>word = "USA"
//<strong>输出：</strong>true
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>word = "FlaG"
//<strong>输出：</strong>false
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= word.length &lt;= 100</code></li>
//	<li><code>word</code> 由小写和大写英文字母组成</li>
//</ul>
//<div><div>Related Topics</div><div><li>字符串</li></div></div><br><div><li>👍 195</li><li>👎 0</li></div>


import org.springframework.util.StringUtils;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public boolean detectCapitalUse(String word) {

		if (word.length() == 0) {
			return false;
		}

		char[] chars = word.toCharArray();
		char firstChar = chars[0];

		//首字母小写
		if (firstChar >= 'a' && firstChar <= 'z') {
			for (int i = 1; i < chars.length; i++) {
				boolean isLowCase = (chars[i] >= 'a' && chars[i] <= 'z');
				if (!isLowCase) {
					return false;
				}
			}
			return true;
		}

		int temp = 1;
		//首字母大写
		for (int i = 1; i < chars.length; i++) {
			boolean isUpCase = (chars[i] >= 'A' && chars[i] <= 'Z');
			boolean isLowCase = (chars[i] >= 'a' && chars[i] <= 'z');
			if (isUpCase) {
				temp++;
			}
		}

		if (temp != chars.length  && temp != 1) {
			return false;
		}


		return true;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
