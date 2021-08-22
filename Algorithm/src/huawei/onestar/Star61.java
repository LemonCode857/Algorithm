package huawei.onestar;

import java.util.*;

/**
 *     给你两个字符串t和p
 *     要求从t中找到一个和p相同的连续子串
 *     并输出该子串第一个字符的下标
 *     输入描述
 *         输入文件包括两行 分别表示字符串t和p
 *         保证t的长度不小于p
 *         且t的长度不超过1000000
 *         p的长度不超过10000
 *     输出描述
 *         如果能从t中找到一个和p相等的连续子串,
 *         则输出该子串第一个字符在t中的下标
 *         下标从左到右依次为1,2,3,...；
 *         如果不能则输出 "No"
 *         如果含有多个这样的子串
 *         则输出第一个字符下标最小的
 *
 *      示例一：
 *         输入：
 *          AVERDXIVYERDIAN
 *          RDXI
 *         输出
 *          4
 * @author apple
 */
public class Star61 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String aa = sc.nextLine();
        String bb = sc.nextLine();
        sc.close();

        for (int i = 0; i < aa.length() - bb.length(); i++){
            String str = aa.substring(i, i + bb.length());

            if(bb.equals(str)){
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println("No");

    }
}
