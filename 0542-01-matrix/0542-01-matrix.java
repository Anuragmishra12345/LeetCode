class Solution {
    int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
    int m,n;
    public int[][] updateMatrix(int[][] mat) {
        m=mat.length;
        n=mat[0].length;
        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                }
                else mat[i][j]=Integer.MAX_VALUE;
            }
        }

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];

            for(int[] d:dirs){
                int nr=r+d[0];
                int nc=c+d[1];

                if(nr>=0 && nc>=0 && nr<m && nc<n && mat[nr][nc]>mat[r][c]+1){
                    mat[nr][nc]=mat[r][c]+1;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        return mat;
    }
}