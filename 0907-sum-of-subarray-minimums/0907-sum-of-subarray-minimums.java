class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int MOD=1000000007;
        int[] previous=new int[n];

        int[] next=new int[n];

        Deque<Integer> stack=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[i]<arr[stack.peek()]){
                stack.pop();
            }
            previous[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[i]<=arr[stack.peek()]){
                stack.pop();
            }
            next[i]=stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        long ans=0;
        for(int i=0;i<n;i++){
            int left=i-previous[i];
            int right=next[i]-i;
            ans=(ans+(long)arr[i]*left*right)%MOD;
        }
        return (int)ans;
    }
}