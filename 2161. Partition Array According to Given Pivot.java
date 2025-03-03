class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans = new int[n];
        List<Integer> greaterThanPivot = new ArrayList<>();
        int equal = 0;
        int index = 0;
        for ( int i = 0; i < n; i++){
            if( nums[i] > pivot){
                greaterThanPivot.add(nums[i]);
            }
            else if ( nums[i] == pivot){
                equal++;
            }
            else{
                nums[index++] = nums[i];
            }
        }
        while (equal > 0){
            nums[index++] = pivot;
            equal--;
        }
        for ( int i = 0; i < greaterThanPivot.size(); i++){
            nums[index++] = greaterThanPivot.get(i);
        }
        return nums;
    }
}
