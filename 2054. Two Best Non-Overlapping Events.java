class Solution {
    private int n;
    int dp[][] = new int[100001][3];
    public int maxTwoEvents(int[][] events) {
        n = events.length;
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        return solve(events,0,0);
    }

    public int solve(int[][] events,int i,int count){
        if ( count == 2 || i >= n){
            return 0;
        }
        if ( dp[i][count] != -1){
            return dp[i][count];
        }
        int nextValidEventIndex = binarySearch(events, events[i][1]);
        int take = events[i][2] + solve(events,nextValidEventIndex,count+1);
        int notake = solve(events,i+1,count);

        return dp[i][count] = Math.max(take,notake);
    }
    public int binarySearch(int[][] events,int end){
        int low = 0;
        int high = n - 1;
        int ans = n;
        while ( low <= high){
            int mid = ( low + high) / 2;
            if ( events[mid][0] > end){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}
