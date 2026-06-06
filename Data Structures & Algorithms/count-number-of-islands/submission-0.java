class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (canVisit(i, j, visited, grid)) {
                    islands++;
                    numIslandsHelper(i, j, visited, grid);
                }
            }
        }
        return islands;
    }

    private void numIslandsHelper(int row, int col, boolean[][] visited, char[][] grid) {

        visited[row][col] = true;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[] rows = {-1, 0, 1};
        int[] cols = {-1, 0, 1};

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (canVisit(newRow, newCol, visited, grid)) {
                numIslandsHelper(newRow, newCol, visited, grid);

            }
        }


    }

    private boolean canVisit(int row, int col, boolean[][] visited, char[][] grid) {
        return row >= 0 && col >= 0 && row < visited.length && col < visited[0].length && !visited[row][col] && grid[row][col] == '1';
    }
}
