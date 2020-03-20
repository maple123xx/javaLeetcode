package com.huawei.leetcode.hot100.midium;

import java.util.Arrays;
import java.util.Comparator;

public class l215 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length - k;
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int index = partition(nums, i, j);
            if (index == n) {
                return nums[index];
            } else if (index > n) {
                j = index - 1;
            } else {
                i = index + 1;
            }
        }
        return -1;
    }

    private int partition(int[] nums, int i, int j) {
        int tmp = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= tmp) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= tmp) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = tmp;
        return i;
    }
}
