class Solution {
    class DisjointSet{
        List<Integer> parent=new ArrayList<>();
        List<Integer> size=new ArrayList<>();

        DisjointSet(int n){
            for(int i=0;i<n;i++){
                parent.add(i);
                size.add(1);
            }
        }

        int findUPar(int node){
            if(parent.get(node)==node) return node;

            int par=findUPar(parent.get(node));

            parent.set(node,par);

            return par;
        }

        void unionBySize(int u , int v){
            int up=findUPar(u);
            int vp=findUPar(v);

            if(up==vp) return;

            if(size.get(up)<size.get(vp)){
                parent.set(up,vp);
                size.set(vp,size.get(up)+size.get(vp));
            }
            else{
                parent.set(vp,up);
                size.set(up,size.get(up)+size.get(vp));
            }
        }
    }
    int n;
    boolean[][] visited;
    public int largestIsland(int[][] grid) {
        n=grid.length;
        // using this to avoid cyclic loops
        visited=new boolean[n][n];

        int id=1;
        // storing the size of islands fo different ids
        List<Integer> size=new ArrayList<>();
        size.add(0);

        // loop to check for 1 and not yet visited and then provide an id and count the size
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                if(grid[r][c]==1 && !visited[r][c]){
                    size.add(giveId(grid,r,c,id));
                    id++;
                }
            }
        }
        if(size.size()==1) return 1;
        // checking for zero and then check for neighbors and then add their sizes
        int finalIslandSize=size.get(1);
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                int currIslandSize=1;
                if(grid[r][c]==0){
                    Set<Integer> set=new HashSet<>();

                    for(int[] d:dir){
                        int nr = r + d[0];
                        int nc = c + d[1];

                        if(nr<n && nr>=0 && nc<n && nc>=0 && grid[nr][nc]!=0 && !set.contains(grid[nr][nc])){
                            set.add(grid[nr][nc]);
                            currIslandSize+=size.get(grid[nr][nc]);
                        }

                    }

                    finalIslandSize=Math.max(finalIslandSize,currIslandSize);
                }
            }
        }

        return finalIslandSize;

    }
    int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
    //  method which implements the function of providing the id and calculating the size
    int giveId(int[][] grid, int r , int c, int id){

        visited[r][c]=true;
        grid[r][c]=id;

        int size=1;
        for(int[] d:dir){
            int nr=r+d[0];
            int nc=c+d[1];

            if(nr<n && nr>=0 && nc<n && nc>=0 && grid[nr][nc]==1 && !visited[nr][nc]){
                size+=giveId(grid,nr,nc,id);
            }
        }
        return size;
    }
}