class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()) map.put(ch,map.getOrDefault(ch,0)+1);

        List<Character>[] bucket=new  ArrayList[s.length()+1];
        for(Map.Entry<Character, Integer> entry: map.entrySet() ){
            char key=entry.getKey();
            int value=entry.getValue();
            if(bucket[value]==null) bucket[value]=new ArrayList<>();
            bucket[value].add(key);
        }
        StringBuilder result=new StringBuilder();
        for(int i=s.length();i>0 ;i--){
            if(bucket[i]==null) continue;
            for(char ch:bucket[i]){
                for(int j=0;j<i;j++){
                    result.append(ch);
                }
            }
        }
        return result.toString();
    }
}