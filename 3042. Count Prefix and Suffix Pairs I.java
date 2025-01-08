class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int count = 0;
        for(int i = 0; i < n-1; i++){
            for(int j = i + 1; j < n; j++){
                String one = words[i];
                String two = words[j];
                if(one.length() <= two.length()){
                    if(isPrefixAndSuffix(two,one)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public boolean isPrefixAndSuffix(String s1, String s2){
        int p = s1.length();
        int q = s2.length();
        for(int i = 0; i < q; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                return false;
            }
        }
        p = p - 1;
        q = q - 1;
        while ( q != -1){
            if(s1.charAt(p) != s2.charAt(q)){
                return false;
            }
            p--;
            q--;
        }
        return true;
    }
}
