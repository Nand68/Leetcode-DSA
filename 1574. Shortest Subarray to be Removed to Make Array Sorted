class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
    
        int n = arr.length;
        int j = n - 1;
        int ans = arr.length;

         while (j > 0 && arr[j] >= arr[j-1]){
            j--;
         }
        ans = Math.min(ans,j);

        int i = 0;


         while (i < j && ( i == 0  || arr[i] >= arr[i-1])){

           

            while (j < n && arr[i] > arr[j] ){
                  j++;
            }
            ans = Math.min(ans,j-i-1);
            i++;
         }
         return ans;
    }
}
