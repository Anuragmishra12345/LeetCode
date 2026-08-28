class Solution {
    public boolean equalFrequency(String word) {
        int[] freq=new int[26];

        for(char ch:word.toCharArray()){
            freq[ch-'a']++;
        }

        for(int i=0;i<26;i++){
            if(freq[i]==0) continue;

            freq[i]--;
            Map<Integer,Integer> map=new HashMap<>();
            for(int j=0;j<26;j++){
                if(freq[j]==0) continue;
                map.put(freq[j],map.getOrDefault(freq[j],0)+1);
            }
            if(map.size()==1) return true;
            freq[i]++; 
        }
        return false;
    }
}