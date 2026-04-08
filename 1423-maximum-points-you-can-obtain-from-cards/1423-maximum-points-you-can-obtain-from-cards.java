class Solution {
    public int maxScore(int[] cp, int k) {
        int left=0;
        int count=0;
        int maxCount=0;
        for(int i=0;i<cp.length;i++){
            maxCount+=cp[i];
        }
        for(int i=0;i<cp.length-k;i++){
            count+=cp[i];
        }
        int curr=count;
        for(int i=cp.length-k;i<cp.length;i++){
            curr-=cp[left];
            curr+=cp[i];
            left++;
            count=Math.min(count,Math.abs(curr));
        }
        return maxCount-count;
    }
}