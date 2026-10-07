class Solution {
    boolean[] visited;
    int maxScore=0;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        List<List<int[]>> adjList=new ArrayList<>();

        visited=new boolean[values.length];
        visited[0]=true;

        for(int i=0;i<values.length;i++) adjList.add(new ArrayList<>());

        for(int[] e:edges){
            adjList.get(e[0]).add(new int[]{e[1],e[2]});
            adjList.get(e[1]).add(new int[]{e[0],e[2]});
        } 

        dfs(adjList, maxTime, values, 0, 0, values[0]);

        return maxScore;
    }
    void dfs(List<List<int[]>> adjList,int maxTime,int[] values, int time, int node, int score){
        if(node==0){
            maxScore=Math.max(score,maxScore);
        }

        for(int[] nodes: adjList.get(node)){
            int adjNode=nodes[0];
            int adjTime=nodes[1];

            if(time+adjTime>maxTime) continue;

            boolean alreadyVisited=visited[adjNode];

            int newScore=score;

            if(!alreadyVisited){
                visited[adjNode]=true;
                newScore+=values[adjNode];
            }

            dfs(adjList, maxTime, values, time+adjTime, adjNode, newScore);

            if(!alreadyVisited){
                visited[adjNode]=false;
            }
        }
    }
}