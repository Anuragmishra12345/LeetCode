class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));

        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            pq.offer(new int[]{entry.getKey(),entry.getValue()});

            if(pq.size()>k) pq.poll();
        }

        int[] result=new int[k];

        for(int i=0;i<k;i++){
            int[] curr=pq.poll();
            result[i]=curr[0];
        }
        return result;
    }
}