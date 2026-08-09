class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result=new int[numCourses];
        int[] indegree=new int[numCourses];
        int idx=0;

        Queue<Integer> q=new LinkedList<>();

        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());

        for(int[] pr:prerequisites){
            adj.get(pr[1]).add(pr[0]);
            indegree[pr[0]]++;
        }

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) q.offer(i);
        }

        while(!q.isEmpty()){
            int node=q.poll();
            result[idx++]=node;

            for(int n:adj.get(node)){
                indegree[n]--;
                if(indegree[n]==0) q.offer(n);
            }
        }

        if(idx!=numCourses) return new int[0];
        return result;
    }
}