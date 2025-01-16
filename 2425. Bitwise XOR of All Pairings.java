class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int javab = 0;
        int n = nums1.length;
        int m = nums2.length;
        int isNum1even = n & 1;
        int isNum2even = m & 1;
        if(isNum1even != 0){
            for(int i = 0; i < m; i++){
                javab ^= nums2[i];
            }
        }
        if(isNum2even != 0){
            for(int i = 0; i < n; i++){
                javab ^= nums1[i];
            }
        }
        return javab;
    }
}
