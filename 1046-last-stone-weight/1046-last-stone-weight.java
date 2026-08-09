class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->Integer.compare(b,a));

        for(int s:stones) pq.offer(s);

        while(pq.size()>1){
            int stone1=pq.poll();
            int stone2=pq.poll();

            if(stone1==stone2) continue;
            else pq.offer(Math.abs(stone1-stone2));
        }
        return pq.isEmpty()?0:pq.poll();
    }
}