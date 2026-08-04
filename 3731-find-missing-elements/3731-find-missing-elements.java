class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        boolean[] arr=new boolean[100+1];

        for(int i=0;i<nums.length;i++){
            int num=nums[i];

            min=Math.min(min,num);
            max=Math.max(max,num);

            arr[num]=true;
        }

        List<Integer> result=new ArrayList<>();

        for(int i=min+1;i<max;i++){
            if(!arr[i]) result.add(i);
        }
        return result;
    }
}