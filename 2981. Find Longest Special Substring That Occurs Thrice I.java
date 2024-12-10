class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        int[][] freq = new int[26][n + 1];
        int maxLength = -1;

        for (int i = 0, len = 1; i < n; i++) {
            char c = s.charAt(i);
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                len++;
            } else {
                len = 1;
            }
            freq[c - 'a'][len]++;
        }

        for (int ch = 0; ch < 26; ch++) {
            for (int len = n; len > 0; len--) {
                if (len < n) {
                    freq[ch][len] += freq[ch][len + 1];
                }
                if (freq[ch][len] >= 3) {
                    maxLength = Math.max(maxLength, len);
                    break;
                }
            }
        }

        return maxLength; 
    }
}
