

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int climbStairs(int n) {
		/**
		 * 方法一
		 *
		 * 	执行耗时:0 ms,击败了100.00% 的Java用户
		 * 	内存消耗:37.9 MB,击败了81.18% 的Java用户
		 */
		if (n == 1 || n == 2) {
			return n;
		}
		int[] array = new int[n];
		array[0] = 1;
		array[1] = 2;
		for (int i = 2; i < n; i++) {
			array[i] = array[i - 2] + array[i - 1];
		}
		return array[n - 1];

		/**
		 * 方法二
		 *
		 * 执行耗时:0 ms,击败了100.00% 的Java用户
		 * 内存消耗:38.3 MB,击败了33.26% 的Java用户
		 */
		//int p = 0, q = 0, r = 1;
		//for (int i = 1; i <= n; ++i) {
		//	p = q;
		//	q = r;
		//	r = p + q;
		//}
		//return r;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
