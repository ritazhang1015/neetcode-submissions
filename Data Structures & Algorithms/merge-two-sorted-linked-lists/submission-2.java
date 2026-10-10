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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        ListNode cur = list1;
        while(cur != null){
            minHeap.add(cur.val);
            cur = cur.next;
        }

        cur = list2;
        while(cur != null){
            minHeap.add(cur.val);
            cur = cur.next;
        }

        ListNode head = new ListNode(minHeap.poll());
        cur = head;
        while(minHeap.size() > 0){
            cur.next = new ListNode(minHeap.poll());
            cur = cur.next;
        }
        return head;
    }
}