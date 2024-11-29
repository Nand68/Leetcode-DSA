class Solution {
    private final int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int minimumTime(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        
        pq.add(new int[]{grid[0][0], 0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int row = curr[1];
            int col = curr[2];

            if (row == m - 1 && col == n - 1) {
                return time;
            }

            
            if (visited[row][col]) continue;
            visited[row][col] = true;

            for (int[] dir : direction) {
                int r = row + dir[0];
                int c = col + dir[1];

                if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c]) {
                    continue;
                }

                if (grid[r][c] <= time + 1) {
                    pq.add(new int[]{time + 1, r, c});
                } else if ((grid[r][c] - time) % 2 == 0) {
                    pq.add(new int[]{grid[r][c] + 1, r, c});
                } else {
                    pq.add(new int[]{grid[r][c], r, c});
                }
            }
        }
        return -1;
    }
}
