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
    // public ListNode reverseKGroup(ListNode head, int k) {
    //     if(head==null || k<=1) return head;

    //     ListNode prev=null;
    //     ListNode current=head;
    //     while(true){
    //         ListNode check=current;
    //         for(int i=0;i<k;i++){
    //             if(check==null) return head;
    //             check=check.next;
    //         }
    //         ListNode last=prev;
    //         ListNode newEnd=current;

    //         ListNode next=current.next; 
    //         for(int i=0;i<k && current!=null;i++){
    //             current.next=prev;
    //             prev=current;
    //             current=next;
    //             if(next!=null){
    //                 next=next.next;
    //             }
    //         }

    //         if(last!=null){
    //             last.next=prev;
    //         }else {
    //             head=prev;
    //         }

    //         newEnd.next=current;
    //         if(current==null){
    //             break;
    //         }
    //         prev=newEnd;
    //     }
    //     return head;
    // } 

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k<=1) return head;

        ListNode prev=null;
        ListNode curr=head;

        while(true){
            ListNode check=curr;
            for(int i=0;i<k;i++){
                if(check==null) return head;
                check=check.next;
            }

            ListNode last=prev;
            ListNode newEnd=curr;

            ListNode prevNode = null;
            for(int i=0;i<k && curr!=null;i++){
                ListNode next=curr.next;
                curr.next=prevNode;
                prevNode=curr;
                curr=next;
            }

            if(last!=null) last.next=prevNode;
            else head=prevNode;

            newEnd.next=curr;
            prev=newEnd;
        }
    }


}