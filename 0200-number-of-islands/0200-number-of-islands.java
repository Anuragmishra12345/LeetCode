class Solution {
    boolean[][] visited;
    int m;
    int n;
    public int numIslands(char[][] grid) {
        m=grid.length;
        n=grid[0].length;
        visited=new boolean[m][n];

        int ans=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'  &&  !visited[i][j]){
                    visited[i][j]=true;
                    ans++;
                    dfs(grid,i,j);
                }
            }
        }

        return ans;
    }
    int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
    void dfs(char[][] grid, int r, int c){

        for(int[] d:dir){
            int newRow=r+d[0];
            int newCol=c+d[1];

            if(newRow<0 || newRow>=m || newCol<0 || newCol>=n || grid[newRow][newCol]!='1' || visited[newRow][newCol]) continue;

            visited[newRow][newCol]=true;

            dfs(grid,newRow,newCol);
        }
    }
}