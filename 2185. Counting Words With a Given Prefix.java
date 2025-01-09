class Solution {
    public int prefixCount(String[] words, String pref) {
        int n = words.length;
        int target = pref.length();
        int count = 0;
        for(int i = 0; i < n; i++){
            String rem = words[i];
            if(rem.length() < pref.length()){
                continue;
            }
            boolean flag = false;
            for(int j = 0; j < target; j++){
                if(rem.charAt(j) != pref.charAt(j)){
                    flag = true;
                    break;
                }
            }
            if(!flag){
            count++;
            }
        }
        return count;
    }
}
