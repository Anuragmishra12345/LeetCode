class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        if(n==1 || n==2) return n;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        int minIndex=-1;
        int maxIndex=-1;

        for(int i=0;i<n;i++){
            int num=nums[i];
            if(num>max){
                max=num;
                maxIndex=i;
            }
            if(num<min){
                min=num;
                minIndex=i;
            }
        }

        if(minIndex<=n/2 && maxIndex<=n/2) return Math.max(minIndex,maxIndex)+1;
        else if(minIndex>=n/2 && maxIndex>=n/2){
            int first=n-minIndex;
            int second=n-maxIndex;
            return Math.max(first,second);
        }
        else {
            int remove=Integer.MAX_VALUE;
            if(minIndex<=n/2){
                remove=Math.min(maxIndex+1,1+minIndex+n-maxIndex);
                remove=Math.min(remove,n-minIndex);
            }
            else{
                int secondRemove=Math.min(minIndex+1,1+maxIndex+n-minIndex);
                remove=Math.min(remove,secondRemove);
                remove=Math.min(remove,n-maxIndex);
            }
            return remove;
        }
    }
}