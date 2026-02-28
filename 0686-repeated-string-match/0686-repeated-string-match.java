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
    // boolean isSubstring(String a, String b){
    //     for(int i=0;i<=a.length()-b.length();i++){
    //         int j=0;
    //         while(j<b.length() && a.charAt(i+j)==b.charAt(j)) j++;
    //         if(j==b.length()) return true;
    //     }
    //     return false;
    // }
    boolean isSubstring(String text, String pattern) {
    if(pattern.length() == 0) return true;

    int[] lps = buildLPS(pattern);

    int i = 0; // pointer for text
    int j = 0; // pointer for pattern

    while(i < text.length()){
        if(text.charAt(i) == pattern.charAt(j)){
            i++;
            j++;

            if(j == pattern.length()) return true;
        } 
        else {
            if(j != 0){
                j = lps[j - 1]; // ⭐ KMP magic
            } else {
                i++;
            }
        }
    }
    return false;
}
    int[] buildLPS(String pattern){
    int n = pattern.length();
    int[] lps = new int[n];

    int len = 0; // length of previous longest prefix suffix
    int i = 1;

    while(i < n){
        if(pattern.charAt(i) == pattern.charAt(len)){
            len++;
            lps[i] = len;
            i++;
        } 
        else {
            if(len != 0){
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }
    }
    return lps;
}
}