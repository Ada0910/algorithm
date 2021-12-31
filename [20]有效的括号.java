import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public boolean isValid(String s) {

		if (s.length() % 2 != 0 || s.length() == 0) {
			return false;
		}

		Map<Character, Character> map = new HashMap<>(3);
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');

		Stack<Character> stack = new Stack<>();
		char[] res = s.toCharArray();
		for (char c : res) {

			//左括号，入栈
			if (map.containsKey(c)) {
				stack.push(c);
				continue;
			}

			////右括号，出栈 stack.pop()- 左括号
			if (stack.isEmpty() || !map.get(stack.pop()).equals(c)) {
				return false;
			}

		}


		return stack.isEmpty();
	}
}
//leetcode submit region end(Prohibit modification and deletion)
