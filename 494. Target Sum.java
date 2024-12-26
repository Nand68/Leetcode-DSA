class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        if (totalSum < target || (totalSum + target) % 2 != 0) return 0;
        int subsetSum = (totalSum + target) / 2;
        if (subsetSum < 0) return 0;
        int[] dp = new int[subsetSum + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = subsetSum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[subsetSum];
    }
}
