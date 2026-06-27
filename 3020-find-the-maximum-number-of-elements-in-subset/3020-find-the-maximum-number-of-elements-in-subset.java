class Solution {
    public int maximumLength(int[] nums) {
        Map<Long,Integer> map=new HashMap<>();

        for(int num:nums){
            map.put((long)num,map.getOrDefault((long)num,0)+1);
        }
        int ans=1;

        if(map.containsKey(1L)){
            int count=map.get(1L);
            if(count%2==0) count--;
            ans=count;
        }

        for(long start:map.keySet()){
            if(start==1) continue;

            long curr=start;
            int count=0;
            
            while(true){
                int cnt=map.getOrDefault(curr,0);
                if(cnt==0){
                    count--;
                    break;
                }
                if(cnt==1) {
                    count++;
                    break;
                }
                count+=2;
                if(curr>(long)Math.sqrt(Long.MAX_VALUE));
                curr=curr*curr;
            }
            ans=Math.max(ans,count);
        }
        return ans;
    }
}