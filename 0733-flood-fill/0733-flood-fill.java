class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor=image[sr][sc];
        if(oldColor==color) return image;

        Queue<int[]> q=new LinkedList<>();

        q.add(new int[]{sr,sc});
        image[sr][sc]=color;

        int[][] dir={{1,0},{0,1},{0,-1},{-1,0}};

        while(!q.isEmpty()){
            int[] cell=q.poll();
            int r=cell[0];
            int c=cell[1];

            for(int[] d:dir){
                int nr=r+d[0];
                int nc=c+d[1];

                if(nr>=0 && nr<image.length && nc>=0 && nc<image[0].length && image[nr][nc]==oldColor){
                    image[nr][nc]=color;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        return image;
    }
}