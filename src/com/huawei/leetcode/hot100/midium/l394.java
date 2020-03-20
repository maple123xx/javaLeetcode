package com.huawei.leetcode.hot100.midium;

import java.util.SplittableRandom;
import java.util.Stack;

public class l394 {
    private int index = 0;
    public String decodeString(String s) {
        return decode(s);
    }

    private String decode(String s) {
        int repeat = 0;
        String res = "";
        while (index < s.length()) {
            char c = s.charAt(index);

            if (c == ']') {
                index++;
                return res;
            } else if (c >= '0' && c <= '9') {
                repeat = 10 * repeat + (c - '0');
                index++;
            } else if (c == '[') {
                index++;
                String sub = decode(s);
                for (int i = 0; i < repeat; i++) {
                    res += sub;
                }
                repeat = 0;
            } else {
                res += c;
                index++;
            }
        }
        return res;
    }
}
