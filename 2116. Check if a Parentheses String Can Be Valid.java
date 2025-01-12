class Solution {
    public boolean canBeValid(String s, String locked) {
        int wildcard = 0;
        int open = 0;
        int close = 0;
        int n = s.length();
         if (n % 2 != 0) {
            return false;
        }

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(locked.charAt(i) == '0'){
                wildcard++;
            }
            else{
                if(ch == '('){
                    open++;
                }
                else{
                    close++;
                }
            }
            if(wildcard < (close - open))
                return false;
        }

        wildcard = 0;
        open = 0;
        close = 0;
        for(int i = n - 1; i >= 0; i--){
            char ch = s.charAt(i);
            if(locked.charAt(i) == '0'){
                wildcard++;
            }
            else{
                if(ch == '('){
                    open++;
                }
                else{
                    close++;
                }
            }
            if(wildcard < (open - close))
                return false;
        }
        return true;
    }
}
