class Solution {
      public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            if (!visited[i][0] && board[i][0] == 'O') {
                solveHelper(i, 0, board, visited);
            }

            if (!visited[i][board[0].length - 1] && board[i][board[0].length - 1] == 'O') {
                solveHelper(i, board[0].length - 1, board, visited);
            }
        }


        for (int j = 0; j < board[0].length; j++) {
            if (!visited[0][j] && board[0][j] == 'O') {
                solveHelper(0, j, board, visited);
            }

            if (!visited[board.length - 1][j] && board[board.length - 1][j] == 'O') {
                solveHelper(board.length - 1, j, board, visited);
            }
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(!visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }


    }

    private void solveHelper(int row, int col, char[][] board, boolean[][] visited) {
        visited[row][col] = true;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (canVisit(newRow, newCol, visited, board)) {
                solveHelper(newRow, newCol, board, visited);

            }
        }


    }

    private boolean canVisit(int row, int col, boolean[][] visited, char[][] grid) {
        return row >= 0 && col >= 0 && row < visited.length && col < visited[0].length && !visited[row][col] && grid[row][col] == 'O';
    }
}
