/**
 * @author
 * @version 1.0
 * @date 2020/11/3 下午3:26
 * @description     将一组字符串
 **/

public class ReplaceSpace {
    public String replaceSpace(StringBuffer str){
        return str.toString().replaceAll("//s","%20");
    }
}
