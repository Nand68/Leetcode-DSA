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
    int index = 0;
    int n;
    public TreeNode recoverFromPreorder(String s) {
        n = s.length();
        return helper(s,0);
    }
    public TreeNode helper(String s, int depth){
        if ( index >= n) return null;

        int count = 0;
        int tempInd = index;
        while (tempInd < n && s.charAt(tempInd) == '-'){
            count++;
            tempInd++;
        }
        if ( count != depth) return null;
        index = tempInd;
        int val = 0;
        while ( index < n && s.charAt(index) != '-'){
            val = val * 10 + (s.charAt(index) - '0');
            index++;
        }
        TreeNode node = new TreeNode(val);
        node.left = helper(s,depth+1);
        node.right =  helper(s,depth+1);
        return node;
    }
}
