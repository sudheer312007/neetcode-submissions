class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        solveNQueensHelper(0, board, ans);
        return ans;
    }

    private void solveNQueensHelper(int col, boolean[][] board, List<List<String>> ans) {

        if (col == board.length) {
            List<String> newAns = new ArrayList<>();
            for (boolean[] booleans : board) {
                String str = "";
                for (boolean aBoolean : booleans) {
                    if (aBoolean) {
                        str += "Q";
                    } else {
                        str += ".";
                    }
                }
                newAns.add(str);
            }
            ans.add(newAns);
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (weCanPutQueen(board, i, col)) {
                board[i][col] = true;
                solveNQueensHelper(col + 1, board, ans);
                board[i][col] = false;
            }
        }
    }

    private boolean weCanPutQueen(boolean[][] board, int i, int j) {
        int newI = i;
        int newJ = j;

        //leftrow

        while (newJ >= 0) {
            if(board[newI][newJ]){
                return false;
            }
            newJ--;
        }


        // top left diagonal
        newI = i;
        newJ = j;

        while(newJ >= 0 && newI >=0){
            if(board[newI][newJ]){
                return false;
            }
            newI--;
            newJ--;

        }



        // bottom left diagonal
        newI = i;
        newJ = j;

        while(newJ >= 0 && newI < board.length){
            if(board[newI][newJ]){
                return false;
            }
            newI++;
            newJ--;

        }

        return true;


    }
}
