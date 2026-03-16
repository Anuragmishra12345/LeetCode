class Solution {
    public int maxJump(int[] stones) {
        int max=0;
        for(int i=0;i<stones.length-1;i++){
            max=Math.max(max,stones[i+1]-stones[i]);
            if(i+2<stones.length){
                max=Math.max(max,stones[i+2]-stones[i]);
            }
        }
        return max;
    }
}