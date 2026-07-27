class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> set1=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        for(int num : nums1) set1.add(num);

        for(int num:nums2) {
            if(set1.contains(num)) {
                list.add(num);
                set1.remove(Integer.valueOf(num));
            }
        }

        int[] ans=new int[list.size()];
        int index=0;
        for(int num:list) ans[index++]=num;
        return ans;
    }
}