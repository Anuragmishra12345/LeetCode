class Solution {
    public int findMinMoves(int[] machines) {
        int total=0;
        int n=machines.length;
        for(int m:machines) total+=m;

        if(total%n!=0) return -1;

        int required=total/n;

        int running=0;
        int moves=0;
        for(int i=0;i<n;i++){
            int surplus=machines[i]-required;
            running +=surplus;
            System.out.println(running);
            if(surplus>moves) moves=surplus;
            moves=Math.max(moves,Math.abs(running));
        }
        return moves;
    }
}