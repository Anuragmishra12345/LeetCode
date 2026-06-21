class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count=0;
        int coin=0;
        for(int cost:costs){
            coin+=cost;
            if(coin<=coins) count++;
            else break;
        }
        return count;
    }
}