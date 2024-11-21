class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {

        int[][] ans = new int[m][n];

        for ( int i = 0; i < guards.length; i++){
            
            ans[guards[i][0]][guards[i][1]] = 5;
        }
        for ( int i = 0; i < walls.length; i++){
            
            ans[walls[i][0]][walls[i][1]] = 7;
        }

        for ( int i = 0; i < m; i++){
            for ( int j = 0; j < n; j++){
                if ( ans[i][j] == 5){
                    left = (m,n,i,j,ans);
                    right = (m,n,i,j,ans);
                    up = (m,n,i,j,ans);
                    down = (m,n,i,j,ans);
                }
            }
        }
        int count = 0;
        for ( int i = 0; i < m; i++){
            for ( int i = 0; i < n; i++){
                if ( ans[i][j] != 5 && ans[i][j] != 7 && ans[i][j] != 3){
                    count++;
                }
            }
        }
        return count;
    }
    public voud left(int m,int n,int i,int j,int[][] ans){
        while ( j >= 0){
            if (ans[i][j] == 7 ){
                break;
            }
            if (ans[i][j] == 5 ){
                break;
            }
            ans[i][j] == 3;
            j--;
        }
    }
    public voud right(int m,int n,int i,int j,int[][] ans){
        while ( j < n){
            if (ans[i][j] == 7 ){
                break;
            }
            if (ans[i][j] == 5 ){
                break;
            }
            ans[i][j] == 3;
            j++;
        }
    }
    public voud up(int m,int n,int i,int j,int[][] ans){
        while ( i >= 0){
            if (ans[i][j] == 7 ){
                break;
            }
            if (ans[i][j] == 5 ){
                break;
            }
            ans[i][j] == 3;
            i--;
        }
    }
    public voud down(int m,int n,int i,int j,int[][] ans){
        while ( i < m 0){
            if (ans[i][j] == 7 ){
                break;
            }
            if (ans[i][j] == 5 ){
                break;
            }
            ans[i][j] == 3;
            i++;
        }
    }
}
