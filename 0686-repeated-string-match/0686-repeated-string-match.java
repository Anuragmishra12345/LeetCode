class Solution {
    public int repeatedStringMatch(String a, String b) {
        int repeat=1;
        int n1=a.length();
        int n2=b.length();
        StringBuilder sa=new StringBuilder(a);
        while(sa.length()<n2){
            sa.append(a);
            repeat++;
        }
        if(isSubstring(sa.toString(),b)) return repeat;
        sa.append(a);
        repeat++;
        if(isSubstring(sa.toString(),b)) return repeat;
        return -1;
    }
    boolean isSubstring(String a, String b){
        for(int i=0;i<=a.length()-b.length();i++){
            int j=0;
            while(j<b.length() && a.charAt(i+j)==b.charAt(j)) j++;
            if(j==b.length()) return true;
        }
        return false;
    }
}