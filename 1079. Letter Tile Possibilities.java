class Solution {
    int n;
    public int numTilePossibilities(String tiles) {
        n = tiles.length();
        boolean[] used = new boolean[n];
        HashSet<String> set = new HashSet<>();
        backtrack(tiles,set,used,"");
        return set.size() - 1;
    }
    public void backtrack(String tiles, HashSet<String> set, boolean[] used, String cur){
        if (set.contains(cur)) return;
        set.add(cur);
        for(int i = 0; i < n; i++){
            if(used[i] == true){
                continue;
            }
            used[i] = true;
            backtrack(tiles,set,used,cur+tiles.charAt(i));
            used[i] = false;
        }
    }
}
