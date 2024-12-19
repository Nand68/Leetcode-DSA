class Solution {
    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        int i = 0;
        int n = arr.length;
        int max = arr[0];
        while ( i < arr.length){
            max=Math.max(max,arr[i]);
            if ( max < i+1){
                count++;
            }
            i++;
        }
        return count;
    }
}
