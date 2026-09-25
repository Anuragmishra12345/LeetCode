class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,0,new ArrayList<>());
        return result;
    }
    void backtrack(int[] nums, int i, List<Integer> curr){
        result.add(new ArrayList<>(curr));

        for(int index=i;index<nums.length;index++){
            curr.add(nums[index]);
            backtrack(nums,index+1,curr);
            curr.remove(curr.size()-1);
        }
    }
}