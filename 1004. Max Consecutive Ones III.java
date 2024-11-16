class Solution {
    public int longestOnes(int[] nums, int k) {
        int zero = 0;
        int l = 0;
        int r = 0;
        int max = 0;
        while ( r < nums.length){
            if (nums[r] == 0) zero++;

            while ( zero > k){
                if ( nums[l] == 0) zero--;
                l++;
            }
            r++;
            max = Math.max(max,r-l+1);
        }
        return max-1;
    }
}
