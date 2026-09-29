class Solution {
    int MOD=1000000007;
    Integer[][] dp;
    List<int[]> columns=new ArrayList<>();
    public int colorTheGrid(int m, int n) {
        generateColumn(m,0,new int[m]);

        int k=columns.size();

        dp = new Integer[n][k];

        long ans=0;

        for(int i=0;i<k;i++){
            ans+=dfs(n,1,i);
            ans%=MOD;
        }

        return (int)ans;
    }
    int dfs(int n, int c, int prevState){
        if(n==c) return 1;

        if (dp[c][prevState] != null) {
            return dp[c][prevState];
        }

        int k=columns.size();

        long ans=0;

        for(int i=0;i<k;i++){
            if(compatible(columns.get(prevState),columns.get(i))){
                ans+=dfs(n,c+1,i);
                ans%=MOD;
            }
        }

        return dp[c][prevState]=(int)ans;
    }

    void generateColumn(int m, int r, int[] column){
        if(m==r){
            columns.add(column.clone());
            return;
        }

        for(int i=1;i<=3;i++){
            if(r>0 && column[r-1]==i) continue;

            column[r]=i;
            generateColumn(m,r+1,column);
        }
    }

    boolean compatible(int[] a, int[] b){
        for(int i=0;i<a.length;i++){
            if(a[i]==b[i]) return false;
        }
        return true;
    }
}