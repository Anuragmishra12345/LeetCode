class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> map=new HashMap<>();
        for(char ch:s1.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int left=0; int count=s1.length();
        for(int right=0;right<s2.length();right++){
            char ch=s2.charAt(right);
            if(map.containsKey(ch)) {
                if (map.get(ch) > 0) count--;
                map.put(ch,map.get(ch)-1);
            }
            if(right-left+1>s1.length()){
                char lc=s2.charAt(left);
                if(map.containsKey(lc)){
                    map.put(lc, map.get(lc) + 1);
                    if(map.get(lc)>0) count++;
                }
                left++;
            }
            if(count==0) return true;
        }
        return false;
    }
}