class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int left = 0, bitmask = 0, ans = 0;

        for (int right = 0; right < n; right++) {
            while ((bitmask & nums[right]) != 0) {
                bitmask ^= nums[left]; 
                left++;
            }
            bitmask |= nums[right];
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
