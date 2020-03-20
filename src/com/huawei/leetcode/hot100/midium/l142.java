package com.huawei.leetcode.hot100.midium;

import java.util.List;

public class l142 {
    class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
   }

    public ListNode detectCycle(ListNode head) {
        ListNode meetNode = meet(head);
        if (meetNode == null) {
            return null;
        }
        int num = 1;
        ListNode p = meetNode;
        while (p.next != meetNode) {
            p = p.next;
            num++;
        }
        p = head;
        for (int i = 0; i < num; i++) {
            p = p.next;
        }
        ListNode p2 = head;
        while (p != p2) {
            p = p.next;
            p2 = p2.next;
        }
        return p;
    }

    private ListNode meet(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = slow.next;
        while (slow != null && fast != null) {
            if (slow == fast) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return null;
    }
}
