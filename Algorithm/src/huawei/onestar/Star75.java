package huawei.onestar;

import java.util.*;

/**
 * @author 78698
 *   输入一串字符串
 *   字符串长度不超过100
 *   查找字符串中相同字符连续出现的最大次数
 *
 *   输入描述
 *     输入只有一行，包含一个长度不超过100的字符串
 *
 *   输出描述
 *     输出只有一行，输出相同字符串连续出现的最大次数
 *
 *    说明：
 *      输出
 *
 *    示例1：
 *      输入
 *        hello
 *      输出
 *        2
 *
 *     示例2：
 *       输入
 *        word
 *       输出
 *        1
 *
 *      示例3：
 *       输入
 *         aaabbc
 *        输出
 *         3
 *
 *     字符串区分大小写
 */
public class Star75 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String  inStr = sc.nextLine();
        sc.close();
        char [] inChar = inStr.toCharArray();

        // 定义一个HashMap，将字符存入HashMap中
        HashMap<Character,Integer> hashMap = new HashMap<Character, Integer>(100);

        for (char c : inChar){
            hashMap.put(c, hashMap.get(c) == null ? 1 : hashMap.get(c) + 1);
        }

        Integer maxValue = 0;
        Integer curValue = 0;

        for(Map.Entry<Character,Integer> entry : hashMap.entrySet()){
            curValue = entry.getValue();
            maxValue = curValue > maxValue ? curValue : maxValue;
        }

        //Character maxChar = null;
        //hashMap.entrySet().parallelStream().max(Comparator.comparing(String::valueOf)).ifPresent(e -> System.out.println(e));
        System.out.println(maxValue);




    }
}
