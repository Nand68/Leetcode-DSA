class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] adjList = new ArrayList[n];
        for ( int i = 0; i < n; i++){
            adjList[i] = new ArrayList<>();
        }
        for ( int[] edge : edges){
            int node1 = edge[0];
            int node2 = edge[1];
            adjList[node1].add(node2);
            adjList[node2].add(node1);
        }
        int[] componetCount = new int[1];
        dfs(0,-1,adjList,values,k,componetCount);
        return componetCount[0];
    }
    long dfs(int currentNode, int parentNode, List<Integer>[] adjList, int[] nodeValues, int k, int[] componetCount){
        long sum = 0;
        for( int neighborNode : adjList[currentNode]){
            if ( neighborNode != parentNode){
                sum += dfs(neighborNode, currentNode,adjList,nodeValues,k,componetCount);
            }
        }
        sum += nodeValues[currentNode];
        if(sum%k == 0){
            componetCount[0]++;
            sum=0;
        }
        return sum;
    }
}
