//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while (left<=right){
            int middle = (left+right)/2;
            if(nums[middle]>=target){
                right = middle-1;
            }else{
                left = middle+1;
            }
        }

        return left;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
