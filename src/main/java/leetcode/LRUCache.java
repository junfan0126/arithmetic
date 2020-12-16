package leetcode;

import java.util.LinkedHashMap;

/**
 * @author
 * @version 1.0
 * @date 2020/12/16 下午5:59
 * @description     146、LRU缓存机制
 **/

public class LRUCache {
    int cap;
    LinkedHashMap<Integer,Integer> cache=new LinkedHashMap<>();
    //初始化
    public LRUCache(int capacity) {
        this.cap=capacity;
    }
    public int get(int key){
        if(!cache.containsKey(key)){
            return -1;
        }
        //更新key，将key变为最近使用
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key,int val){
        if(cache.containsKey(key)){
            //修改key的值
            cache.put(key,val);
            makeRecently(key);
            return;
        }
        if(cache.size()>=this.cap){
            //链表头部就是最久未使用的key
            int oldestKey=cache.keySet().iterator().next();
            //删除链表头部
            cache.remove(oldestKey);
        }
        cache.put(key,val);
    }

    private void makeRecently(int key){
        int val=cache.get(key);
        //删除key
        cache.remove(key);
        //将key重新插入到队尾
        cache.put(key,val);
    }

}
