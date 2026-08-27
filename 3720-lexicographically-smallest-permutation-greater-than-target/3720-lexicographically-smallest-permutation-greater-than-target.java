class Solution {
    // String result="";
    // public String lexGreaterPermutation(String s, String target) {
    //     int[] freq=new int[26];
    //     for(char ch:s.toCharArray()){
    //         freq[ch-'a']++;
    //     }
    //     backtrack(freq,"",target,0);
    //     return result;
    // }

    // void backtrack(int[] freq, String curr, String target , int i){
    //     if(i==target.length()) return;

    //     char ch=target.charAt(i);
    //     if(freq[ch-'a']>0){
    //         freq[ch-'a']--;
    //         backtrack(freq,curr+ch,target,i+1);
    //         freq[ch-'a']++;
    //     }
    //     char nextChar=find(ch,freq);
    //     if(nextChar!=' '){
    //         freq[nextChar-'a']--;
    //         String r=curr+nextChar+getRemaining(freq);
    //         freq[nextChar-'a']++;
    //         if(result.equals("") || r.compareTo(result) < 0) {
    //             result = r;
    //         }
    //     }
    // }
    // char find(char ch, int[] freq){
    //     char r=' ';
    //     for(char c=(char)(ch+1);c<='z';c++){
    //         if(freq[c-'a']>0) return c;
    //     }
    //     return r;
    // }
    // String getRemaining(int[] freq){
    //     StringBuilder sb=new StringBuilder();
    //     for(char ch='a';ch<='z';ch++){
    //         int f=freq[ch-'a'];
    //         for(int i=0;i<f;i++){
    //             sb.append(ch);
    //         }
    //     }
    //     return sb.toString();
    // }

    public String lexGreaterPermutation(String s, String target) {
        StringBuilder prefix=new StringBuilder();
        int m=target.length();
        int[] freq=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        int matchLen = 0;
        while (matchLen < m && freq[target.charAt(matchLen) - 'a'] > 0) {
            freq[target.charAt(matchLen) - 'a']--;
            matchLen++;
        }

        for(int i=matchLen;i>=0;i--){
            if (i < matchLen) {
                freq[target.charAt(i) - 'a']++;
            }

            if(i<m){
                int current=target.charAt(i) - 'a';
                for(int c=current+1;c<26;c++){
                    if(freq[c]>0){
                        StringBuilder ans=new StringBuilder();
                        ans.append(target,0,i);
                        ans.append((char)(c+'a'));
                        freq[c]--;

                        for(int x=0;x<26;x++){
                            while(freq[x]>0){
                                ans.append((char)(x+'a'));
                                freq[x]--;
                            }
                        }
                        return ans.toString();
                    }
                }
            }
        }
        return "";
    }
}