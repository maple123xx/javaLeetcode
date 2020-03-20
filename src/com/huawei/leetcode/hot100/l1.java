package com.huawei.leetcode.hot100;

import javax.jnlp.ClipboardService;
import java.util.*;

public class l1 {
    //l1 两数之和
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (m.containsKey(tmp)) {
                res[0] = i;
                res[1] = m.get(tmp);
                return res;
            }
            m.put(nums[i], i);
        }
        return res;
    }

    //l3 无重复字符的最长子串
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();
        char[] ch = s.toCharArray();
        int l = 0;
        int r = 0;
        int res = 0;
        while (r < ch.length) {
            char c = ch[r];
            if (!m.containsKey(c)) {
                m.put(c, 1);
            } else {
                m.put(c, m.get(c) + 1);
            }
            r++;
            while (m.get(c) > 1) {
                m.put(ch[l], m.get(ch[l]) - 1);
                l++;
            }
            res = Math.max(res, r - l);
        }
        return res;
    }

    //l20 有效的括号
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> ss = new Stack<Character>();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(' || ch[i] == '[' || ch[i] == '{') {
                ss.push(ch[i]);
            } else {
                if (ss.empty()) {
                    return false;
                } else if (ch[i] == ')') {
                    if (ss.peek() != '(') {
                        return false;
                    }
                    ss.pop();
                } else if (ch[i] == ']') {
                    if (ss.peek() != '[') {
                        return false;
                    }
                    ss.pop();
                } else {
                    if (ss.peek() != '{') {
                        return false;
                    }
                    ss.pop();
                }
            }
        }
        return ss.empty();
    }

    //l21 合并两个有序链表
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode r = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                r.next = l1;
                l1 = l1.next;
            } else {
                r.next = l2;
                l2 = l2.next;
            }
            r = r.next;
        }
        if (l1 != null) {
            r.next = l1;
        }
        if (l2 != null) {
            r.next = l2;
        }
        return dummy.next;
    }

    //l53 最大子序和
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        int curSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(curSum + nums[i], nums[i]); //一旦curSum<0了，就不要前面的了
            res = Math.max(res, curSum);
        }
        return res;
    }

    //l70 爬楼梯
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    //l101 对称二叉树
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }
    public boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }

    //l104 二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }


    public static void main(String[] args) {
        l1 sol = new l1();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(sol.maxSubArray(nums));
    }
}
