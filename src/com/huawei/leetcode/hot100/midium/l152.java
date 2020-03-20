package com.huawei.leetcode.hot100.midium;

public class l152 {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int pos = nums[0];
        int neg = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = pos; //暂存
            pos = Math.max(nums[i], Math.max(nums[i] * pos, nums[i] * neg));
            neg = Math.min(nums[i], Math.min(nums[i] * tmp, nums[i] * neg));
            res = Math.max(res, pos);
        }
        return res;
    }
}
