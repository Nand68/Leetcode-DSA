class Solution {
    public int[] minOperations(String s) {
        int n = s.length();
        int[] ans = new int[n];
        // int[] dp = new int[n+1];
        for(int i = 0; i < n; i++){
            int count = 0;
            for ( int j = i; j >= 0; j--){
                if ( s.charAt(j) == '1'){
                    count = count + ( i - j);
                }
            }
            for( int j = i; j < n; j++){
                if ( s.charAt(j) == '1'){
                    count = count + ( j - i);
                }
            }
            // dp[i] = count;
            ans[i] = count;
        }
        return ans;
    }
}
