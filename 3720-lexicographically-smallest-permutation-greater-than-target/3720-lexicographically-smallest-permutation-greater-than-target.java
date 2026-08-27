class Solution {
    String result="";
    public String lexGreaterPermutation(String s, String target) {
        int[] freq=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        backtrack(freq,"",target,0);
        return result;
    }

    void backtrack(int[] freq, String curr, String target , int i){
        if(i==target.length()) return;

        char ch=target.charAt(i);
        if(freq[ch-'a']>0){
            freq[ch-'a']--;
            backtrack(freq,curr+ch,target,i+1);
            freq[ch-'a']++;
        }
        char nextChar=find(ch,freq);
        if(nextChar!=' '){
            freq[nextChar-'a']--;
            String r=curr+nextChar+getRemaining(freq);
            freq[nextChar-'a']++;
            if(target.compareTo(r)<0 && (result=="" || r.compareTo(result)<0)){
                result=r;
            }
        }
    }
    char find(char ch, int[] freq){
        char r=' ';
        for(char c=(char)(ch+1);c<='z';c++){
            if(freq[c-'a']>0) return c;
        }
        return r;
    }
    String getRemaining(int[] freq){
        StringBuilder sb=new StringBuilder();
        for(char ch='a';ch<='z';ch++){
            int f=freq[ch-'a'];
            for(int i=0;i<f;i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}