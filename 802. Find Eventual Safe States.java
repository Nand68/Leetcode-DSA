class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        ArrayList<ArrayList<Integer>> Graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Graph.add(new ArrayList<>());
        }
        int indegree[] = new int[n];
        for (int i = 0; i < n; i++) {
            for(int it : graph[i]){
                Graph.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);

            for (int neigh:Graph.get(curr)) {
                if (--indegree[neigh] == 0) {
                    q.add(neigh);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}


// class Solution {
//     public List<Integer> eventualSafeNodes(int[][] graph) {
//         int n = graph.length;
//         int[] vis = new int[n];
//         int[] path = new int[n];
//         int[] check = new int[n];
//         List<Integer> ans = new ArrayList<>();
//         for(int i = 0; i < n; i++){
//             if(vis[i] == 0){
//                 dfs(i,vis,path,check,graph);
                
//             }
//         }
//         for(int i = 0; i < n; i++){
//             if(check[i] == 1){
//                 ans.add(i);
//             }
//         }
//         return ans;
//     }
//     public boolean dfs(int node,int[] vis,int[] path,int[] check, int[][] adj){
//         vis[node] = 1;
//         path[node] = 1;

//         for(int it : adj[node]){
//             if(vis[it] == 0){
//                 if(dfs(it,vis,path,check,adj) == true) return true;
//             }
//             else if(path[it] == 1){
//                 return true;
//             }
//         }
//         check[node] = 1;
//         path[node] = 0;
//         return false;
//     }
// }
