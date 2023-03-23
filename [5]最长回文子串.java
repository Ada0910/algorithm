

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        //思路一,用一个循环，把每个字符都加进来，然后反复循环更新
        String res  ="";
        for (int i = 0; i <s.length() ; i++) {
            //奇数
            String s1 = palindrome(s,i,i);
            //偶数
            String s2 = palindrome(s,i,i+1);
            res = s1.length()>res.length()?s1:res;
            res = s2.length()>res.length()?s2:res;
            
        }
        
        return res ;

    }
    
    //写一个函数，大概是从中间开始往两端扩展找最大的回文字符串
    public String palindrome(String s,int left ,int right){
        //从中间出发，左指针左移，右指针右移
        while(left>=0&& right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
