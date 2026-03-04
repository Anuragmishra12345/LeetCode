class Solution {
    public int numIslands(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='1'){
                    ans++;
                    dfs(board,i,j);
                }
            }
        }
        return ans;
    }
    void dfs(char[][] board, int i, int j){
        int n=board[0].length;
        int m=board.length;
        if(i<0 || j<0 || i>=m || j>=n || board[i][j]!='1') return;

        board[i][j]='#';

        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);
    }
}