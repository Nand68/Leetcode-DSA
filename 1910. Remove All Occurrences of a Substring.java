class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        while(true){
            int i = KMP(sb.toString(),part);
            if(i==-1){
                break;
            }else{
                sb.delete(i,i+part.length());
            }
        }
        return sb.toString();
    }

    public static int KMP(String s, String pat) {
        int n = s.length();
        int m = pat.length();
        int[] lps = lps(pat);
        int i = 0;
        int j = 0;
        int ans = -1;
        while (i < n) {
            if (pat.charAt(j) == s.charAt(i)) {
                i++;
                j++;
            }
            if (j == m) {
                ans = i-j;
                j = lps[j - 1];
                break;
            } else if (i < n && pat.charAt(j) != s.charAt(i)) {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
        }
        return ans;
    }

    public static int[] lps(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int len = 0;
        int i = 1;
        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    len = lps[len - 1];
                }
            }
        }
        return lps;
    }
}
