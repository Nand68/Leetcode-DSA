class Solution {
    public long countBadPairs(int[] nums) {
        long n = nums.length;
        long count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for ( int i = 0; i < n; i++){
            int ans = i - nums[i];
            if ( map.containsKey(ans)){
                count += map.get(ans);
            }
            map.put(ans,map.getOrDefault(ans,0)+1);
        }
        
        long rem = ( long) ( n * ( n - 1))/2;
        return rem - count;
    }
}
