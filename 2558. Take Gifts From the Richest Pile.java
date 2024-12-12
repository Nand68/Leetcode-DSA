import java.util.*;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> ans = new PriorityQueue<>(Collections.reverseOrder());
        long total = 0;

        for (int gift : gifts) {
            ans.add(gift);
            total += gift;
        }

        while (k > 0) {
            int value = ans.poll();
            total -= value;
            int sqrtValue = (int) Math.sqrt(value);
            ans.add(sqrtValue);
            total += sqrtValue;
            k--;
        }

        return total;
    }
}
