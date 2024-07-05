package DailyChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinAndMaxNumOfNodesBtwCriticalPoints {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        MinAndMaxNumOfNodesBtwCriticalPoints obj = new MinAndMaxNumOfNodesBtwCriticalPoints();
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next.next = new ListNode(7);
        System.out.println(Arrays.toString(nodesBetweenCriticalPoints(head)));
        System.out.println(Arrays.toString(nodesBetweenCriticalPoints1(head)));

    }
    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head, cur = head.next, forward = head.next.next;
        int counter = 1;
        List<Integer> list = new ArrayList<>();
        while(forward != null){
            if((prev.val > cur.val && forward.val > cur.val)|| (prev.val < cur.val && forward.val < cur.val)){
                list.add(counter);
            }
            prev = cur;
            cur = forward;
            forward = forward.next;
            counter++;
        }
        if(list.size() < 2)return new int[]{-1,-1};
        if(list.size() == 2)return new int[]{list.get(1) - list.get(0),list.get(1) - list.get(0)};
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < list.size() - 1; i++) {
            min = Math.min(min, list.get(i + 1) - list.get(i));
        }
        int max = list.get(list.size() - 1) - list.get(0);
        return new int[]{min,max};
    }

    public static int[] nodesBetweenCriticalPoints1(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        ListNode prev = head;
        ListNode cur = head.next;
        ListNode forward = head.next.next;
        int counter = 1;
        int firstCp = -1;
        int prevCp = -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (forward != null) {
            if ((prev.val > cur.val && forward.val > cur.val) || (prev.val < cur.val && forward.val < cur.val)) {
                if (firstCp == -1) {
                    firstCp = counter;
                } else {
                    min = Math.min(min, counter - prevCp);
                }
                prevCp = counter;
            }
            prev = cur;
            cur = forward;
            forward = forward.next;
            counter++;
        }

        if (firstCp == -1 || prevCp == firstCp) {// No critical points or only one critical point
            return new int[]{-1, -1};
        }

        max = prevCp - firstCp;
        return new int[]{min, max};
    }
}
