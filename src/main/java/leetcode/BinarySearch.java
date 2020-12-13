package leetcode;

/**
 * @author
 * @version 1.0
 * @date 2020/12/13 下午1:59
 * @description     704、二分查找
 **/

public class BinarySearch {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            //两边界都是闭区间
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                //收缩左边界
                left=mid+1;
            }else if(nums[mid]>target){
                //收缩右边界
                right=mid-1;
            }
        }
        return -1;
    }
}
