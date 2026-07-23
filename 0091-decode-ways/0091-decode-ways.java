class Solution {
    // int[] dp;
    // public int numDecodings(String s) {
    //     if(s.charAt(0)=='0') return 0;

    //     dp=new int[s.length()];
    //     Arrays.fill(dp,-1);

    //     return func(s,0);
    // }
    // int func(String s, int index){
    //     if(index==s.length()) return 1;

    //     if(dp[index]!=-1) return dp[index];

    //     int one=0;
    //     if(s.charAt(index)!='0') one=func(s,index+1);

    //     int two=0;

    //     if(index<s.length()-1 && Integer.parseInt(s.substring(index,index+2))<=26 && s.charAt(index)!='0') {
    //         two=func(s,index+2);
    //     }

    //     return dp[index]=one+two;
    // }

    public int numDecodings(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        dp[n]=1;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)!='0') dp[i]=dp[i+1];

            if(i<n-1 && (s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<='6'))){
                dp[i]+=dp[i+2];
            }
        }
        return dp[0];
    }
}