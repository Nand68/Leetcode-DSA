class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] bread = new int[n];

        for ( int i = 0; i < edges.length; i++){
            int com = edges[i][1];
            bread[com]++;
        }
        int ans = -1;
        int ansC = 0;
        for ( int i = 0; i < n; i++){
            if( bread[i] == 0){
                ans = i;
                ansC++;
                if ( ansC > 1)
                {
                    return -1;
                }
            }
        }
        if ( ansC > 1) return -1;

        return ans; 
    }
}
