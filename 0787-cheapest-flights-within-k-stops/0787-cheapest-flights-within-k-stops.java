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
        int stop;
        int node;
        int dist;

        Tuple(int stop, int node, int dist){
            this.stop=stop;
            this.node=node;
            this.dist=dist;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj=new ArrayList<>();

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] row:flights){
            int node1=row[0];
            int node2=row[1];
            int dist=row[2];

            adj.get(node1).add(new Pair(node2,dist));
        }

        Queue<Tuple> q=new LinkedList<>();
        q.add(new Tuple(0,src,0));

        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;

        while(!q.isEmpty()){
            Tuple t=q.poll();
            int stop=t.stop;
            int node=t.node;
            int distance=t.dist;

            for(Pair p:adj.get(node)){
                int adjNode=p.node;
                int adjDist=p.dist;

                if(distance + adjDist < dist[adjNode] && stop<=k){
                    dist[adjNode]=distance+adjDist;
                    q.add(new Tuple(stop+1,adjNode,dist[adjNode]));
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE) return -1;
        return dist[dst];

    }
}