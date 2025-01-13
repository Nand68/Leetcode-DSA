class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int count = 0;
        int[] ans = new int[26];
        for(int i = 0; i < n; i++){
            ans[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(ans[i] == 0){
                continue;
            }
            else if(ans[i] == 1){
                count += 1;
            }
            else if(ans[i] == 2){
                count += 2;
            }
            else{
                if((ans[i] & 1) == 0){
                    count += 2;
                }
                else{
                    count += 1;
                }
            }
        }
        return count;
    }
}
