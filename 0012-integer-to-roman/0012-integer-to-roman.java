class Solution {
    public String intToRoman(int num) {
        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbols={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder result=new StringBuilder();
        for(int i=0;i<values.length;i++){
            while(num>=values[i]){
                result.append(symbols[i]);
                num-=values[i];
            }
        }
        return result.toString();
    }
}





// class Solution {
//     public String intToRoman(int num) {
//         int unit=num%10;
//         num/=10;
//         int tenth=num%10;
//         num/=10;
//         int hundred=num%10;
//         num/=10;
//         int thousand=num%10;
        
//         StringBuilder result=new StringBuilder();

//         if(thousand!=0){
//             for(int i=0;i<thousand;i++){
//                 result.append("M");
//             }
//         }

//         if(hundred!=0){
//             if(hundred==4) result.append("CD");
//             else if(hundred==9) result.append("CM");
//             else if(hundred==5) result.append("D");
//             else if(hundred<4){
//                 for(int i=0;i<hundred;i++){
//                     result.append("C");
//                 }
//             }
//             else {
//                 result.append("D");
//                 for(int i=0;i<hundred-5;i++){
//                     result.append("C");
//                 }
//             }
//         }

//         if(tenth!=0){
//             if(tenth==4) result.append("XL");
//             else if(tenth==9) result.append("XC");
//             else if(tenth==5) result.append("L");
//             else if(tenth<4) {
//                 for(int i=0;i<tenth;i++){
//                     result.append("X");
//                 }
//             }
//             else {
//                 result.append("L");
//                 for(int i=0;i<tenth-5;i++){
//                     result.append("X");
//                 }
//             }
//         }

//         if(unit!=0){
//             if(unit==4) result.append("IV");
//             else if(unit==9) result.append("IX");
//             else if(unit==5) result.append("V");
//             else if(unit<4){
//                 for(int i=0;i<unit;i++){
//                     result.append("I");
//                 }
//             }
//             else {
//                 result.append("V");
//                 for(int i=0;i<unit-5;i++){
//                     result.append("I");
//                 }
//             }
//         }

//         return result.toString();
//     }
// }