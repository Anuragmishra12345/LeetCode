class Solution {
    class Pair{
        int node;
        int time;

        Pair(int node, int time){
            this.node=node;
            this.time=time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj=new ArrayList<>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] row:times){
            int node1=row[0];
            int node2=row[1];
            int time=row[2];

            adj.get(node1).add(new Pair(node2,time));
        }
        int[] timesArray=new int[n+1];
        Arrays.fill(timesArray,Integer.MAX_VALUE);
        timesArray[k]=0;

        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.time-y.time);
        pq.add(new Pair(k,0));

        while(!pq.isEmpty()){
            int node=pq.peek().node;
            int time=pq.peek().time;
            pq.poll();

            if(timesArray[node]<time) continue;

            for(Pair p:adj.get(node)){
                int adjNode=p.node;
                int adjTime=p.time;

                if(time+adjTime<timesArray[adjNode]) {
                    timesArray[adjNode]=time+adjTime;
                    pq.add(new Pair(adjNode,timesArray[adjNode]));
                }
            }
        }
        int minTime=0;
        for(int i=1;i<timesArray.length;i++){
            int t=timesArray[i];
            if(t==Integer.MAX_VALUE) return -1;
            else minTime=Math.max(minTime,t);
        }
        return minTime;
    }
}