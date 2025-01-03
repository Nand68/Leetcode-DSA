class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        ans[n-1] = nums[n-1];

        for (int i = n - 2; i >= 0; i--) {
            ans[i] = nums[i] + ans[i + 1];
        }

        int count = 0;
        long total = 0;

        for (int i = 0; i < n - 1; i++) {
            total += nums[i];
            
            if (total >= ans[i + 1]) {
                count++;
            }
        }

        return count;
    }
}
