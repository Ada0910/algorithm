

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void reverseString(char[] s) {
        //左指针
        int left = 0;
        //右指针
        int right = s.length-1;
        while(left<right){
            char temp = s[left];
            s[left] =  s[right];
            s[right] = temp;
            right--;
            left++;
            
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
