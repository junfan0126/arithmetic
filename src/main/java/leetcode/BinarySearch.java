package leetcode;

/**
 * @author
 * @version 1.0
 * @date 2020/12/13 下午1:59
 * @description     704、二分查找及拓展
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

    //寻找左侧边界的二分搜索
    public int search1(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            //两边界都是闭区间
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                //收缩有边界，降低区域上线
                right=mid-1;
            }
            else if(nums[mid]<target){
                //收缩左边界
                left=mid+1;
            }else if(nums[mid]>target){
                //收缩右边界
                right=mid-1;
            }
        }
        if(left>=nums.length||nums[left]!=target){
            return -1;
        }
        return left;
    }

    //寻找右侧边界的二分搜索
    public int search2(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            //两边界都是闭区间
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                //收缩左边界，提高区域上线
                left=mid+1;
            }
            else if(nums[mid]<target){
                //收缩左边界
                left=mid+1;
            }else if(nums[mid]>target){
                //收缩右边界
                right=mid-1;
            }
        }
        //检查出界情况
        //当target比所有元素都小时，right会被减到-1
        if(right<0||nums[right]!=target){
            return -1;
        }
        return right;
    }
}
