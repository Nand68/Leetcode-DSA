class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1; 
        int high = Arrays.stream(nums).max().getAsInt(); 

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canDivide(nums, maxOperations, mid)) {
                high = mid; 
            } else {
                low = mid + 1; 
            }
        }
        return low;
    }

    private boolean canDivide(int[] nums, int maxOperations, int maxBagSize) {
        int operations = 0;
        for (int num : nums) {
            if (num > maxBagSize) {
                operations += (num - 1) / maxBagSize;
                if (operations > maxOperations) {
                    return false; 
                }
            }
        }
        return true;
    }
}
