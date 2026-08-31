/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) return new int[]{-1,-1};
        Integer prev=null;
        int index=0;
        List<Integer> list=new ArrayList<>();

        while(head!=null){
            if(prev==null) prev=head.val;
            else if(head.next!=null){
                if(head.val>prev && head.val>head.next.val) list.add(index);
                if(head.val<prev && head.val<head.next.val) list.add(index);
                prev=head.val;
            }
            index++;
            head=head.next;
        }
        int[] result={-1,-1};
        if(list.size()<2) return result;
        result[0]=Integer.MAX_VALUE;
        result[1]=list.get(list.size()-1)-list.get(0);
        for(int i=1;i<list.size();i++){
            result[0]=Math.min(result[0],list.get(i)-list.get(i-1));
        }
        return result;
    }
}