class Solution {
    class Fenwik{
        int[] bit;
        Fenwik(int n){
            bit=new int[n+2];
        }

        void update(int idx, int val){
            while(idx<bit.length){
                bit[idx]+=val;
                idx+=idx&-idx;
            }
        }

        int query(int idx){
            int sum=0;

            while(idx>0){
                sum+=bit[idx];
                idx-=idx&-idx;
            }
            return sum;
        }
    }
    public long countMajoritySubarrays(int[] nums, int target) {
        int n=nums.length;
        int offset=n+2;

        Fenwik bit=new Fenwik(2*n+5);

        int prefix=0;
        long ans=0;

        bit.update(prefix+offset,1);

        for(int num:nums){
            if(num==target) prefix++;
            else prefix--;

            ans+=bit.query(prefix - 1 + offset);

            bit.update(prefix+offset,1);
        }
        return ans;
    }
}