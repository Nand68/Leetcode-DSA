class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        int n = nums.length;
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                int product = nums[i] * nums[j];
                map.put(product,map.getOrDefault(product,0)+1);
            }
        }
        for( Map.Entry<Integer,Integer> entry : map.entrySet()){
            if( entry.getValue() > 1){
                int rem = entry.getValue();
                int p = ( rem * ( rem - 1)) / 2;
                int total = p * 8;
                ans += total;
            }
        }
        return ans;
    }
}
