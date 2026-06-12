class Solution {
    // public boolean isAnagram(String s, String t) {
    //     if(s.length()!=t.length()) return false;

    //     char[] sc=s.toCharArray();
    //     char[] tc=t.toCharArray();

    //     Arrays.sort(sc);
    //     Arrays.sort(tc);

    //     for(int i=0;i<sc.length;i++){
    //         if(sc[i]!=tc[i]) return false;
    //     }
    //     return true;
    // }


    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        Map<Character,Integer> map=new HashMap();

        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch:t.toCharArray()){
            if(!map.containsKey(ch)) return false;
            else{
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0) map.remove(ch);
            }
        }
        if(!map.isEmpty()) return false;
        return true;

    }
}