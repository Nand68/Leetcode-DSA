class Solution {
    public int[] finalPrices(int[] prices) {
        int[] ans=new int[prices.length];
        int i = 0;
        while ( i < prices.length){
            int j = i+1;
            int javab = -1;
            while ( j < prices.length){
                if ( j > i &&  prices[j] <= prices[i]){
                    javab = prices[i] - prices[j];
                    break;
                }
                j++;
            }
            if ( javab == -1){
                ans[i] = prices[i];
            }
            else{
                ans[i] = javab;
            }
            i++;
        }
        return ans;
    }
}
