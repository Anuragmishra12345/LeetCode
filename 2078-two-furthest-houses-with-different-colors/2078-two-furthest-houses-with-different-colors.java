class Solution {
    public int maxDistance(int[] colors) {
        int max=0;
        for(int i=colors.length-1;i>0;i--){
            if(colors[0]!=colors[i]) {
                max=i;
                break;

            }
        }

        for(int i=0;i<colors.length-1;i++){
            if(colors[0]!=colors[i]){
                max=Math.max(max,colors.length-1-i);
                break;
            }
        }
        return max;
    }
}