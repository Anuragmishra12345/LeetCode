class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count=0;
        int ng=g.length;
        int ns=s.length;
        Arrays.sort(s);
        Arrays.sort(g);
        int i=0;
        int j=0;
        while(i<ng && j<ns){
            if(g[i]<=s[j]){
                i++;
                j++;
                count++;
            }
            else if(g[i]>s[j]) j++;
            else i++;
        }
        
        return count;
    }
}