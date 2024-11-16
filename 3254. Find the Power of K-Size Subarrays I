class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;

        int[] result = new int[n - k + 1];

        java.util.Arrays.fill(result, -1);

        int count = 1;
        if ( nums.length == 1){
            return nums;
        }

        for (int i = 1; i < k; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else {
                count = 1;
            }
        }

        
        if (count == k) {
            result[0] = nums[k - 1];
        }

        int i = 1;
        int j = k;


        while (j < n) {
            if (nums[j] == nums[j - 1] + 1) {
                count++;
            } else {
                count = 1;
            }

            if (count >= k) {
                result[i] = nums[j];
            }

            i++;
            j++;
        }

        return result;
    }
}
