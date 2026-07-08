class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n=s.length();
        int MOD=1000000007;

        long num = 0;
        int sum = 0;

        ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> prefixSum=new ArrayList<>();
        ArrayList<Long> prefixNum=new ArrayList<>();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch!='0'){
                int digit=ch-'0';
                pos.add(i);

                sum+=digit;
                prefixSum.add(sum);

                num=(num*10+digit)%MOD;
                prefixNum.add(num);
            }
        }

        int m=pos.size();
        long[] pow=new long[m+1];
        pow[0]=1;
        for(int i=1;i<=m;i++){
            pow[i]=(pow[i-1]*10)%MOD;
        }

        int[] result=new int[queries.length];
        for(int q=0;q<queries.length;q++){
            int l=queries[q][0];
            int r=queries[q][1];

            int left=lowerBound(pos,l);
            int right=upperBound(pos,r)-1;

            if(left>right) {
                result[q]=0;
                continue;
            }
            int digitSum=prefixSum.get(right);
            if(left>0) digitSum-=prefixSum.get(left-1);

            long number=prefixNum.get(right);
            if(left>0){
                number=(number-(prefixNum.get(left-1)*pow[right-left+1])%MOD+MOD)%MOD;
            }
            result[q] = (int)((number * digitSum) % MOD);
        }
        
        return result;
    }
    int lowerBound(ArrayList<Integer> list, int target) {
        int l = 0, r = list.size();

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (list.get(mid) >= target)
                r = mid;
            else
                l = mid + 1;
        }

        return l;
    }
    int upperBound(ArrayList<Integer> list, int target) {
        int l = 0, r = list.size();

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (list.get(mid) > target)
                r = mid;
            else
                l = mid + 1;
        }

        return l;
    }
}