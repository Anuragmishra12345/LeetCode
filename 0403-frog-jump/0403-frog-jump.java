class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer,Set<Integer>> map=new HashMap<>();
        for(int stone: stones) map.put(stone, new HashSet<>());

        map.get(0).add(0);

        for(int stone:stones){
            for(int k:map.get(stone)){
                for(int jump=k-1;jump<=k+1;jump++){
                    if(jump>0 && map.containsKey(stone+jump)){
                        map.get(stone+jump).add(jump);
                    }
                }
            }
        }
        return !map.get(stones[stones.length-1]).isEmpty();
    }
}