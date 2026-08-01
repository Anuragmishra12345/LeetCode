class Solution {
    class Pair{
        char c;
        int v;

        Pair(char c,int v){
            this.c=c;
            this.v=v;
        }
    }
    public String frequencySort(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Integer.compare(b.v,a.v));

        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            pq.offer(new Pair(entry.getKey(),entry.getValue()));
        }

        StringBuilder result=new StringBuilder();

        while(!pq.isEmpty()){
            char ch=pq.peek().c;
            int value=pq.poll().v;

            for(int i=0;i<value;i++) result.append(ch);
        }
        return result.toString();
    }
}