class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for ( int i = 0; i < n-1; i++){
            if ( nums[i] == nums[i+1]){
                nums[i] = nums[i] * 2;
                nums[i+1] = 0;
            }
        }
        int countZero = 0;
        List<Integer> list = new ArrayList<>();
        for ( int i = 0; i < n; i++){
            if ( nums[i] == 0){
                countZero++;
            }
            else{
                list.add(nums[i]);
            }
        }
        while ( countZero > 0){
            list.add(0);
            countZero--;
        }
        for( int i = 0; i < n; i++){
            nums[i] = list.get(i);
        }
        return nums;
    }
}
