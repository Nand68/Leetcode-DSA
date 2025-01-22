class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if( isWater[i][j] == 1){
                    q.add(new Pair(i,j,0));
                    isWater[i][j] = 0;
                    vis[i][j] = 1;
                }
            }
        }
        int[] nrow = {-1,0,1,0};
        int[] ncol = {0,1,0,-1};
        while (!q.isEmpty()){
            Pair curr = q.poll();
            for(int i = 0; i < 4; i++){
                int lrow = curr.i + nrow[i];
                int lcol = curr.j + ncol[i];
                if( lrow >= 0 && lrow < n && lcol >= 0 && lcol < m && vis[lrow][lcol] == 0){
                    vis[lrow][lcol] = 1;
                    q.add(new Pair(lrow,lcol,curr.value+1));
                    isWater[lrow][lcol] = curr.value+1;
                }
            }
        }
        return isWater;
    }
}

class Pair{
    int i;
    int j;
    int value;
    Pair(int i, int j, int value){
        this.i = i;
        this.j = j;
        this.value = value;
    }
}
