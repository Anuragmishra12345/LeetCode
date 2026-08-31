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
        int[] result={-1,-1};
        if(head==null || head.next==null || head.next.next==null) return result;
        Integer prev=null;
        int index=0;

        result[0]=Integer.MAX_VALUE;

        int firstIndex=-1;
        int lastIndex=-1;

        while(head!=null){

            if(prev==null) prev=head.val;
            else if(head.next!=null && ((head.val>prev && head.val>head.next.val) || (head.val<prev && head.val<head.next.val))){
                if(firstIndex!=-1){
                        result[1]=Math.max(result[1],index-firstIndex);
                    }
                    else firstIndex=index;

                    if(lastIndex!=-1) {
                        result[0]=Math.min(result[0],index-lastIndex);
                    }

                    lastIndex=index;
            }
            prev=head.val;
            index++;
            head=head.next;
        }
        if(result[0]==Integer.MAX_VALUE) result[0]=-1;
        return result;
    }
}