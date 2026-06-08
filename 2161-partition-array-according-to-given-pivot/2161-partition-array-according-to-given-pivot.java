class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> before=new ArrayList<>();
        ArrayList<Integer> after=new ArrayList<>();

        int pCount=0;
        for(int n:nums){
            if(n<pivot) before.add(n);
            else if(n>pivot) after.add(n);
            else pCount++;
        }

        int[] result=new int[nums.length];
        int i=0;
        for(int n:before){
            result[i]=n;
            i++;
        }
        while(pCount>0){
            result[i]=pivot;
            pCount--;
            i++;
        }
        for(int n:after){
            result[i]=n;
            i++;
        }
        return result;
    }
}