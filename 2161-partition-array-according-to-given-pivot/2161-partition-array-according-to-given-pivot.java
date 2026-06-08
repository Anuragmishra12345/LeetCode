class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int less=0;
        int equal=0;

        for(int n:nums){
            if(n<pivot) less++;
            else if(n==pivot) equal++;
        }

        int[] result=new int[nums.length];

        int i=0;
        int j=less;
        int k=less+equal;

        for(int n:nums){
            if(n<pivot) result[i++]=n;
            else if(n==pivot) result[j++]=n;
            else result[k++]=n;
        }

        
        return result;
    }
}