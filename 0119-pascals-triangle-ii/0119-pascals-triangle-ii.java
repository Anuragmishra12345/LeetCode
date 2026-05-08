class Solution {
    public List<Integer> getRow(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        result.add(Arrays.asList(1));
        if(numRows==0) {
            return result.get(0);
        }
        result.add(Arrays.asList(1,1));
        if(numRows==1){
            return result.get(1);
        }
        for(int i=2;i<=numRows;i++){
            List<Integer> list=new ArrayList<>();
            list.add(1);
            for(int j=0;j<=i-2;j++){
                int a=result.get(i-1).get(j);
                int b=result.get(i-1).get(j+1);
                list.add(a+b);
            }
            list.add(1);
            result.add(list);
        }

        return result.get(numRows);
    }
}