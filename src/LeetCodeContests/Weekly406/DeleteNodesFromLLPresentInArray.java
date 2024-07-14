package LeetCodeContests.Weekly406;

import java.util.HashSet;
import java.util.Set;

public class DeleteNodesFromLLPresentInArray {
    public static void main(String[] args) {
int[] nums = {1};
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        System.out.println(modifiedList(nums,head));
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums)set.add(num);
        ListNode n = head;
        ListNode c = head;
        ListNode newHead = null;

        while(n != null){
            if(set.contains(n.val)){
                while(n.next != null && set.contains(n.val))n = n.next;
            }
            if(newHead == null)newHead = n;
            if(c != n){
                c.next = n;
                while(c.next != null && c.next != n)c = c.next;
                if(set.contains(c.val)){
                    c.next = null;
                    c = n;
                }

            }
            n = n.next;

        }
        return newHead;
    }

    public static ListNode modifiedList1(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums)set.add(num);
        ListNode c = head;
        ListNode h = null;
        ListNode newHead = null;

        while(c != null) {
            if(!set.contains(c)){
                ListNode node = new ListNode(c.val);
                if(newHead == null){
                    newHead = node;
                    h = newHead;
                }else{
                    h.next = c;
                    h = c;
                }

            }else c = c.next;
        }
        return newHead;

    }
}
