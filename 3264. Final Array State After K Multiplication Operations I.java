class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for ( int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
        }
        while ( k > 0){
            int temp = pq.poll();
            int newVal = temp * multiplier;
            pq.add(newVal);
            for ( int i = 0; i < nums.length; i++){
                if ( nums[i] == temp){
                    nums[i] = newVal;
                    break;
                }
            }
            k--;
        }
        return nums;
    }
}
