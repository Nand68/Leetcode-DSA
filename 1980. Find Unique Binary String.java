class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            char ch = nums[i].charAt(i);
            char rem = '0';
            if  ( ch == '0') {
                rem = '1';
            }
            sb.append(rem);
        }
        return sb.toString();
    }
}
// using backtracking
class Solution {
    String rem;
    int n = 0;

    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        n = nums[0].length();
        helper(new StringBuilder(""),set);
        return rem;
    }

    public boolean helper(StringBuilder sb, HashSet<String> set) {
        if(sb.length() == n){
            if(!set.contains(sb.toString())){
                rem = sb.toString();
                return true;
            }
            return false;
        }
        for(char ch = '0'; ch < '2';ch++){
            sb.append(ch);
            if(helper(sb,set)){
                return true;
            }
            sb.deleteCharAt(sb.length()-1);
        }
        return false;
    }
}
