class Solution {
    boolean[] visited;
    boolean[] path;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited=new boolean[numCourses];
        path=new boolean[numCourses];

        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<numCourses;i++) adjList.add(new ArrayList<>());

        for(int[] p:prerequisites){
            int a=p[0];
            int b=p[1];

            adjList.get(b).add(a);
        }

        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(dfs(i,adjList)) return false;
            }
        }
        return true;
    }

    boolean dfs(int node, List<List<Integer>> adjList){
        visited[node]=true;
        path[node]=true;

        for(int n:adjList.get(node)){
            if(!visited[n]){
                if(dfs(n,adjList)) return true;
            }
            else if(path[n]) return true;
        }


        path[node]=false;
        return false;
    }
}