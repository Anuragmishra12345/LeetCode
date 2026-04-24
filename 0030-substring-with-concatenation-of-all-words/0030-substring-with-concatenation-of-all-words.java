class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result=new ArrayList<>();
        int n=s.length();
        int wordLen=words[0].length();
        int arrayLen=words.length;
        int totalLen=wordLen*arrayLen;

        Map<String, Integer> map=new HashMap<>();

        for(String w:words){
            map.put(w,map.getOrDefault(w,0)+1);
        }

        for(int i=0;i<wordLen;i++){
            int left=i;
            int count=0;
            Map<String, Integer> visited=new HashMap<>();

            for(int right=i;right+wordLen<=n;right+=wordLen){
                String w=s.substring(right,right+wordLen);

                if(map.containsKey(w)){
                    visited.put(w,visited.getOrDefault(w,0)+1);
                    count++;

                    while(visited.get(w)>map.get(w)){
                        String wl=s.substring(left,left+wordLen);
                        visited.put(wl,visited.get(wl)-1);
                        left+=wordLen;
                        count--;
                    }
                    if(count==arrayLen) result.add(left);
                    }
                else {
                    count=0;
                    visited.clear();
                    left=right+wordLen;
                }
            }
        }
        return result;
    }
}