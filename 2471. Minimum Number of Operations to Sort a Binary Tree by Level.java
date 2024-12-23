/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minimumOperations(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int javab = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!(q.isEmpty())){
            int n = q.size();
            int[] ans = new int[n];
            
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                ans[i] = node.val;
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            int rem = count(ans);
            javab += rem;
        }
        return javab;

    }
    int count(int[] arr) {
    int[] sorted = Arrays.copyOf(arr, arr.length);
    Arrays.sort(sorted);

    Map<Integer, Integer> valueToIndex = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
        valueToIndex.put(arr[i], i);
    }

    boolean[] visited = new boolean[arr.length];
    int count = 0;

    for (int i = 0; i < arr.length; i++) {
        if (visited[i] || arr[i] == sorted[i]) continue;

        int cycleCount = 0;
        int current = i;

        while (!visited[current]) {
            visited[current] = true;
            cycleCount++;
            current = valueToIndex.get(sorted[current]);
        }

        if (cycleCount > 1) {
            count += (cycleCount - 1);
        }
    }

    return count;
}

}
