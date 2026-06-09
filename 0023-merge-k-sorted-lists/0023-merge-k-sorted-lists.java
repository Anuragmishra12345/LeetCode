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
    // public ListNode mergeKLists(ListNode[] lists) {
    //     if(lists.length==0 ||lists==null) return null;
    //     return merge(lists,0,lists.length-1);
    // }
    // ListNode merge(ListNode[] lists,int left, int right){
    //     if(left==right) return lists[left];
    //     int mid=left+(right-left)/2;

    //     ListNode l1=merge(lists,left,mid);
    //     ListNode l2=merge(lists,mid+1,right);

    //     return mergeSort(l1,l2);
    // }
    // ListNode mergeSort(ListNode A, ListNode B){
    //     if(A==null) return B;
    //     if(B==null) return A;
    //     if(A.val<=B.val){
    //         A.next=mergeSort(A.next,B);
    //         return A;
    //     }
    //     else{
    //         B.next=mergeSort(A,B.next);
    //         return B;
    //     }
    // }



    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->(a.val-b.val));

        for(ListNode list:lists){
           if(list!=null) pq.offer(list);
        }

        ListNode dummy=new ListNode(0);
        ListNode runner =dummy;
        while(!pq.isEmpty()){
            ListNode curr=pq.poll();
            runner.next=curr;
            runner=runner.next;

            if(curr.next!=null) pq.offer(curr.next);
        }

        return dummy.next;
    }
}