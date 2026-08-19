class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer,Set<Integer>> map=new HashMap<>();
        for(int[] r:reservedSeats){
            map.computeIfAbsent(r[0],x->new HashSet<>()).add(r[1]);
        }
        int groups=2*n;
        
        for(Set<Integer> set:map.values()){
            boolean left=true;
            boolean middle=true;
            boolean right=true;
            for(int s:set){
                if(s>=2 && s<=5) left=false;
                if(s>=4 && s<=7) middle=false;
                if(s>=6 && s<=9) right=false;
            }

            if(left && right){

            }
            else if(middle || left || right) groups--;
            else groups-=2;
        }

        return groups;
    }
}