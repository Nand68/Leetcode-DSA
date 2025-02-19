class Solution {
    String rem;
    int count;
    public String getHappyString(int n, int k) {
        count=0;
        rem="";
        helper(n,k,new StringBuilder(""));
        return rem;
    }
    public boolean helper(int n, int k, StringBuilder sb){
        if ( sb.length() == n){
            count++;
            if ( count == k){
                rem = sb.toString();
                return true;
            }
            return false;
        }
        for (char ch='a'; ch < 'd'; ch++){
            int len = sb.length();
            if ( len > 0 && sb.charAt(len-1) == ch) continue;
            sb.append(ch);
            if(helper(n,k,sb)){
                return true;
            }
            sb.deleteCharAt(sb.length()-1);
        }
        return false;
    }
}
