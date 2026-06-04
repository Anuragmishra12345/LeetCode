class Solution {
    public int totalWaviness(int num1, int num2) {
        int count=0;
        for(int i=num1; i<=num2;i++){
            List<Integer> list=new ArrayList<>();
            int num=i;
            while(num>0){
                list.add(num%10);
                num/=10;
            }
            if(list.size()<=2) continue;
            for(int j=1;j<list.size()-1;j++){
                if((list.get(j-1)<list.get(j) && list.get(j)>list.get(j+1)) || (list.get(j-1)>list.get(j) && list.get(j)<list.get(j+1)) ) count++;
            }
        }
        return count;
    }
}