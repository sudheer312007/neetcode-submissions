
class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}


class Solution {
    
     public void islandsAndTreasure(int[][] mat) {
        Queue<Pair> que = new LinkedList<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    que.offer(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int level = 0;

        while (!que.isEmpty()) {
            int currentLevelSize = que.size();

            while (currentLevelSize > 0) {
                currentLevelSize--;
                Pair pair = que.poll();
                mat[pair.row][pair.col] = level;

                for (int[] direction : directions) {
                    int newRow = pair.row + direction[0];
                    int newCol = pair.col + direction[1];

                    if (canVisit(newRow, newCol, visited, mat)) {
                        visited[newRow][newCol] = true;
                        que.offer(new Pair(newRow, newCol));
                    }
                }
            }
            level++;
        }


    }


    private boolean canVisit(int row, int col, boolean[][] visited, int[][] mat) {
        return row >= 0 && col >= 0 && row < visited.length && col < visited[0].length && !visited[row][col] && mat[row][col]== Integer.MAX_VALUE;
    }
}
