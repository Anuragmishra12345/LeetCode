class Solution {
    public int titleToNumber(String columnTitle) {
        int ans=0;
        int pow=columnTitle.length()-1;
        for(int i=0;i<columnTitle.length();i++){
            int num=columnTitle.charAt(i)-'A'+1;
            ans+=num*Math.pow(26,pow--);
        }
        return ans;
    }
}