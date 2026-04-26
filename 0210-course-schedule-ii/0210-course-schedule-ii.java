class Solution {
    // boolean[] visited;
    // boolean[] path;
    // public int[] findOrder(int numCourses, int[][] pr) {
    //     visited=new boolean[numCourses];
    //     path = new boolean[numCourses];
    //     Stack<Integer> stack=new Stack<>();

    //     List<List<Integer>> adj=new ArrayList<>();
    //     for(int i=0;i<numCourses;i++){
    //         adj.add(new ArrayList<>());
    //     }
    //     for(int[] it:pr){
    //         adj.get(it[1]).add(it[0]);
    //     }

    //     for(int i=0;i<numCourses;i++){
    //         if(!visited[i]) {
    //             if(dfs(i, adj, stack)) return new int[0]; 
    //         }
    //     }

    //     int[] result=new int[numCourses];
    //     int i=0;
    //     while(!stack.isEmpty()){
    //         result[i++]=stack.pop();
    //     }
    //     return result;
    // }
    // public boolean dfs(int node,List<List<Integer>> adj,Stack<Integer> stack){
    //     visited[node]=true;
    //     path[node]=true;
    //     for(int n:adj.get(node)){
    //         if(!visited[n]){
    //             if(dfs(n, adj, stack)) return true;
    //         }
    //         else if(path[n]){
    //             return true; 
    //         }
    //     }
    //     stack.push(node);
    //     path[node]=false;
    //     return false;
    // }


    public int[] findOrder(int numCourses, int[][] pr) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree=new int[numCourses];
        for(int[] it:pr){
            adj.get(it[1]).add(it[0]);
            indegree[it[0]]++;
        }

        Queue<Integer> queue=new LinkedList<>();
        int[] result=new int[numCourses];
        int idx=0;
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) queue.offer(i);
        }

        while(!queue.isEmpty()){
            int node=queue.poll();
            result[idx++]=node;

            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) queue.offer(it);
            }
        }

        if(idx!=numCourses) return new int[0];

        return result;
    }
}    