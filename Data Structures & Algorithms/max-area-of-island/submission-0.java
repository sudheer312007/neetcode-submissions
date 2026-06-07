class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islands = 0;
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (canVisit(i, j, visited, grid)) {
                    islands++;
                    int area = maxAreaOfIslandHelper(i, j, visited, grid);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int maxAreaOfIslandHelper(int row, int col, boolean[][] visited, int[][] grid) {

        visited[row][col] = true;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int numberofSites = 0;
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (canVisit(newRow, newCol, visited, grid)) {
                numberofSites += maxAreaOfIslandHelper(newRow, newCol, visited, grid);
            }
        }

        return 1 + numberofSites;


    }

    private boolean canVisit(int row, int col, boolean[][] visited, int[][] grid) {
        return row >= 0 && col >= 0 && row < visited.length && col < visited[0].length && !visited[row][col] && grid[row][col] == 1;
    }
}
