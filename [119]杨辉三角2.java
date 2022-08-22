import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        //第一行
        if(rowIndex ==0){
            return new ArrayList<>(Arrays.asList(1));
        }

        //第二行
        if(rowIndex==1){
            return new ArrayList<>(Arrays.asList(1,1));
        }

        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            row.add(0);
            for (int j = i; j >0; j--) {
                row.set(j,row.get(j)+row.get(j-1));
            }
        }
        return row;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
