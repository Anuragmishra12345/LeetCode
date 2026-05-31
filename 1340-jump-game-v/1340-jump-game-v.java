class Solution {
    Integer[] dp;
    public int maxJumps(int[] arr, int d) {
        dp=new Integer[arr.length];
        int ans=0;
        for(int i=0;i<arr.length;i++){
            ans=Math.max(f(i,arr,d),ans);
        }
        return ans;
    }
    int f(int index,int[] arr, int d){
        if(dp[index]!=null) return dp[index];
        int ans=1;
        for(int i=index+1;i<=Math.min(index+d,arr.length-1);i++){
            if(arr[i]>=arr[index] ) break;
            ans=Math.max(f(i,arr,d)+1,ans);
        }
        for(int i=index-1;i>=Math.max(index-d,0);i--){
            if(arr[i]>=arr[index] ) break;
            ans=Math.max(1+f(i,arr,d),ans);
        }
        return dp[index]=ans;
    }
}