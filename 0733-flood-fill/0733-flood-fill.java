class Solution {
    int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
    int m,n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;
        m=image.length;
        n=image[0].length;

        int changeColor=image[sr][sc];
        dfs(image,sr,sc,changeColor,color);
        return image;
    }
    void dfs(int[][] image, int sr, int sc,int cc, int color){
        image[sr][sc]=color;
        
        for(int[] d:dirs){
            int nr=sr+d[0];
            int nc=sc+d[1];
            if(nr>=0 && nc>=0 && nr<m && nc<n && image[nr][nc]==cc)
            dfs(image,nr,nc,cc,color);
        }
    }
}