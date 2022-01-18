

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		//上指针
		int front = 0;
		//下指针
		int end = 1;

		while (end < nums.length) {
			if(nums[front]!= nums[end]){
				//将下指针的元素复制给上指针的后一个，然后上指针向右移动一位
				nums[front+1]=nums[end];
				//移动上指针
				front++;
			}
			//移动下指针
			end++;
		}


		return front+1;

	}
}
//leetcode submit region end(Prohibit modification and deletion)
