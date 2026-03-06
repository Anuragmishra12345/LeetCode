class Solution {
    int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
    int m,n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m=image.length;
        n=image[0].length;
        boolean[][] visited=new boolean[m][n];
        int changeColor=image[sr][sc];
        dfs(image,sr,sc,changeColor,color,visited);
        return image;
    }
    void dfs(int[][] image, int sr, int sc,int cc, int color, boolean[][] visited){
        image[sr][sc]=color;
        visited[sr][sc]=true;
        
        for(int[] d:dirs){
            int nr=sr+d[0];
            int nc=sc+d[1];
            if(nr>=0 && nc>=0 && nr<m && nc<n && !visited[nr][nc] && image[nr][nc]==cc)
            dfs(image,nr,nc,cc,color,visited);
        }
    }
}