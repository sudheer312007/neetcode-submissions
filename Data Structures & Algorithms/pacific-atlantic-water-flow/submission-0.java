
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] grid) {

        List<List<Integer>> ans = new ArrayList<>();
        int[][] pacificVisited = new int[grid.length][grid[0].length];
        int[][] atlanticVisited = new int[grid.length][grid[0].length];


        //pacific
        for (int i = 0; i < grid.length; i++) {
            int j = 0;
            if (canVisit(i, j, pacificVisited, grid, 0)) {
                pacificAtlanticHelper(i, j, pacificVisited, grid);

            }
        }

        for (int j = 0; j < grid[0].length; j++) {
            int i = 0;
            if (canVisit(i, j, pacificVisited, grid, 0)) {
                pacificAtlanticHelper(i, j, pacificVisited, grid);
            }
        }

        //atlantic
        for (int i = 0; i < grid.length; i++) {
            int j = grid[0].length - 1;
            if (canVisit(i, j, atlanticVisited, grid, 0)) {
                pacificAtlanticHelper(i, j, atlanticVisited, grid);
            }
        }

        for (int j = 0; j < grid[0].length; j++) {
            int i = grid.length - 1;
            if (canVisit(i, j, atlanticVisited, grid, 0)) {
                pacificAtlanticHelper(i, j, atlanticVisited, grid);
            }
        }


        for (int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++){
                if(pacificVisited[i][j] == 1 && atlanticVisited[i][j] ==1){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }

        return ans;
    }

    private void pacificAtlanticHelper(int row, int col, int[][] visited, int[][] grid) {

        visited[row][col] = 1;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (canVisit(newRow, newCol, visited, grid, grid[row][col])) {
                pacificAtlanticHelper(newRow, newCol, visited, grid);
            }
        }


    }

    private boolean canVisit(int row, int col, int[][] visited, int[][] grid, int currentHeight) {
        return row >= 0 && col >= 0 && row < visited.length && col < visited[0].length && visited[row][col] == 0 && grid[row][col] >= currentHeight;
    }
}
