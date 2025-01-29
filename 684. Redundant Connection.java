class Solution {
    int p[];
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        p = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }
        int ans[] = new int[2];
        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            if (find(u) != find(v)) {
                p[find(u)] = find(v);
            } else {
                ans = edge; 
            }
        }
        return ans;
    }
    public int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
