import java.util.*;

public class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        int[] maxRequiredFreq = new int[26];

        for (String word : words2) {
            int[] wordFreq = new int[26];
            for (char c : word.toCharArray()) {
                wordFreq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                maxRequiredFreq[i] = Math.max(maxRequiredFreq[i], wordFreq[i]);
            }
        }

        for (String word : words1) {
            int[] wordFreq = new int[26];
            for (char c : word.toCharArray()) {
                wordFreq[c - 'a']++;
            }

            boolean isValid = true;
            for (int i = 0; i < 26; i++) {
                if (wordFreq[i] < maxRequiredFreq[i]) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                ans.add(word);
            }
        }

        return ans;
    }
}
