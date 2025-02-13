class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long num : nums) {
            pq.add(num);
        }
        int ans = 0;
        while (!pq.isEmpty()) {
            long smallest1 = pq.poll();
            if (smallest1 >= k) {
                return ans;
            }
            long smallest2 = pq.poll();
            pq.add(smallest1 * 2 + smallest2);
            ans++;
        }
        return -1;
    }
}
