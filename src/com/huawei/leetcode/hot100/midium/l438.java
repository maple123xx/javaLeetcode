package com.huawei.leetcode.hot100.midium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class l438 {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> pmap = new HashMap<>();
        for (char ch: p.toCharArray()) {
            pmap.put(ch, pmap.getOrDefault(ch, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        int count = 0;
        int len = p.length();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);
            if (pmap.containsKey(ch) && smap.get(ch) <= pmap.get(ch)) {
                count++;
            }
            if (count == len) {
                res.add(left);
            }
            if (right - left + 1 >= len) {
                char leftCh = s.charAt(left);
                if (pmap.containsKey(leftCh) && smap.get(leftCh) <= pmap.get(leftCh)) {
                    count--;
                }
                smap.put(leftCh, smap.getOrDefault(leftCh, 1) - 1);
                left++;
            }
            right++;
        }
        return res;
    }
}
