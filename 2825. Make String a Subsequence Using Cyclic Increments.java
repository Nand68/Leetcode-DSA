class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int i = 0;
        int j = 0;
        while ( i < n && j < m){
            int count = str1.charAt(i)+1;
            if ( count == 123) count = 97;
            if (str1.charAt(i) == str2.charAt(j)){
                i++;
                j++;
            }
            else if (count == str2.charAt(j)){
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        if ( j+1 > m ){
            return true;
        }
        return false;
    }
}
