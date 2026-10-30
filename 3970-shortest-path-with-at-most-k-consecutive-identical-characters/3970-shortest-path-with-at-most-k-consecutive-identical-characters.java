class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        if(n==1) return 0;
        List<List<int[]>> adjList=new ArrayList<>();

        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] e:edges){
            adjList.get(e[0]).add(new int[]{e[1],e[2]});
        }

        int[][] dist=new int[n][k+1];

        for(int[] d:dist) Arrays.fill(d,Integer.MAX_VALUE);

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));

        dist[0][1]=0;
        pq.offer(new int[]{0,1,0});

        while(!pq.isEmpty()){
            int[] cell=pq.poll();

            int node=cell[0];
            int count=cell[1];
            int weight=cell[2];

            if(weight>dist[node][count]) continue;

            if(node==n-1) return weight;

            for(int[] edge: adjList.get(node)){
                int next=edge[0];
                int nextWeight=edge[1];

                int newCount;

                if(labels.charAt(node)==labels.charAt(next)) newCount=count+1;
                else newCount=1;

                if(newCount>k) continue;

                int currWeight=weight+nextWeight;
                if(currWeight<dist[next][newCount]){
                    dist[next][newCount]=currWeight;
                    pq.offer(new int[]{next,newCount,currWeight});
                }
            }
        }
        return -1;
    }
}