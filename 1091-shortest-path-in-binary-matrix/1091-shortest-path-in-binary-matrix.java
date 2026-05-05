class Solution {
    class Tuple{
        int first;
        int second;
        int third;

        Tuple(int first, int second, int third){
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }
    int[][] dir={{0,1},{1,0},{0,-1},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        int[][] path=new int[n][n];
        for(int[] row:path) Arrays.fill(row,Integer.MAX_VALUE);
        path[0][0]=1;
        Queue<Tuple> q=new LinkedList<>();
        q.add(new Tuple(1,0,0));

        while(!q.isEmpty()){
            Tuple it=q.poll();
            int dist=it.first;
            int r=it.second;
            int c=it.third;
            
            if(dist>path[r][c]) continue;

            for(int i=0;i<8;i++){
                int nr=r+dir[i][0];
                int nc=c+dir[i][1];
            
                if(nr>=0 && nr<n && nc<n && nc>=0 && grid[nr][nc]==0 && dist+1<path[nr][nc]){
                    path[nr][nc]=dist+1;
                    q.add(new Tuple(dist+1,nr,nc));
                }
            }
        }
        return (path[n-1][n-1]!=Integer.MAX_VALUE)? path[n-1][n-1]:-1;
    }
}