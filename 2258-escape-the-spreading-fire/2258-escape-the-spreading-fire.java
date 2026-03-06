class Solution {
    int m,n;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int maximumMinutes(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int[][] fireTime=computeFireTime(grid);

        int left=0; int right=m*n;
        int ans=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(canReach(grid, mid, fireTime)){
                ans=mid;
                left=mid+1;
            }
            else right=mid-1;
        }
        return (ans>=m*n)? (int)1e9:ans;
    }
    private int[][] computeFireTime(int[][] grid){
        int[][] fireTime=new int[m][n];
        for(int[] row:fireTime) Arrays.fill(row,Integer.MAX_VALUE);
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    queue.add(new int[]{i,j});
                    fireTime[i][j]=0;
                }
            }
        }
        while(!queue.isEmpty()){
            int[] cell=queue.poll();
            int r=cell[0];
            int c=cell[1];
            for(int[] d:dirs ){
                int nr=r+d[0];
                int nc=c+d[1];

                if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]!=2 && fireTime[nr][nc] == Integer.MAX_VALUE){
                    fireTime[nr][nc]=fireTime[r][c]+1;
                    queue.add(new int[]{nr,nc});
                }

            }
        }
        return fireTime;
    }
    private boolean canReach(int[][] grid, int wait, int [][] fireTime){
        if (wait >= fireTime[0][0]) return false;

        Queue<int[]> q=new LinkedList<>();
        boolean[][] visited=new boolean[m][n];
        q.add(new int[]{0,0,wait});
        visited[0][0]=true;

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            int time=curr[2];

            if(r==m-1 && c==n-1) return time<=fireTime[r][c];

            for(int[] d:dirs){
                int nr=r+d[0];
                int nc=c+d[1];
                int nt=time+1;

                if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]!=2 && !visited[nr][nc]){
                    
                    if(nr==m-1 && nc==n-1){
                        if(nt<=fireTime[nr][nc]){
                            visited[nr][nc]=true;
                            q.add(new int[]{nr,nc,nt});
                        }
                    }
                    else if( nt<fireTime[nr][nc]){
                        visited[nr][nc]=true;
                        q.add(new int[]{nr,nc,nt});
                    }
                }
            }
        }
        return false;
    }
}