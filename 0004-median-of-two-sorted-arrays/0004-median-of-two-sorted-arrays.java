class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] num=merge(nums1,nums2);
        int len=num.length;
        if(len%2==0){
            return (double)(num[len/2-1]+num[len/2])/2;
        }
        else return (double)num[len/2];
    }
    int[] merge(int[] nums1, int[] nums2){
        int[] merged=new int[nums1.length+nums2.length];
        int i=0;int j=0;int k=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                merged[k]=nums1[i];
                i++;
            }
            else{
                merged[k]=nums2[j];
                j++;
            }
            k++;
        }
        while(i<nums1.length){
            merged[k]=nums1[i];
            i++;
            k++;
        }
        while(j<nums2.length){
            merged[k]=nums2[j];
            j++;
            k++;
        }
        return merged;
    }
}