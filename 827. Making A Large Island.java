class Solution {

    int[][] dirs=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    int[] parent;
    int[] rank;

    public void union(int i,int j){
        int pi=find(i);
        int pj=find(j);
        if(pi==pj) return;
        if(rank[pi]>rank[pj]){
            rank[pi]+=rank[pj];
            parent[pj]=pi;
        }else{
            rank[pj]+=rank[pi];
            parent[pi]=pj;
        }
    }

    public int find(int i){
        if(parent[i]!=i){
            parent[i]=find(parent[i]);
        }
        return parent[i];
    }

    public int largestIsland(int[][] grid) {
        int n=grid.length;
        parent=new int[n*n];
        rank=new int[n*n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                parent[n*i+j]=n*i+j;
                rank[n*i+j]=1;
            }
        } 
        boolean visited[][]=new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]&&grid[i][j]==1){
                    compute(i,j,n,grid,visited);
                }
            }
        }
        // System.out.println(Arrays.toString(rank));
        int max=0;
        for(int i=0;i<rank.length;i++) max=Math.max(rank[i],max);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Set<Integer> st=new HashSet<>();
                if(grid[i][j]==0){
                    for(int k=0;k<4;k++){
                        int newx=dirs[k][0]+i;
                        int newy=dirs[k][1]+j;
                        if(newx>=0&&newy>=0&&newx<n&&newy<n&&grid[newx][newy]==1) st.add(find(newx*n+newy));
                    }
                }
                int newmax=1;
                for(int s:st) newmax+=rank[s];
                max=Math.max(max,newmax);
            }
        }
        return max;
    }

    public void compute(int i,int j,int n,int[][] grid,boolean[][] visited){
        visited[i][j]=true;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{i,j});
        while(!q.isEmpty()){
            int val[]=q.poll();
            for(int[] d:dirs){
                int newx=d[0]+val[0];
                int newy=d[1]+val[1];
                if(newx>=0&&newy>=0&&newx<n&&newy<n&&!visited[newx][newy]&&grid[newx][newy]==1){
                    union(val[0]*n+val[1],newx*n+newy);
                    visited[newx][newy]=true;
                    q.add(new int[]{newx,newy});
                }
            }
        }
    }

}
