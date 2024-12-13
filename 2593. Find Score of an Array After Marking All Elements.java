import java.util.*;

class Solution {
    public long findScore(int[] nums) {
        long score = 0;
        int n = nums.length;
        boolean[] marked = new boolean[n]; 
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.value == b.value ? Integer.compare(a.index, b.index) : Integer.compare(a.value, b.value));

        for (int i = 0; i < n; i++) {
            pq.add(new Pair(nums[i], i));
        }

        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            if (!marked[top.index]) {
                score += top.value;
                marked[top.index] = true; 

               
                if (top.index > 0) {
                    marked[top.index - 1] = true;
                }
                if (top.index < n - 1) {
                    marked[top.index + 1] = true;
                }
            }
        }
        return score;
    }

    class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
