class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int INF=Integer.MAX_VALUE;
        int[][] matrix=new int[n][n];
        for(int[] m:matrix) Arrays.fill(m,INF);
        for(int i=0;i<n;i++) matrix[i][i]=0;
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            int w=e[2];

            matrix[u][v]=w;
            matrix[v][u]=w;
        }

        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(matrix[i][via]!=INF && matrix[via][j]!=INF){
                        matrix[i][j]=Math.min(matrix[i][j],matrix[i][via]+matrix[via][j]);
                    }
                }
            }
        }
        int ans=0;
        int min=INF;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(i!=j && matrix[i][j]<=distanceThreshold) count++;
            }
            if(count<=min){
                min=count;
                ans=i;
            }
        }
        return ans;
    }
}