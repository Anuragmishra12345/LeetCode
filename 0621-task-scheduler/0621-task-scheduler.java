class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(char ch:tasks){
            freq[ch-'A']++;
        }

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->Integer.compare(b,a));

        for(int f:freq){
            if(f>0) pq.offer(f);
        }
        int count=0;
        while(!pq.isEmpty()){
            int c=pq.poll();
            count++;

            ArrayList<Integer> list=new ArrayList<>();

            if(c==1 && pq.isEmpty()) break;
            
            int i=n;
            while(i>0 && pq.size()>0){
                int curr=pq.poll();
                if(curr-1>0) list.add(curr-1);
                count++;
                i--;
            }

            if(i>0 && list.size()!=0 || c>1) count+=i;

            if(c-1>0) pq.offer(c-1);

            for(int l:list) pq.offer(l);
            
        }
        return count;
    }
}