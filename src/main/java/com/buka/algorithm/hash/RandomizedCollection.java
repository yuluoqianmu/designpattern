package com.buka.algorithm.hash;

import java.util.*;

/**
 * 设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。

 注意: 允许出现重复元素。

 insert(val)：向集合中插入元素 val。
 remove(val)：当 val 存在时，从集合中移除一个 val。
 getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 */
public class RandomizedCollection {

    List<Integer> list;
    Random r;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list=new ArrayList<Integer>();
        r=new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        Integer v=val;
        boolean flag=list.contains(v);
        list.add(v);
        return !flag;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        Integer v=val;
        boolean flag=list.contains(v);
        list.remove(v);
        return flag;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(r.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

