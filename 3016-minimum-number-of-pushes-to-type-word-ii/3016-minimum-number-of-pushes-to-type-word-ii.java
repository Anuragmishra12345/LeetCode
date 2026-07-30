class Solution {
    public int minimumPushes(String word) {
        int[] freq=new int[26];
        for(char ch:word.toCharArray()){
            freq[ch-'a']++;
        }
        Arrays.sort(freq);
        int ans=0;
        int step=0;
        for(int i=freq.length-1;i>=0;i--){
            if(freq[i]==0) continue;
            ans+=freq[i]*(step/8+1);
            step++;
        }
        return ans;
    }
}