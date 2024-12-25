class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        TreeMap<Integer,TreeMap<Integer,List<Integer>>> res = new TreeMap<>();
        dfs(res,root,0,0);

        for ( var go : res.entrySet()){
            List<Integer> list = new ArrayList<>();
            for ( var subgo : go.getValue().values()){
                Collections.sort(subgo);
                list.addAll(subgo);
            }
            ans.add(list);
        }
        return ans;
    }
    void dfs(TreeMap<Integer,TreeMap<Integer,List<Integer>>> res , TreeNode root, int col , int level){
        if ( root == null){
            return;
        }
        if ( !res.containsKey(col) ){
            res.put(col, new TreeMap<>());
        }
        if ( !res.get(col).containsKey(level)){
            res.get(col).put(level, new ArrayList<>());
        }
        res.get(col).get(level).add(root.val);

        dfs(res,root.right,col+1,level+1);
        dfs(res,root.left,col-1,level+1);
    }
}
