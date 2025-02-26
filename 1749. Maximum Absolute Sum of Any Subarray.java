class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int totalForPositive = 0;
        int totalForNegative = 0;
        int maxOfPositive = Integer.MIN_VALUE;
        int maxOfNegative = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            totalForPositive += nums[i];
            totalForNegative += nums[i];
            
            maxOfPositive = Math.max(maxOfPositive, totalForPositive);
            maxOfNegative = Math.min(maxOfNegative, totalForNegative);
            
            if (totalForPositive < 0) totalForPositive = 0;
            if (totalForNegative > 0) totalForNegative = 0;
        }
        
        return Math.max(maxOfPositive, Math.abs(maxOfNegative));
    }
}
