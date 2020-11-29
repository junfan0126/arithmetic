package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author
 * @version 1.0
 * @date 2020/11/29 下午3:39
 * @description         139、单词拆分
 **/

public class WordBreak {
    public HashMap<String, Boolean> hash = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        //dp[i]表示s前i个字符能否拆分
        boolean[] dp = new boolean[s.length()+1];

        //通过HashMap来做字典
        for(String word : wordDict){
            hash.put(word, true);
        }

        //初始化
        dp[0] = true;

        //遍历
        for(int j = 1; j <= s.length(); j++){
            for(int i = j-1; i >= 0; i--){
                //   假如wordDict=["apple", "pen", "code"],s = "applepencode";
                //        dp[8] = dp[5] + check("pen")
                //  前八位能否拆分取决于前五位能否拆分，加上五到八位是否属于字典
                dp[j] = dp[i] && check(s.substring(i, j));
                //判断出可分时则跳出
                if(dp[j]) {
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public boolean check(String s){
        return hash.getOrDefault(s, false);
    }

    public static void main(String[] args) {
        List<String> word=new ArrayList<>();
        word.add("apple");
        word.add("pen");
        word.add("code");

        String s="applepencode";
        WordBreak wordBreak=new WordBreak();
        System.out.println(wordBreak.wordBreak(s,word));
    }
}
