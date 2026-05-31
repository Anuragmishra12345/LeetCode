class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;

        Map<Character,Character> sToT=new HashMap<>();
        Map<Character,Character> tToS=new HashMap<>();

        int len =s.length();
        int i=0;

        while(i<s.length()){
            char c1=s.charAt(i);
            char c2=t.charAt(i);

            if(sToT.containsKey(c1) && c2!=sToT.get(c1)) return false;
            if(tToS.containsKey(c2) && c1!=tToS.get(c2)) return false;
            
            sToT.put(c1,c2);
            tToS.put(c2,c1);
            
            i++;
        }
        return true;
    }
}