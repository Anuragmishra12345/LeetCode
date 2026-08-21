class Solution {
    // boolean[] visited;
    // int n;
    // public int findCircleNum(int[][] isConnected) {
    //     n=isConnected.length;
    //     visited=new boolean[n];
    //     int count=0;
    //     for(int i=0;i<n;i++){
    //         if(!visited[i]){
    //             count++;
    //             dfs(i,isConnected);
    //         }
    //     }
    //     return count;
    // }
    // void dfs(int city,int[][] num){
    //     visited[city]=true;
    //     for(int i=0;i<n;i++){
    //         if(city==i) continue;
    //         if(!visited[i] && num[city][i]==1) dfs(i,num);
    //     }
    // }

    class DisjointSet{
        List<Integer> rank=new ArrayList<>();
        List<Integer> parent=new ArrayList<>();
        List<Integer> size=new ArrayList<>();

        DisjointSet(int n){
            for(int i=0;i<=n;i++){
                rank.add(0);
                parent.add(i);
                size.add(1);
            }
        }

        public int findUPar(int node){
            if(parent.get(node)==node) return node;

            int par=findUPar(parent.get(node));
            parent.set(node,par);
            return par;
        }

        public void unionByRank(int u, int v){
            int pu=findUPar(u);
            int pv=findUPar(v);

            if(pu==pv) return;
            if(rank.get(pu)<rank.get(pv)){
                parent.set(pu,pv);
            }
            else if(pu>pv){
                parent.set(pv,pu);
            }
            else {
                rank.set(pu,rank.get(pu)+1);
                parent.set(pv,pu);
            }
        }

        public void unionBySize(int u, int v){
            int pu=findUPar(u);
            int pv=findUPar(v);

            if(pu==pv) return;

            if(size.get(pv)<size.get(pu)){
                size.set(pu,size.get(pu)+size.get(pv));
                parent.set(pv,pu);
            }
            else {
                size.set(pv,size.get(pv)+size.get(pu));
                parent.set(pu,pv);
            }

        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        DisjointSet ds=new DisjointSet(n);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1) ds.unionBySize(i,j);
            }
        }

        int count=0;
        for(int i=0;i<n;i++){
            if(ds.parent.get(i)==i) count++;
        }
        return count;
    }
}