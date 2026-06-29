class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int ans=Integer.MAX_VALUE;
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
        pq.offer(new long[]{0,-1});
        long prefix=0;
        for(int i=0;i<nums.length;i++){
            prefix+=nums[i];
            if(prefix>=k) ans=Math.min(ans,i+1);
            while(!pq.isEmpty() && prefix-pq.peek()[0]>=k){
                ans=Math.min(ans,i-(int)pq.peek()[1]);
                pq.poll();
            }
            pq.offer(new long[]{prefix,i});
        }

        return ans==Integer.MAX_VALUE?-1:ans;
    }
}