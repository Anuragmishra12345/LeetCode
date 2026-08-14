class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int r=startPos[0];
        int c=startPos[1];
        int m=s.length();

        int[] ans=new int[m];
        for(int i=0;i<m;i++){
            ans[i]=dfs(n,r,c,i,s);
        }
        return ans;
    }
    int dfs(int n, int i, int j, int index, String s){
        if(index==s.length()) return 0;
        char dir=s.charAt(index);
        int r=i;
        int c=j;

        if(dir=='R') c++;
        else if(dir=='L') c--;
        else if(dir=='U') r--;
        else r++;

        if(r>=n || c>=n || r<0 || c<0 ) return 0;

        int step=1+dfs(n,r,c,index+1,s);

        return step;
    }
}