class Solution {
    boolean[][] visited;
    int m;
    int n;
    public int countBattleships(char[][] board) {
        m=board.length;
        n=board[0].length;

        visited=new boolean[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='X' && !visited[i][j]) {
                    count++;
                    dfs(board,i,j);
                }
            }
        }
        return count;
    }
    void dfs(char[][] board, int i , int j){
        if(i>=m || i<0 || j<0 || j>=n || visited[i][j] || board[i][j]=='.') return;

        visited[i][j]=true;

        dfs(board,i+1,j);
        dfs(board,i,j+1);
        dfs(board,i-1,j);
        dfs(board,i,j-1);
    }
}