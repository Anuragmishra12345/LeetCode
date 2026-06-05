class Solution {
    public boolean rotateString(String s, String goal) {
        // int n=s.length();
        // if(goal.length()!=n) return false;

        // int right=0;
        // while(right<n){
        //     if(s.charAt(right)==goal.charAt(0)){
        //         int end=n-right;
        //         String s1=s.substring(right,n);
        //         String g1=goal.substring(0,end);

        //         String s2=s.substring(0,right);
        //         String g2=goal.substring(end,n);

        //         if(s1.equals(g1) && s2.equals(g2)) return true;
        //     }
        //     right++;
        // }
        // return false;

        return s.length()==goal.length() && (s+s).contains(goal);

    }
}