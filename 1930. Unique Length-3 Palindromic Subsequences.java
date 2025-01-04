class Pair{
    int firstOcc;
    int secondOcc;
    Pair(int firstOcc, int secondOcc ){
        this.firstOcc=firstOcc;
        this.secondOcc=secondOcc;
    }
}
class Solution {
    public int countPalindromicSubsequence(String s) {
        Pair arr[] = new Pair[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = new Pair(-1,-1);
        }
        for(int i=0;i<s.length();i++){
            if(arr[s.charAt(i)-'a'].firstOcc==-1){
                arr[s.charAt(i)-'a'].firstOcc = i;
            }
            else
                arr[s.charAt(i)-'a'].secondOcc=i;
        }
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].firstOcc !=-1 && arr[i].secondOcc !=-1){
                HashSet<Character> hs= new HashSet<>();
                for(int j=arr[i].firstOcc+1;j<arr[i].secondOcc;j++){
                    hs.add(s.charAt(j));
                }
                cnt+=hs.size();
            }
        }
        return cnt;
    }
}
