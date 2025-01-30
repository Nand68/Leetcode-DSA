class Solution {
   ArrayList<Integer>arr=new ArrayList<>();
    public int magnificentSets(int n, int[][] edges) {
        int ans=0;
       ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
       for(int i=0;i<=n;i++)adj.add(new ArrayList<>());
       for(int it[]:edges){
           adj.get(it[0]).add(it[1]);
           adj.get(it[1]).add(it[0]);
       } 
       System.out.println(adj);
       int[]vis=new int[n+1];
       int[]d=new int[n+1];
      

     
       for(int i=1;i<=n;i++){
             
             if(vis[i]==0){
                 dfs(i,adj,vis);
             
             int t=-1;
            for(int j:arr){
               t=Math.max(t,bfs(j,adj));
            }
            if(t==-1)return -1;
            ans+=t;
            arr.clear();
             }
       }
      
     
       return ans;
    }
    public boolean isValid( ArrayList<ArrayList<Integer>>adj){
        int[]vis=new int[adj.size()];
        Arrays.fill(vis,-1);
        
       
        Queue<Integer>q=new ArrayDeque<>();
        vis[1]=0;
        q.offer(1);
        while(q.size()>0){
            int x=q.poll();
            for(int it:adj.get(x)){
               if(vis[it]==-1){
                    if(vis[x]==0){
                        vis[it]=1;
                        q.offer(it);
                    }
                    else {
                        vis[it]=0;
                        q.offer(it);
                    }
               }
               else{
                   if(vis[it]==vis[x])return false;
                   
               }
            }
        }
        
        return true;
    }
    public int bfs(int n,ArrayList<ArrayList<Integer>>adj){
               int[]dis=new int[adj.size()];
               Arrays.fill(dis,(int)1e9);
        Queue<Integer>q=new ArrayDeque<>();
     
        q.offer(n);
        dis[n]=1;
        int s=1;
        while(q.size()>0){
           
          
          int x=q.poll();
                 
            
           
                 
                for(int it:adj.get(x)){
                    if(dis[it]==(int)1e9){
                        dis[it]=dis[x]+1;
                        s=dis[it];
                       q.offer(it);
                    }
                
            }
        
        }
        for(int i:arr){
            if(dis[i]==(int)1e9){
                dis[i]=++s;
            }
        }
        for(int i:arr){
            for(int it:adj.get(i))
            if(Math.abs(dis[i]-dis[it])!=1)return -1;
        }
       
        return s;
    }
    public void dfs(int n,ArrayList<ArrayList<Integer>>adj,int[]vis){
     arr.add(n);
        vis[n]=1;
        for(int it:adj.get(n)){
           if(vis[it]==0) dfs(it,adj,vis);
        }
        
    }
}
