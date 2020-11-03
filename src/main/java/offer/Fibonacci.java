package offer;

/**
 * @author
 * @version 1.0
 * @date 2020/11/3 下午6:09
 * @description         实现斐波那契俄数列
 **/

public class Fibonacci {

    //非递归
    public int fibonacci(int n) {
        int preNum = 1;
        int prePreNum = 0;
        int result = 0;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        for (int i = 2; i <= n; i++) {
            result = preNum + prePreNum;
            prePreNum = preNum;
            preNum = result;
        }
        return result;
    }

    //递归(数据量大时栈溢出)
    public int fibonacci1(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci1(n - 2) + fibonacci1(n - 1);

    }
}

