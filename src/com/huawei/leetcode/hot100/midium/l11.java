package com.huawei.leetcode.hot100.midium;

public class l11 {
    public int maxArea(int[] height) {
        if (height.length <= 1) {
            return -1;
        }
        int res = 0;
        for (int i = 0, j = height.length - 1; i < j ;) {
            int minHeight = Math.min(height[i], height[j]);
            res = Math.max(res, minHeight * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
