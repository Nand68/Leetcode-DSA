
class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int[] arr = new int[n+1];
        for(int i = 0; i < shifts.length;i++){
            int start = shifts[i][0];
            int end = shifts[i][1];
            int dir = shifts[i][2];
            if ( dir == 1){
            arr[start]++;
            arr[end+1]--;
            }
            else{
            arr[start]--;
            arr[end+1]++;
            }
        }
        for ( int i = 1; i < n; i++){
            arr[i] = arr[i] + arr[i-1];
        }
        for ( int i = 0; i < n; i++){
            int rem = arr[i];
            boolean flag = false;
            if ( rem > 0){
                flag = true;
            }
            if (flag){
                int u = s.charAt(i);
                while(rem != 0){
                    if ( u == 122){
                        u = 97;
                    }
                    else{
                    u++;
                    }
                    rem--;
                }
                char ch = (char)u;
                sb.append(ch);
            }else{
                int u = s.charAt(i);
                while(rem != 0){
                    if ( u == 97){
                        u = 122;
                    }
                    else{
                    u--;
                    }
                    rem++;
                }
                char ch = (char)u;
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}




// brute force :
// class Solution {
//     public String shiftingLetters(String s, int[][] shifts) {
//         HashMap<Integer,Character> map = new HashMap<>();
//         StringBuilder sb = new StringBuilder();
//         for(int i = 0; i < s.length(); i++){
//             map.add(i,s.charAt(i));
//         }
//         for(int i = 0; i < shifts.length; i++){
//             int start = shifts[i][0];
//             int end = shifts[i][1];
//             int dir = shifts[i][2];
//             for(int j = start; j <= end; j++){
//                 int u = map.get(j);
//                 if( dir == 0){
//                     if (u == 97){
//                         u = 122;
//                     }
//                     else{
//                         u--;
//                     }
//                 }
//                 else{
//                     if(u == 122){
//                         u = 97;
//                     }
//                     else{
//                         u++;
//                     }
//                 }
//                 char ch = (char)u;
//                 map.put(j,ch);
//             }
//         }
//         for( int i = 0; i < s.length(); i++){
//             sb.append(map.get(i));
//         }
//         return sb.toString();
//     }
// }

// 97 , 98 , 99 .... 122 
