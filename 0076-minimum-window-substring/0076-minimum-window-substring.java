class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int count=t.length();
        int start=0;
        int left=0;
        int minLen=Integer.MAX_VALUE;

        Map<Character,Integer> map=new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int right=0;right<n;right++){
            char ch=s.charAt(right);
            if(map.containsKey(ch)){
                if(map.get(ch)>0) count--;
                map.put(ch, map.get(ch) - 1);
            }

            while(count==0){
                if(right-left+1<minLen){
                    minLen = right - left + 1;
                    start=left;
                }
                char lc=s.charAt(left);
                if(map.containsKey(lc)){
                    map.put(lc,map.get(lc)+1);
                    if(map.get(lc)>0) count++;
                }
                left++;
            }
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(start,start+minLen);

    }
}