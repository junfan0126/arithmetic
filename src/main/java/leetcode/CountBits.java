package leetcode;

/**
 * @author
 * @version 1.0
 * @date 2020/11/28 下午7:21
 * @description     338、比特位计数
 **/

public class CountBits {
    public static void main(String[] args) {
        int num=2;
        CountBits countBits=new CountBits();
        int []count=countBits.countBits(num);
        for (int i:count){
            System.out.println(count[i]);
        }
    }
    //i为十进制原码，当i为偶数时,dp[i]和dp[i/2]的是相同的
    //相当于i/2的二进制数左移一位，末位补0
    //
    public int[] countBits(int num){
        if(num==0){
            return new int[]{0};
        }
        int[] dp=new int[num+1];
        dp[0]=0;
        for(int i=0;i<=num;i++){
            if(i%2==0) {
                dp[i]=dp[i/2];
            }
            else {
                dp[i]=dp[i-1]+1;
            }
        }
        return dp;
    }
}
