package leetcode;

import java.util.*;

/**
 * @author
 * @version 1.0
 * @date 2020/11/22 下午3:32
 * @description     347、前K个高频元素
 **/

public class TopK {
    public static void main(String[] args) {
        int []nums={1,1,1,2,2,3,3};
        TopK topK=new TopK();
        topK.topKFrequent(nums,2);
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            //重写compare为比较value
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });

        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                //在上面改写了compare方法后，add方法在添加时会将value大的放在下面
                //符合小根堆
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }

        // 取出最小堆中的元素
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }
        return res;
    }
}



