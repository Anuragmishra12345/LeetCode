class Solution {
    class Triple{
        int dist;
        int i;
        int j;

        Triple(int dist,int i, int j){
            this.dist=dist;
            this.i=i;
            this.j=j;
        }
    }
    int[][] dir={{0,1},{1,0},{1,1},{-1,-1},{-1,0},{0,-1},{1,-1},{-1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;

        Queue<Triple> q=new LinkedList<>();

        int[][] path=new int[n][n];
        for(int[] p:path) Arrays.fill(p,Integer.MAX_VALUE);

        path[0][0]=1;

        q.add(new Triple(1,0,0));

        while(!q.isEmpty()){
            Triple t=q.poll();
            
            int dist=t.dist;
            int r=t.i;
            int c=t.j;

            for(int[] d:dir){
                int nr=r+d[0];
                int nc=c+d[1];

                if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==0 && dist+1<path[nr][nc]){
                    path[nr][nc]=dist+1;
                    q.offer(new Triple(dist+1,nr,nc));
                }
            }
        }
        return path[n-1][n-1]==Integer.MAX_VALUE?-1:path[n-1][n-1];
    }
}