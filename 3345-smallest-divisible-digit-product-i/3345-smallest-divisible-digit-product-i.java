class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            int digits=1;
            int curr=n;
            while(curr>0){
                digits*=curr%10;
                curr/=10;
                if(digits==0) return n;
            }
            if(digits%t==0) return n;
            n=n+1; 
        }
    }
}