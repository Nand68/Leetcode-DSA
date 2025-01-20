class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        HashMap<Integer, Pair> map = new HashMap<>();
        int[] rowFreq = new int[n];
        int[] colFreq = new int[m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int val = mat[i][j];
                map.put(val,new Pair(i,j));
            }
        }
        for(int i = 0; i < arr.length; i++){
            int curValue = arr[i];
            Pair curr = map.get(curValue);
            rowFreq[curr.i]++;
            colFreq[curr.j]++;
            if ( rowFreq[curr.i] == m || colFreq[curr.j] == n){
                return i;
            }
        }
        return 0;
    }
}

class Pair{
    int i;
    int j;
    Pair(int i , int j){
        this.i = i;
        this.j = j;
    }
}
