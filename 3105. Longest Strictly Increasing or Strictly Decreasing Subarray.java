class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length; 

        if(n == 0) return 0;
        int maxLength = 1, incr = 1, decr = 1;

        for(int i=1; i<n; i++){
            if(nums[i] > nums[i-1]){
                incr++; 
                decr = 1;
            } 
            else if(nums[i] < nums[i-1]){
                decr++;
                incr = 1;
            } 
            else{
                incr = 1;
                decr = 1;
            }
            maxLength = Math.max(maxLength, Math.max(incr, decr)); 
        }
        return maxLength;
    }
}
