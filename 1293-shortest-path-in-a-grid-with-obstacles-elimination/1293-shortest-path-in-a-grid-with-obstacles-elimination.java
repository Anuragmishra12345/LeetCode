class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;

        if(m==1 && n==1) return 0;

        int[][] dir={{-1,0},{0,-1},{1,0},{0,1}};

        Queue<int[]> q=new LinkedList<>();
        int[][] visited=new int[m][n];
        for(int[] v:visited) Arrays.fill(v,-1);

        visited[0][0]=k;

        q.offer(new int[]{0,0,k});

        int steps=0;
        while(!q.isEmpty()){
            int size=q.size();

            steps++;

            for(int i=0;i<size;i++){
                int[] cell=q.poll();

                int r=cell[0];
                int c=cell[1];
                int remain=cell[2];

                for(int[] d:dir){
                    int nr=r+d[0];
                    int nc=c+d[1];

                    if(nr<0 || nr>=m || nc<0 || nc>=n) continue;

                    if(nr==m-1 && nc==n-1) return steps;
                    int newK=remain;
                    if(grid[nr][nc]==1) newK--;

                    if(newK<0) continue;

                    if(visited[nr][nc]>=newK) continue;

                    visited[nr][nc]=newK;
                    q.offer(new int[]{nr,nc,newK});
                }
            }
        }
        return -1;
    }
}