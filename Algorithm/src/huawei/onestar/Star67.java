package huawei.onestar;

import java.util.Scanner;

/**
 *【90%】
 *         给定一个字符串S
 *
 *         变化规则:
 *          交换字符串中任意两个不同位置的字符
 *
 *         输入描述：
 *          一串小写字母组成的字符串
 *         输出描述：
 *          按照要求变换得到最小字符串
 *
 *         实例1：
 *          输入：、
 *          abcdef
 *         输出
 *          abcdef
 *
 *         实例2：
 *          输入
 *          bcdefa
 *          输出
 *          acdefb
 *
 *         s都是小写字符组成
 *         1<=s.length<=1000
 *
 * @author 78698
 */
public class Star67 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        sc.close();

        char[] charArray = inp.toCharArray();
        char min = charArray[0];
        int k = 0;
        for (int i = 0; i < charArray.length; i++){
            if (charArray[i] < min){
                k = i;
                min = charArray[i];
            }
        }
        if (k > 0){
            charArray[k] = charArray[0];
            charArray[0] = min;
        }
        System.out.println(charArray);
    }
}
