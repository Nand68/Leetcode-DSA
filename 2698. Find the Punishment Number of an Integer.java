class Solution {
    public int punishmentNumber(int n) {
        int ans = 0;
        for ( int i = 1 ; i <= n; i++){
            String s = Integer.toString(i*i);
            if(isPartition(0,s,i,0)){
                ans += (i*i);
            }
        }
        return ans;
    }
    public boolean isPartition(int j, String s, int target, int CurrentSum){
        if ( j == s.length()){
            return (CurrentSum == target);
        } 
        if ( CurrentSum > target){
            return false;
        }
        for ( int index = j; index < s.length(); index++){
            int val = Integer.parseInt(s.substring(j,index+1));
            if (isPartition(index+1,s,target,CurrentSum+val)){
                return true;
            }
        }
        return false;
    }
}
