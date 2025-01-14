class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer> map = new HashSet<>();
        int n = A.length;
        int[] ans = new int[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            if( A[i] == B[i]){
                count++;
                ans[i] = count;
            }
            else{
                if(map.contains(A[i]) && map.contains(B[i])){
                    count += 2;
                    ans[i] = count;
                }
                else if((map.contains(A[i]) || map.contains(B[i]))){
                    count++;
                    ans[i] = count;
                }
                else{
                    ans[i] = count;
                }
            }
            map.add(A[i]);
            map.add(B[i]);
        }

         return ans;
    
    }
        
}
