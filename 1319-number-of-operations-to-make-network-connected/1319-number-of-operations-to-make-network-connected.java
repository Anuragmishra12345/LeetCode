class Solution {
    class DisjointSet{
        List<Integer> size=new ArrayList<>();
        List<Integer> parent=new ArrayList<>();

        DisjointSet(int n){
            for(int i=0;i<n;i++){
                size.add(1);
                parent.add(i);
            }
        }
        public int findUPar(int node){
            if(parent.get(node)==node) return node;
            int p=findUPar(parent.get(node));
            parent.set(node,p);
            return p;
        }

        public void unionBySize(int u, int v){
            int pu=findUPar(u);
            int pv=findUPar(v);

            if(pu==pv) return;
            if(size.get(pu)<size.get(pv)){
                size.set(pv,size.get(pu)+size.get(pv));
                parent.set(pu,pv);
            }
            else{
                size.set(pu,size.get(pv)+size.get(pu));
                parent.set(pv,pu);
            }
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;
        DisjointSet ds=new DisjointSet(n);

        for(int[] c:connections){
            ds.unionBySize(c[0],c[1]);
        }

        int components=0;

        for(int i=0;i<n;i++){
            if(ds.parent.get(i)==i) components++;
        }

        return components-1;
    }
}