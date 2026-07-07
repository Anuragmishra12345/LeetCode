class Solution {
    public long sumAndMultiply(int n) {
        String num=Integer.toString(n);
        long sum=0;
        long x=0;
        for(char ch:num.toCharArray()){
            int i=ch-'0';
            if(i==0) continue;
            x=x*10+i;
            sum+=i;
        }
        return x*sum;
    }
}