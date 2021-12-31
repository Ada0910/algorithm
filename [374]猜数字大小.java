public class Solution extends GuessGame {
	public int guessNumber(int n) {
		int low = 1;
		int high = n;
		while (low < high) {
			int middle =low + (high-low)/2;
			// 答案在区间 [low, mid] 中
			int tmp = guess(middle);
			if (tmp<=0) {
				high = middle;
				// 答案在区间[mid+1, high]中
			}else{
				low = middle+1;
			}
		}

		return low;

	}
}
//leetcode submit region end(Prohibit modification and deletion)
