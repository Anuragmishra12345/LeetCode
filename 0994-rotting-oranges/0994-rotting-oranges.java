class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int minute=0;
        int fresh=0;
        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j]==1) fresh++;
            }
        }
        int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty() && fresh>0){
            minute++;
            int size=q.size();
            for(int i=0;i<size;i++){
                int r=q.peek()[0];
                int c=q.poll()[1];

                for(int[] d:dir){
                    int nr=r+d[0];
                    int nc=c+d[1];

                    if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1){
                        q.offer(new int[]{nr,nc});
                        fresh--;
                        grid[nr][nc]=2;
                    }
                }
            }
        }

        return fresh>0?-1:minute;
    }
}