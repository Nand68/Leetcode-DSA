class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        int count = 0;
        if( k == n ){
            return true;
        }
        if( k > n){
            return false;
        }
        int[] ans = new int[26];
        for(int i = 0; i < n; i++){
            ans[s.charAt(i)-'a']++;
        }
        for(int i = 0; i < 26; i++){
            if( ans[i] % 2 != 0){
                count++;
            }
        }
        if( count <= k){
            return  true;
        }
        return false;
    }
}
