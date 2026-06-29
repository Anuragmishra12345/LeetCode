class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m=isWater.length;
        int n=isWater[0].length;
        Queue<int[]> q=new LinkedList<>();
        int[][] dir={{-1,0},{1,0},{0,-1},{0,1}}; 

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isWater[i][j]==1){
                    isWater[i][j]=0;
                    q.add(new int[]{i,j});
                }
                else isWater[i][j]=Integer.MAX_VALUE;
            }
        }

        while(!q.isEmpty()){
            int[] land=q.poll();
            int r=land[0];
            int c=land[1];

            for(int[] d:dir){
                int nr=d[0]+r;
                int nc=d[1]+c;

                if(nr>=0 && nr<m && nc>=0 && nc<n && isWater[nr][nc]>isWater[r][c]+1){
                    isWater[nr][nc]=isWater[r][c]+1;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        return isWater;
    }
}