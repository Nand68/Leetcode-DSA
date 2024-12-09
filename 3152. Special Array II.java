class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] sum = new int[nums.length];
        boolean[] ans = new boolean[queries.length];
        sum[0] = 0;
        int count = 0;
        for ( int i = 1; i < nums.length; i++){
            if ( nums[i-1] % 2 == nums[i] % 2){
                count++;
            }
            sum[i] = count;
        }

        for ( int i = 0; i < queries.length; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            if( sum[end] - sum[start] == 0){
                ans[i] = true;
            }
            else{
                ans[i] = false;
            }
        }
        return ans;
    }
}
