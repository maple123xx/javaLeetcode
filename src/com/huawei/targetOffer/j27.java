package com.huawei.targetOffer;


import java.util.*;
public class j27 {

    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null) {
            return 0;
        }
        int count = 1;
        int res = array[0];
        for (int i = 1; i< array.length; i++) {
            if (array[i] == res) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                res = array[i];
                count++;
            }
        }
        count = 0;
        for (int i = 0; i<array.length; i++) {
            if (array[i] == res) {
                count++;
            }
        }
        return (count > array.length / 2) ? res : 0;
    }

    // j28
    // 最小的k个数
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        //大根堆，比堆顶小，就把堆顶删掉，再插进来
        ArrayList<Integer> res = new ArrayList<Integer>();
        int len = input.length;
        if (k > len || k == 0) {
            return res;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < len; i++) {
            if (maxHeap.size() < k) {
                maxHeap.offer(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }
        for (Integer i : maxHeap) {
            res.add(i);
        }
        return res;
    }

    //j29 连续子数组的最大和
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null) {
            return 0;
        }
        int curSum = 0;
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            //意思是如果curSum为负了，我们就不要它了，从当前元素重新开始
            curSum = Math.max(curSum + array[i], array[i]);
            if (sum < curSum) {
                sum = curSum;
            }
        }
        return sum;
    }

    //j30


    //j31
    public String PrintMinNumber(int [] numbers) {
        String res = "";
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : numbers) {
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer str1, Integer str2) {
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);
            }
        });
        for (int i : list) {
            res += i;
        }
        return res;
    }

    //j32
    public int GetUglyNumber_Solution(int index) {
        if (index < 7) {
            return index;
        }
        ArrayList<Integer> res = new ArrayList<Integer>(index);
        res.add(1);
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        for (int i = 1; i < index; i++) {
            int m2 = res.get(t2) * 2;
            int m3 = res.get(t3) * 3;
            int m5 = res.get(t5) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            res.add(min);
            if (min == m2) t2++;
            if (min == m3) t3++;
            if (min == m5) t5++;
        }
        return res.get(res.size() - 1);
    }

    //j33
    public int FirstNotRepeatingChar(String str) {
        LinkedHashMap<Character , Integer> m = new LinkedHashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            if (m.containsKey(str.charAt(i))) {
                int time = m.get(str.charAt(i));
                m.put(str.charAt(i), ++time);
            } else {
                m.put(str.charAt(i), 1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (m.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    //j34

    //j35
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int len1 = 0;
        int len2 = 0;
        int diff;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != null) {
            len1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            len2++;
            p2 = p2.next;
        }
        p1 = pHead1;
        p2 = pHead2;
        if (len1 > len2) {
            diff = len1 - len2;
            while (diff > 0) {
                p1 = p1.next;
                diff--;
            }
        } else {
            diff = len2 - len1;
            while (diff > 0) {
                p2 = p2.next;
                diff--;
            }
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    //j36

    //37
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int level = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            level++;
            while (len-- != 0) {
                TreeNode tmp = q.poll();
                if (tmp.left != null) {
                    q.offer(tmp.left);
                }
                if (tmp.right != null) {
                    q.offer(tmp.right);
                }
            }
        }
        return level;
    }

    //j39

    private boolean isBalanced = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        getDepth(root);
        return isBalanced;

    }
    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return 1 + Math.max(left, right);
    }

    //j40
    //1 1 2 2 3 5 8 8
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array.length < 2) return;
        int tmp = array[0];
        for (int i = 1; i < array.length; i++) {
            tmp ^= array[i];
        }
        int index = 0;
        while ((tmp & 1) == 0) {
            tmp >>= 1;
            index++;
        }
        for (int i = 0; i < array.length; i++) {
            if (BitOf1(array[i], index)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }
    private boolean BitOf1(int num, int index) {
        num >>= index;
        return (num & 1) == 1;
    }

    //j41
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        int small = 1;
        int big = 2;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int cur = small + big;
        int mid = (1 + sum) / 2;
        while (small < mid) {
            if (cur == sum) {
                ArrayList<Integer> data = new ArrayList<Integer>();
                for (int i = small; i <= big; i++) {
                    data.add(i);
                }
                res.add(data);
            }
            while (cur > sum && small < mid) {
                cur -= small;
                small++;
                if (cur == sum) {
                    ArrayList<Integer> data = new ArrayList<Integer>();
                    for (int i = small; i <= big; i++) {
                        data.add(i);
                    }
                    res.add(data);
                }
            }
            big++;
            cur += big;
        }
        return res;
    }

    //j42
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            if ((array[start] + array[end]) == sum) {
                res.add(array[start]);
                res.add(array[end]);
                break;
            } else if ((array[start] + array[end]) < sum) {
                start++;
            } else {
                end--;
            }
        }
        return res;
    }

    //j43
    public String LeftRotateString(String str,int n) {
        if (str.length() < n) {
            return "";
        }
        //String s = "";
        char[] array = str.toCharArray();
        rotate(array, 0, n-1);
        rotate(array, n, array.length - 1);
        rotate(array, 0, array.length - 1);
//        for (char c : array) {
//            s += c;
//        }
//        return s;
        return new String(array);
    }
    private void rotate(char[] array, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }

    //j44
    public String ReverseSentence(String str) {
        if (str == null || str.trim().equals("")) {
            return str;
        }
        String[] s = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = s.length - 1; i >= 0; i--) {
            sb.append(s[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    //j45
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        bucketSort(numbers);
        int zero = 0;
        int gap = 0;
        for (int number : numbers) {
            if (number == 0) {
                zero++;
            }
        }
        int small = zero;
        int big = small + 1;
        while (big < numbers.length) {
            if (numbers[small] == numbers[big]) {
                return false;
            }
            gap += numbers[big] - numbers[small] - 1;
            small = big;
            big++;
        }
        return zero >= gap;
    }
    private void bucketSort(int [] num) {
        int[] arr =new int[14];
        for (int value : num) {
            arr[value]++;
        }
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i]-- != 0) {
                num[index++] = i;
            }
        }

    }

    public static void main(String[] args) {
        j27 sol = new j27();
        int[] arr = {0,3,2,6,4};
        System.out.println(sol.isContinuous(arr));
    }
}
