class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low = 1, high = (long)1e14;
        
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (helper(ranks, mid, cars)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean helper(int[] ranks, long mid, int cars) {
        long ans = 0;
        
        for (int rank : ranks) {
            ans += (long) Math.sqrt((double) mid / rank);
            if (ans >= cars) return true; 
        }
        
        return ans >= cars;
    }
}
