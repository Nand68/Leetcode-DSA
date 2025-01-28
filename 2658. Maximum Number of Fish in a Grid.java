class Solution {
    boolean[][] visited;

    public int findMaxFish(int[][] grid) {
        int maxScore = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != 0 && !visited[i][j]) {
                    maxScore = Math.max(maxScore, bfs(i, j, grid));
                }
            }
        }
        return maxScore;
    }

    public int bfs(int i, int j, int[][] grid) {
        visited[i][j] = true;
        int score = grid[i][j];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int l = 0; l < 4; l++) {
            int newr = i + dx[l];
            int newc = j + dy[l];
            if (newr >= 0 && newr < grid.length && newc >= 0 && newc < grid[0].length 
                && grid[newr][newc] != 0 && !visited[newr][newc]) {
                score += bfs(newr, newc, grid);
            }
        }
        return score;
    }
}
