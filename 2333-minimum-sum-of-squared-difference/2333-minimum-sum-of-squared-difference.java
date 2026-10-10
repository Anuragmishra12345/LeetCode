class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n=nums1.length;
        int maxDiff=0;
        int[] diff=new int[n];

        long total=0;

        long k=(long)k1+k2;

        for(int i=0;i<n;i++){
            diff[i]=Math.abs(nums1[i]-nums2[i]);
            maxDiff=Math.max(maxDiff,diff[i]);
            total+=diff[i];
        }

        if(k>=total) return 0;

        int[] freq=new int[maxDiff+1];

        for(int d:diff) freq[d]++;

        for(int i=maxDiff; i>0 && k>0; i--){
            if(freq[i]==0) continue;
            long moves=Math.min(k,freq[i]);

            freq[i]-=(int) moves;
            freq[i-1]+=(int) moves;

            k-=moves;
        }

        long ans=0;

        for(int i=1;i<=maxDiff;i++){
            ans+=(long)i*i*freq[i];
        }

        return ans;
    }
}