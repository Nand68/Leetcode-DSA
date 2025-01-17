class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int ans = 0;
        for(int i : derived){
            ans ^= i;
        }
        
        return (ans == 0);
    } 
}
