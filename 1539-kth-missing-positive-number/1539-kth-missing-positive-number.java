class Solution {
    public int findKthPositive(int[] arr, int k) {
        List<Integer> result=new ArrayList<>();
        int i=1;
        int index=0;
        while(result.size()<k){
            if(index<arr.length && i==arr[index]){
                i++;
                index++;
            }
            else {
                result.add(i);
                i++;
            }
        }
        return result.get(result.size()-1);
    }
}