package huawei.onestar;

import java.util.*;

/**
 * 【元音字符串】
 * 定义当一个字符串只有元音字母(a,e,i,o,u,A,E,I,O,U)组成,
 *     称为元音字符串，现给定一个字符串，请找出其中最长的元音字符串，
 *     并返回其长度，如果找不到请返回0，
 *     字符串中任意一个连续字符组成的子序列称为该字符串的子串
 *
 *     输入描述：
 *       一个字符串其长度 0<length ,字符串仅由字符a-z或A-Z组成
 *     输出描述：
 *       一个整数，表示最长的元音字符子串的长度
 *
 *     示例1：
 *       输入
 *         asdbuiodevauufgh
 *       输出
 *         3
 *       说明：
 *         最长的元音字符子串为uio和auu长度都为3，因此输出3
 *
 * @author apple
 */
public class Star66 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();
        sc.close();

        // 输入的数组
        char[] strAry = str.toCharArray();

        // 元音列表 Arrays.asList固定列表 无.add()等方法。
        /**
        ArrayList<Character> ls = new ArrayList<>();
        ls.add('a');
        ls.add('e');
        ls.add('i');
        ls.add('o');
        ls.add('u');
         */
        List<Character> strList = Arrays.asList('a', 'e', 'i', 'o', 'u');

        int tempCount = 0;
        int maxCount = 0;
        for (char c : strAry){
            if (strList.contains(c)){
                tempCount++;
            }else{
                maxCount = Math.max(maxCount, tempCount);
                tempCount = 0;
            }
            maxCount = Math.max(maxCount, tempCount);
        }
        System.out.println(maxCount);
    }
}
