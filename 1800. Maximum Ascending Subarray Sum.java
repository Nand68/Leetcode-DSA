class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxAns = Integer.MIN_VALUE;
        int dog = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                
                dog = nums[i];
            }
            else if(nums[i] > nums[i-1]){
                dog += nums[i];
            }
            else{
                dog = nums[i];
            }
            maxAns = Math.max(maxAns,dog);
        }
        return maxAns;
    }
}
