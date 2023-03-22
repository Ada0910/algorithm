

//leetcode submit region begin(Prohibit modification and deletion)
//class NumArray {
//    
//    public int[] nums ;
//
//    public NumArray(int[] nums) {
//        this.nums = nums;
//    }
//    
//    public int sumRange(int left, int right) {
//        //解法一：
//        int res = 0;
//        for (int i = left; i <= right; i++) {
//            res = nums[i]+res;
//        }
//
//        return res;
//    }
//}

//解法二：先预处理，然后再进行调用
class NumArray {

    public int[] preNums ;

    public NumArray(int[] nums) {
        preNums = new int[nums.length+1];
        for (int i = 1; i < preNums.length; i++) {
            preNums[i] = preNums[i-1]+nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
       return preNums[right+1]-preNums[left];
    }

    //解法二：先预处理，然后再进行调用

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)
