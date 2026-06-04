class Solution {
    public int totalWaviness(int num1, int num2) {
        int count=0;
        for(int i=num1; i<=num2;i++){
            String s = String.valueOf(i);

            for(int j=1;j<s.length()-1;j++){
                char a=s.charAt(j-1);
                char b=s.charAt(j);
                char c=s.charAt(j+1);

                if((a<b && b>c) || (a>b && b<c))
                    count++;
            }
        }
        return count;
    }
}