class Solution {
    int m;
    int n;
    int[][] dir={{0,-1},{0,1},{1,0},{-1,0}};


    public int maximumSafenessFactor(List<List<Integer>> grid) {
        m=grid.size();
        n=grid.get(0).size();
        if(grid.get(0).get(0)==1 || grid.get(m-1).get(n-1)==1) return 0;
        Queue<int[]> pq=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid.get(i).get(j)==1){
                    grid.get(i).set(j,0);
                    pq.offer(new int[]{i,j});
                }
                else {
                    grid.get(i).set(j,Integer.MAX_VALUE);
                }
            }
        }
        while(!pq.isEmpty()){
            int[] cell=pq.poll();
            int r=cell[0];
            int c=cell[1];
            int factor=grid.get(r).get(c);

            for(int[] d:dir){
                int nr=r+d[0];
                int nc=c+d[1];

                if(nr<m && nr>=0 && nc<n && nc>=0 && grid.get(nr).get(nc)>factor+1){
                    grid.get(nr).set(nc,factor+1);
                    pq.offer(new int[]{nr,nc});
                }
            }
        }

        return dijkstra(grid);
    }
    int dijkstra(List<List<Integer>> grid){
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(Integer.compare(b[0],a[0])));
        pq.add(new int[]{grid.get(0).get(0),0,0});

        int[][] best=new int[m][n];

        for(int[] row:best) Arrays.fill(row,-1);

        best[0][0]=grid.get(0).get(0);

        while(!pq.isEmpty()){
            int[] cell=pq.poll();

            int factor=cell[0];
            int r=cell[1];
            int c=cell[2];

            if(factor<best[r][c]) continue;

            if(r==m-1 && c==n-1) return factor;

            for(int[] d:dir){
                int nr=r+d[0];
                int nc=c+d[1];

                if(nr>=m || nr<0 || nc>=n || nc<0) continue;

                int newFactor=Math.min(factor,grid.get(nr).get(nc));

                if(newFactor>best[nr][nc]){
                    best[nr][nc]=newFactor;
                    pq.offer(new int[]{newFactor,nr,nc});
                }
            }
        }
        return 0;
    }
}