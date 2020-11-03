package offer;

/**
 * @author
 * @version 1.0
 * @date 2020/11/3 下午3:37
 * @description
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 **/

public class FindNumInArray {
    public boolean find(int target, int[][] array) {
        int row = 0;
        int col = array[0].length - 1;
        while (row <= array.length && col >= 0) {
            if (target == array[row][col]) {
                return true;
            } else if (target > array[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    //二分
    public static boolean Find(int[][] array, int target) {
        for (int i = 0; i < array.length; i++) {
            int low = 0;
            int high = array[i].length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (target > array[i][mid]) {
                    low = mid + 1;
                }
                //因为每次当前位置的列都是从mid开始遍历每一行
                //所以这里判断的是target是否在0列(mid不会为0)
                else if (target < array[i][mid]) {
                    high = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int arrays[][]={{1,4,7,9},{2,7,8,11},{4,8,12,19}};
        if(Find(arrays,12)) {
            System.out.println("数据含有这样的整数");
        } else {
            System.out.println("没有这样的整数");
        }
    }
}
