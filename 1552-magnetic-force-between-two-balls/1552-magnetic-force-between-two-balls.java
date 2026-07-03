class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low=1;
        int high=position[position.length-1]-position[0];
        int ans=1;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(countBalls(position,mid)>=m){
                low=mid+1;
                ans=mid;
            }
            else high=mid-1;
        }
        return ans;
    }
    int countBalls(int[] position,int d){
        int balls=1;
        int last=position[0];

        for(int i=1;i<position.length;i++){
            if(position[i]-last>=d){
                balls++;
                last=position[i];
            }
        }
        return balls;
    }
}