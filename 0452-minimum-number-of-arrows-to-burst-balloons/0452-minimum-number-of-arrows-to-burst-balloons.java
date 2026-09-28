class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(x,y)->Integer.compare(x[0],y[0]));

        int i=1;
        int end=points[0][1];
        int shots=1;

        while(i<points.length){
            if(end<points[i][0]){
                end=points[i][1];
                shots++;
            }
            else end=Math.min(end,points[i][1]);
            i++;
        }
        return shots;
    }
}