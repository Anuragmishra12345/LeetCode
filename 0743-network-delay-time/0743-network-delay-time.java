class Solution {
    class Pair{
        int v;
        int w;
        Pair(int v, int w){
            this.v=v;
            this.w=w;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj=new ArrayList<>();

        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(int[] t:times){
            adj.get(t[0]).add(new Pair(t[1],t[2]));
        }

        int[] minTime=new int[n+1];
        Arrays.fill(minTime,Integer.MAX_VALUE);

        minTime[k]=0;

        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(k,0));

        while(!q.isEmpty()){
            Pair cell=q.poll();
            int node=cell.v;
            int time=cell.w;

            for(Pair p:adj.get(node)){
                int adjNode=p.v;
                int adjTime=p.w;

                if(adjTime+time<minTime[adjNode]){
                    minTime[adjNode]=adjTime+time;
                    q.offer(new Pair(adjNode,adjTime+time));
                }
            }
        }
        int min=-1;
        for(int i=1;i<=n;i++){
            if(minTime[i]==Integer.MAX_VALUE) return -1;
            min=Math.max(min,minTime[i]);
        }
        return min;
    }
}