import java.util.*;

class Solution {
    private int findDiameter(List<List<Integer>> edges) {
        if (edges.isEmpty()) return 0;

        Map<Integer, List<Integer>> adj = new HashMap<>();
        Set<Integer> nodes = new HashSet<>();

        // Build adjacency list
        for (List<Integer> edge : edges) {
            adj.computeIfAbsent(edge.get(0), k -> new ArrayList<>()).add(edge.get(1));
            adj.computeIfAbsent(edge.get(1), k -> new ArrayList<>()).add(edge.get(0));
            nodes.add(edge.get(0));
            nodes.add(edge.get(1));
        }
        return diameter(adj, nodes.size());
    }

    private int diameter(Map<Integer, List<Integer>> adj, int n) {
        // First BFS to find the farthest node
        int farthestNode = bfs(0, adj, n);

        // Second BFS from the farthest node to calculate the diameter
        return bfs(farthestNode, adj, n) - 1;
    }

    private int bfs(int start, Map<Integer, List<Integer>> adj, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(start);
        visited[start] = true;
        int level = 0, lastNode = start;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                lastNode = curr;
                for (int neighbor : adj.getOrDefault(curr, new ArrayList<>())) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
            }
            level++;
        }
        return lastNode == start ? 1 : level;
    }

    public int minimumDiameterAfterMerge(List<List<Integer>> edges1, List<List<Integer>> edges2) {
        int dia1 = findDiameter(edges1);
        int dia2 = findDiameter(edges2);

        int radius1 = (dia1 + 1) / 2;
        int radius2 = (dia2 + 1) / 2;

        int sum = 1 + radius1 + radius2;
        return Math.max(sum, Math.max(dia1, dia2));
    }
}
