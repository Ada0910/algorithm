//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char findTheDifference(String s, String t) {
        char r = '0';
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        if(schar.length==0){
            return tchar[0];
        }
        int flag = 0;
        for (int j = 0; j < tchar.length; j++) {
            int temp = 0;
            for (int i = 0; i < schar.length; i++) {
                if (schar[i] == tchar[j] ) {
                  continue;
                }
                temp++;


            }
            if(temp!=schar.length-1){
              r=  tchar[j];
            }
        }
      return r;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
