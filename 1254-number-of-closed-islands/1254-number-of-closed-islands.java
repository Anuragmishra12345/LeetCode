class Solution {
    int m;
    int n;
    public int closedIsland(int[][] grid) {
        m=grid.length;
        n=grid[0].length;

        int count=0;

        for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){

                if(grid[i][j]==0){
                    if(dfs(grid,i,j)) count++;
                } 
            }
        }
        return count;
    }

    int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};

    boolean dfs(int[][] grid, int i, int j){
        if(i==0 || j==0 || i==m-1 || j==n-1){
            return false;
        }

        boolean result=true;

        for(int[] d:dir){
            int r=i+d[0];
            int c=j+d[1];

            if(grid[r][c]==1) continue;

            grid[r][c]=1;

            boolean current =dfs(grid,r,c);

            result = result && current;
        }

        return result;
    }
}