package com.huawei.leetcode.hot100.midium;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class l146 {
    private int cap;
    private LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

    public l146(int capacity) {
        cap = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int value = map.get(key);
            map.remove(key);
            map.put(key, value);//保证每次查询后，都在末尾
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        } else if (map.size() == cap) {
            Iterator<HashMap.Entry<Integer, Integer>> it = map.entrySet().iterator();
            it.next();  //删除第一个元素
            it.remove();
        }
        map.put(key, value);
    }
}
