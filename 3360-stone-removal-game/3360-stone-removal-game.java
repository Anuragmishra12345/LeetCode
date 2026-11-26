class Solution {
    public boolean canAliceWin(int n) {
        return func(n,10,true);
    }

    boolean func(int n,int needed, boolean player){
        if(needed<=n){
            return func(n-needed,needed-1,!player);
        }
        else{
            if(player) return false;
            else return true;
        }
    }
}