package leetcode;

import java.util.Arrays;

/**
 * @author
 * @version 1.0
 * @date 2020/11/12 上午10:24
 * @description     leetcode300.最长上升子序列
 **/

public class LengthOfLIS {
    //递归+记忆化
    public int lengthOfLIS(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int[][] cache = new int[nums.length + 1][nums.length];
        for (int[] arr : cache) {
            Arrays.fill(arr, -1);
        }
        return dfs(cache, nums, -1, 0);
    }

    public int dfs(int[][] cache, int[] nums, int pre, int cur) {
        if (cur == nums.length) {
            return 0;
        }
        int a = 0;
        if (cache[pre + 1][cur] > -1) {
            return cache[pre + 1][cur];
        }
        if (pre < 0 || nums[cur] > nums[pre]) {
            a = dfs(cache, nums, cur, cur + 1) + 1;
        }
        int b = dfs(cache, nums, pre, cur + 1);
        cache[pre + 1][cur] = Math.max(a, b);
        return cache[pre + 1][cur];
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        System.out.println(lengthOfLIS.lengthOfLIS(nums));
    }
}
