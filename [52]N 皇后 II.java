import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int res = 0;

    public int totalNQueens(int n) {
            // base case
            if (n <= 0) {
                return 0;
            }

            char[][] board = new char[n][n];
            for (char[] chars : board) {
                Arrays.fill(chars, '.');
            }

            backtrack(board, 0);
            return res;
        }

        void backtrack(char[][] board, int row) {
            //结束回溯的条件
            if (row == board.length) {
                res++;
                return;
            }
            int n = board[row].length;
            for (int i = 0; i < n; i++) {
                if (!isValid(board, row, i)) {
                    continue;
                }

                //做选择
                board[row][i] = 'Q';
                backtrack(board, row + 1);
                //撤销选择
                board[row][i] = '.';
            }

        }

        List<String> chaToString(char[][] board) {
            List<String> ans = new ArrayList<>();
            StringBuilder sb = null;
            for (int i = 0; i < board.length; i++) {
                sb = new StringBuilder();
                for (int j = 0; j < board[0].length; j++) {
                    sb.append(board[i][j]);
                }
                ans.add(sb.toString());
            }
            return ans;
        }

        private boolean isValid(char[][] board, int row, int col) {
            int rows = board.length;
            System.out.println(row +":" +col);
            for (char[] chars : board) {
                if (chars[col] == 'Q') {
                    return false;
                }
            }

            // 检查右上角是否有皇后，右下脚还没走过肯定没有皇后
            for (int i = row - 1, j = col + 1; i >= 0 && j < rows; i--, j++){
                if (board[i][j] == 'Q') {
                    return false;
                }
            }

            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }

            return true;
        }
}
//leetcode submit region end(Prohibit modification and deletion)
