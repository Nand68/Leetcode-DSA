class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int mod = 1000000007;
        Integer[] dp = new Integer[high + 1]; 
        return countWays(low, high, zero, one, 0, dp, mod);
    }

    private int countWays(int low, int high, int zero, int one, int n, Integer[] dp, int mod) {
        if (n > high) return 0; 
        if (dp[n] != null) return dp[n];

        int count = 0;
        if (n >= low) count = 1; 

        count = (count + countWays(low, high, zero, one, n + zero, dp, mod)) % mod;
        count = (count + countWays(low, high, zero, one, n + one, dp, mod)) % mod;

        return dp[n] = count;
    }
}
