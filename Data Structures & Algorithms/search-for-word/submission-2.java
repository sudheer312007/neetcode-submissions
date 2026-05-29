class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[] ans = new boolean[1];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    visited[i][j] = true;
                    existsHelper(board, word, i, j, 1, ans, visited);
                    if (ans[0]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private void existsHelper(char[][] board, String word, int row, int col, int strIdx, boolean[] ans, boolean[][] visited) {
        if (strIdx == word.length()) {
            ans[0] = true;
            return;
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (foundNext(board, word, strIdx, newRow, newCol, visited)) {
                visited[newRow][newCol] = true;
                existsHelper(board, word, newRow, newCol, strIdx+1, ans, visited);
                visited[newRow][newCol]=false;
            }
        }


    }

    private boolean foundNext(char[][] board, String word, int strIdx, int newRow, int newCol, boolean[][] visited) {
        if (newRow >= 0 && newCol >= 0 && newRow < board.length && newCol < board[0].length) {
            return board[newRow][newCol] == word.charAt(strIdx) && !visited[newRow][newCol];
        }
        return false;

    }
}
