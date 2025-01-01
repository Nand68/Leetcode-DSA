class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int counone = 0;
        for( char c : s.toCharArray()){
            if ( c == '1'){
                counone++;
            }
        }
        if ( counone == 0){
            return 1;
        }
        int max = 0;
        int countzero = 0;
        char[] c = s.toCharArray();
        for (  int i = 0; i < c.length-1; i++){
            if ( c[i] == '0'){
                countzero++;
            }
            else{
                counone--;
            }
            max = Math.max(max,counone+countzero);
        }
        return max;
    }
}
