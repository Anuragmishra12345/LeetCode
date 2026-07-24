class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int r=startPos[0];
        int c=startPos[1];
        int cost=0;
        while(r<homePos[0]){
            r++;
            cost+=rowCosts[r];
        }
        while(r>homePos[0]){
            r--;
            cost+=rowCosts[r];
        }
        while(c>homePos[1]){
            c--;
            cost+=colCosts[c];
        }
        while(c<homePos[1]){
            c++;
            cost+=colCosts[c];
        }
        return cost;
    }
}