class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
  public int orangesRotting(int[][] grid) {
        int timeTaken = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        boolean orangesPresent = false;

        Queue<Pair> que = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    visited[i][j] = true;
                    que.offer(new Pair(i, j));
                }
                if (grid[i][j] == 1) {
                    orangesPresent = true;
                }
            }
        }

        if(que.isEmpty() && !orangesPresent){
            return 0;
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int levels = -1;
        while (!que.isEmpty()) {
            int currentLevelSize = que.size();
            levels++;

            while (currentLevelSize > 0) {
                Pair pair = que.poll();
                currentLevelSize--;
                for (int[] direction : directions) {
                    int newRow = pair.row + direction[0];
                    int newCol = pair.col + direction[1];
                    if (canRot(newRow, newCol, visited, grid)) {
                        visited[newRow][newCol] = true;
                        que.offer(new Pair(newRow, newCol));
                    }
                }

            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    return -1;
                }
            }
        }

        return levels;
    }


    private boolean canRot(int row, int col, boolean[][] visited, int[][] grid) {
        return row >= 0 && col >= 0 && row < visited.length && col < visited[0].length && !visited[row][col] && grid[row][col] == 1;
    }
}
