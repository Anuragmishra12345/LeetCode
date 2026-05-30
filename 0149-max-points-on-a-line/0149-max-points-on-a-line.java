class Solution {
    public int maxPoints(int[][] points) {
        int n=points.length;
        if(n<=2) return n;
        int max=0;

        for(int i=0;i<n;i++){
            int maxFreq=0;
            Map<String, Integer> map=new HashMap<>();

            for(int j=i+1;j<n;j++){
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                int g=gcd(dx,dy);

                dx/=g;
                dy/=g;

                if(dx<0){
                    dx = -dx;
                    dy = -dy;
                }

                 // handle vertical lines
                if(dx == 0) {
                    dy = 1;
                }

                // handle horizontal lines
                if(dy == 0) {
                    dx = 1;
                }

                String key=dy+"#"+dx;

                int freq=map.getOrDefault(key,0)+1;

                map.put(key,freq);

                maxFreq=Math.max(freq,maxFreq);
            }
            max=Math.max(max,maxFreq+1);
        } 
        return max;   
    }

    private int gcd(int a, int b){
        a=Math.abs(a);
        b=Math.abs(b);

        while(b!=0){
            int temp=a%b;
            a=b;
            b=temp;
        }

        return a;
    }
}