class Solution {
    class Pair{
        int node;
        int dist;

        Pair(int node, int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    class Tuple{
        int node;
        int stop;
        int dist;

        Tuple(int node, int stop, int dist){
            this.node=node;
            this.stop=stop;
            this.dist=dist;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj=new ArrayList<>();

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] f:flights){
            int from=f[0];
            int to=f[1];
            int dist=f[2];

            adj.get(from).add(new Pair(to,dist));
        }

        Queue<Tuple> q=new LinkedList<>();
        q.offer(new Tuple(src,0,0));

        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        while(!q.isEmpty()){
            Tuple t=q.poll();
            int node=t.node;
            int stop=t.stop;
            int d=t.dist;

            if(stop>k) continue;

            for(Pair p:adj.get(node)){
                int adjNode=p.node;
                int adjDist=p.dist;

                if(d+adjDist<dist[adjNode]){
                    dist[adjNode]=d+adjDist;
                    q.offer(new Tuple(adjNode,stop+1,d+adjDist));
                }
            }
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}