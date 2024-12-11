class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int maxVal = 1000000;
        int[] arr = new int[maxVal + 2]; 

        
        for (int num : nums) {
            int start = Math.max(0, num - k); 
            int end = Math.min(maxVal, num + k) + 1;
            arr[start]++;
            arr[end]--;
        }

        
        int maxFreq = 0;
        int currentFreq = 0;
        for (int i = 0; i <= maxVal; i++) {
            currentFreq += arr[i];
            maxFreq = Math.max(maxFreq, currentFreq);
        }

        return maxFreq;
    }
}
