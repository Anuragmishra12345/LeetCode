class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int max=0;
        Set<Integer> set=new HashSet<>();
        for(int num:arr1){
            while(num>0){
                set.add(num);
                num/=10;
            }
        }

        for(int num:arr2){
            while(num>0){
                if(set.contains(num)){
                    int len=String.valueOf(num).length();
                    max=Math.max(len,max);
                    break;
                }
                num/=10;
            }
        }
        return max;
    }
}