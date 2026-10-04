class Solution {
    Boolean[][] dp;
    public boolean checkValidString(String s) {
        dp=new Boolean[s.length()][s.length()+1];
        return dfs(s,0,0);
    }
    boolean dfs(String s, int i, int status){
        if(i==s.length()){
            if(status==0)  return true;
            else return false;
        }

        if(dp[i][status]!=null) return dp[i][status];

        boolean open=false;
        boolean close=false;
        boolean ignore=false;
        boolean normal=false;

        char ch=s.charAt(i);

        if(ch!='*'){
            if(ch=='('){
                normal=dfs(s,i+1,status+1);
            }
            else if(status>0){
                normal=dfs(s,i+1,status-1);
            }
        }
        else{
            open=dfs(s,i+1,status+1);

            if(status>0){
                close=dfs(s,i+1,status-1);
            }

            ignore=dfs(s,i+1,status);
        }
        return dp[i][status]= ignore || open || close || normal;
    }
}