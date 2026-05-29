class Solution {
    class Pair{
        char ch;
        int freq;

        Pair(char ch, int freq){
            this.ch=ch;
            this.freq=freq;
        }
    }
    public String reorganizeString(String s) {
        Map<Character,Integer> map=new HashMap<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.freq-a.freq);
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            char key=entry.getKey();
            int freq=entry.getValue();
            pq.offer(new Pair(key,freq));
        }
        StringBuilder result=new StringBuilder();
        while(!pq.isEmpty()){
            Pair p1=pq.poll();
            Pair p2=null;
            if(!pq.isEmpty()) p2=pq.poll();

            if(p2==null && (p1.freq>1 || (result.length()>=1 && result.charAt(result.length()-1)==p1.ch))) return "";

            result.append(p1.ch);
            if(p2!=null) result.append(p2.ch);

            if(p1.freq>1) pq.offer(new Pair(p1.ch,p1.freq-1));
            if(p2!=null && p2.freq>1) pq.offer(new Pair(p2.ch,p2.freq-1));
        }
        return result.toString();
    }
}