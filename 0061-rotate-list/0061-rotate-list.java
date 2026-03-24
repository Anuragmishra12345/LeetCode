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
    public ListNode rotateRight(ListNode head, int k) {
        if(k<=0 || head==null || head.next==null) return head;

        int length=1;
        ListNode last=head;
        while(last.next!=null){
            length++;
            last=last.next;
        }
        k=k%length;

        last.next=head;

        ListNode newTail=head;
        for(int i=0;i<length-k-1;i++){
            newTail=newTail.next;
        }
        ListNode NewHead=newTail.next;
        newTail.next=null;
        return NewHead;

    }
}