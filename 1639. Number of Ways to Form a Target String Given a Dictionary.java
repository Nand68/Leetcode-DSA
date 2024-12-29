class Solution {
    public int numWays(String[] words, String target) {
        int MOD = 1_000_000_007;
        int k = words[0].length();
        int m = target.length();
        long[][] freq = new long[26][k];
        for (String word : words) {
            for (int col = 0; col < k; col++) {
                freq[word.charAt(col) - 'a'][col]++;
            }
        }
        long[][] dp = new long[m + 1][k + 1];
        dp[0][0] = 1; 

        for (int i = 0; i <= m; i++) { 
            for (int j = 0; j <= k; j++) { 
                if (j < k) {
                    dp[i][j + 1] = (dp[i][j + 1] + dp[i][j]) % MOD;
                }
                if (i < m && j < k) {
                    dp[i + 1][j + 1] = (dp[i + 1][j + 1] + freq[target.charAt(i) - 'a'][j] * dp[i][j]) % MOD;
                }
            }
        }

        return (int) dp[m][k];
    }
}
