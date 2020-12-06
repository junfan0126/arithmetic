package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author
 * @version 1.0
 * @date 2020/12/6 下午4:17
 * @description     46、全排列(不包含重复数字)
 *                  回溯
 **/

public class Permute {
    //记录选择过的路径
    LinkedList<Integer> track=new LinkedList<>();
    //结果列表
    List<List<Integer>> res=new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums,track);
        return res;
    }

    public void backtrack(int[] nums, LinkedList<Integer> track){
        //结束条件，每次执行到叶子结点
        if(track.size()==nums.length){
            res.add(new LinkedList(track));
            return;
        }
        for(int i=0;i<nums.length;i++){
            //判断是否有已选择过的结点
            if(track.contains(nums[i])){
                continue;
            }
            //做选择
            track.add(nums[i]);

            backtrack(nums,track);
            //撤销选择
            track.removeLast();
        }

    }

}
