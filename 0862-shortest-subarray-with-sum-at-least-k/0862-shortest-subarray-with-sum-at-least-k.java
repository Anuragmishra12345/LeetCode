class Solution {
    // public int shortestSubarray(int[] nums, int k) {
    //     int ans=Integer.MAX_VALUE;
    //     PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
    //     pq.offer(new long[]{0,-1});
    //     long prefix=0;
    //     for(int i=0;i<nums.length;i++){
    //         prefix+=nums[i];
    //         if(prefix>=k) ans=Math.min(ans,i+1);
    //         while(!pq.isEmpty() && prefix-pq.peek()[0]>=k){
    //             ans=Math.min(ans,i-(int)pq.peek()[1]);
    //             pq.poll();
    //         }
    //         pq.offer(new long[]{prefix,i});
    //     }

    //     return ans==Integer.MAX_VALUE?-1:ans;
    // }

    public int shortestSubarray(int[] nums, int k) {
        Deque<long[]> dq=new ArrayDeque<>();
        int ans=Integer.MAX_VALUE;

        long prefixSum=0;
        dq.offerLast(new long[]{0, -1});

        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];

            if(prefixSum>=k) ans=Math.min(ans,i+1);

            while(!dq.isEmpty() && prefixSum-dq.peekFirst()[0]>=k){
                ans=Math.min(ans,i-(int)dq.peekFirst()[1]);
                dq.pollFirst();
            }

            while(!dq.isEmpty() && dq.peekLast()[0]>=prefixSum) dq.pollLast();

            dq.offerLast(new long[]{prefixSum,i});
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}