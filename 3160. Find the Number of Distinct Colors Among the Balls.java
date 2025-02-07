class Solution {
    public int[] queryResults(int limit, int[][] queries) {

        HashMap<Integer, Integer> store = new HashMap<>();
        int[] ans = new int[queries.length];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < queries.length; i++) {

            int[] q = queries[i];
            int color = q[1];
            int ball = q[0];

            if (!store.containsKey(ball)) {
                store.put(ball, color);
                map.put(color, map.getOrDefault(color, 0) + 1);
            } else {
                int temp = store.get(ball);
                int get = map.get(temp);
                if (get == 1)
                    map.remove(temp);
                else 
                    map.put(temp, map.getOrDefault(temp, 0) - 1);
                
                map.put(color, map.getOrDefault(color, 0) + 1);
                store.put(ball, color);

            }
            ans[i] = map.size();
        }

        return ans;
    }
}
