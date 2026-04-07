class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> map=new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0, count = p.length();
        List<Integer> list=new ArrayList<>();
        for (int right = 0; right < s.length(); right++) {
            char ch=s.charAt(right);
            if(map.containsKey(ch)){
                if(map.get(ch)>0) count--;
                map.put(ch,map.get(ch)-1);
            }
            if(right-left+1>p.length()){
                char leftChar = s.charAt(left);
                if(map.containsKey(leftChar)){
                    map.put(leftChar,map.get(leftChar)+1);
                    if(map.get(leftChar)>0) count++;
                }
                left++;
            }
            if(count==0){
                list.add(left);
            }
        }
        
        return list;
    }
}