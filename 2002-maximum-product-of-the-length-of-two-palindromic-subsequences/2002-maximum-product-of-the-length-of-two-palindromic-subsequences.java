class Solution {
    int ans=0;
    public int maxProduct(String s) {
        func(s,0,"","");
        return ans;
    }
    void func(String s, int i, String p1, String p2){
        if(i==s.length()){
            if(isPalindrome(p1) && isPalindrome(p2)){
                ans=Math.max(p1.length()*p2.length(),ans);
            }
            return ;
        }

        func(s,i+1,p1+s.charAt(i),p2);
        func(s,i+1,p1,p2+s.charAt(i));
        func(s,i+1,p1,p2);
    }

    boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}