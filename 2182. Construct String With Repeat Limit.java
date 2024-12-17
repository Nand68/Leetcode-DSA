import java.util.PriorityQueue;

class Solution {
    public String repeatLimitedString(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) pq.offer(new int[] {i + 'a', freq[i]});
        }
        
        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int ch = current[0], count = current[1];
            int used = Math.min(k, count);
            
            for (int i = 0; i < used; i++) {
                result.append((char) ch);
            }
            count -= used;
            
            if (count > 0) {
                if (pq.isEmpty()) break;
                int[] next = pq.poll();
                result.append((char) next[0]);
                next[1]--;
                
                if (next[1] > 0) pq.offer(next);
                pq.offer(new int[] {ch, count});
            }
        }
        
        return result.toString();
    }
}
