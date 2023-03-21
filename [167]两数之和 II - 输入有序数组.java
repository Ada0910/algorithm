

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int[] twoSum(int[] numbers, int target) {
		//左指针
		int left = 0;
		//右指针
		int right = numbers.length - 1;
		while (left <= right) {
			int result = numbers[left] + numbers[right];
			//加起来小，左指针右移 
			if (result== target) {
				return new int[]{left+1,right+1};
			} else if (result < target) {
				left++;
			} else {
				right--;
			}

		}

		return new int[]{-1, -1};
	}
}
//leetcode submit region end(Prohibit modification and deletion)
