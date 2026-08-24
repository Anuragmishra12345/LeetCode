class Solution {
    public int maximumSwap(int num) {
        char[] digits=Integer.toString(num).toCharArray();
        int n=digits.length;

        int[] lastIndex=new int[10];
        for(int i=0;i<n;i++){
            int index=digits[i]-'0';
            lastIndex[index]=i;
        }

        for(int i=0;i<n;i++){
            int currDigit=digits[i]-'0';

            for(int d=9;d>currDigit;d--){
                if(lastIndex[d]>i){
                    char temp=digits[i];
                    digits[i]=digits[lastIndex[d]];
                    digits[lastIndex[d]]=temp;

                    return Integer.parseInt(new String(digits));
                }
            }
        }
        return num;
    }




    // public int maximumSwap(int num) {
    //     StringBuilder nums=new StringBuilder(Integer.toString(num));
    //     int n=nums.length();
    //     for(int i=0;i<n;i++){
    //         int min=nums.charAt(i)-'0';
    //         int k=-1;
    //         int max=min;
    //         for(int j=i+1;j<n;j++){
    //             int cn=nums.charAt(j)-'0';
    //             if(max<=cn){
    //                 max=cn;
    //                 k=j;
    //             }
    //         }
    //         if(k!=-1 && max>min){
    //             char temp = nums.charAt(i);
    //             nums.setCharAt(i, nums.charAt(k));
    //             nums.setCharAt(k, temp);
    //             break;
    //         }
    //     }
    //     int ans=0;
    //     for(int i=0;i<n;i++){
    //         ans=ans*10+nums.charAt(i)-'0';
    //     }
    //     return ans;
    // }
}