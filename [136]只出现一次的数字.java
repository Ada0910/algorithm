

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int singleNumber(int[] nums) {
		int result = nums[0];
		for(int i=1;i<nums.length;i++){
			result = nums[i]^result;
		}
		return result;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
