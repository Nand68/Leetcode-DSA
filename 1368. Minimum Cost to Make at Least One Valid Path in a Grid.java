class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int[] nrow = {0,0,1,-1};
        int[] ncol = {1,-1,0,0};
        PriorityQueue<Pair> p = new PriorityQueue<>((a,b) -> Integer.compare(a.cost,b.cost));
        p.add(new Pair(0,0,0));  

        while(!p.isEmpty()){
            Pair cur = p.poll();
            int cost = cur.cost;
            int x = cur.i;
            int y = cur.j;
            if ( vis[x][y] == 1){
                continue;
            }
            if( x == n-1 && y == m-1){
                return cost;
            }
            vis[x][y] = 1;
            for(int i = 0; i < 4; i++){
                int newRow = x + nrow[i];
                int newCol = y + ncol[i];
                if( newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && vis[newRow][newCol] == 0){
                    int newcost = cost;
                    if ( i + 1 != grid[x][y]){
                        newcost++;
                    }
                    p.add(new Pair(newcost,newRow,newCol));
                }
            }
        }
        return 0;
    }
}
class Pair{
    int cost;
    int i;
    int j;
    Pair(int cost ,int i, int j){
        this.cost = cost;
        this.i = i;
        this.j = j;
    }
}
