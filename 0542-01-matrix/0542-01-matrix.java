class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> q=new LinkedList<>();
        int m=mat.length;
        int n=mat[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                }
                else mat[i][j]=Integer.MAX_VALUE;
            }
        }
        while(!q.isEmpty()){
            int[] cell=q.poll();
            int r=cell[0];
            int c=cell[1];

            for(int[] d:dir){
                int nr=r+d[0];
                int nc=c+d[1];

                if(nr>=0 && nr<m && nc>=0 && nc<n && mat[nr][nc]>mat[r][c]+1){
                    mat[nr][nc]=mat[r][c]+1;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        return mat;

    }
}