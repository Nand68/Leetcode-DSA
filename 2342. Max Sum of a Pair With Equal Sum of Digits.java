class Solution {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        int max = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int total = 0;
            int number = nums[i];
            while ( number > 0){
                total = total + (number % 10);
                number = number / 10;
            }
            if ( map.containsKey(total)){
                int maxForthisNumber = map.get(total);
                int rem = maxForthisNumber + nums[i];
                max = Math.max(max,rem);
                int maxNowafter = Math.max(maxForthisNumber,nums[i]);
                map.put(total,maxNowafter);
            }
            else{
                map.put(total,nums[i]);
            }
        }
        return (max == 0)?-1:max;
    }
}

// better 
class Solution {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        int max = 0;
        int[] map = new int[82];
        for(int i = 0; i < n; i++){
            int total = 0;
            int number = nums[i];
            while ( number > 0){
                total = total + (number % 10);
                number = number / 10;
            }
            if ( map[total] != 0){
                int maxForthisNumber = map[total];
                int rem = maxForthisNumber + nums[i];
                max = Math.max(max,rem);
                int maxNowafter = Math.max(maxForthisNumber,nums[i]);
                map[total] = maxNowafter;
            }
            else{
                map[total] = nums[i];
            }
        }
        return (max == 0)?-1:max;
    }
}
