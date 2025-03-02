class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int index = 0;
        int size = 0;
        int i = 0;
        int j = 0;
        int[][] ans = new int[n+m][2];
        while ( i < n && j < m){
            if ( nums1[i][0] == nums2[j][0] ){
                ans[index][0] = nums1[i][0];
                ans[index][1] = nums1[i][1] + nums2[j][1];
                i++;
                j++;
                index++;
                size++;
            }
            else if( nums1[i][0] < nums2[j][0] ){
                ans[index][0] = nums1[i][0];
                ans[index][1] = nums1[i][1];
                i++;
                index++;
                size++;
            }
            else{
                ans[index][0] = nums2[j][0];
                ans[index][1] = nums2[j][1];
                j++;
                index++;
                size++;
            }
        }
        while ( i < n){
            ans[index][0] = nums1[i][0];
            ans[index][1] = nums1[i][1];
            i++;
            index++;
            size++;
        }
        while ( j < m){
            ans[index][0] = nums2[j][0];
            ans[index][1] = nums2[j][1];
            j++;
            index++;
            size++;
        }
        ans = Arrays.copyOf(ans, size);
        return ans;
    }
}
