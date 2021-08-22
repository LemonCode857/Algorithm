package huawei.onestar;

import java.util.*;

/**
 * 【勾股质数】
 * 如果三个正整数A B C ,A²+B²=C²则为勾股数
 * 如果ABC之间两两互质，即A与B A与C B与C均互质没有公约数，则称其为勾股质数元组。
 * 请求出给定n m 范围内所有的勾股质数元组
 *
 * 输入描述
 *    起始范围 1<n<10000    n<m<10000
 * 输出描述
 *    abc 保证a<b<c输出格式  a b c
 *    多组勾股数元组 按照a升序b升序 c升序的排序方式输出。
 *    给定范围内，找不到勾股数元组时，输出  Na
 *
 * 案例
 *  输入
 *    1
 *    20
 *  输出
 *    3 4 5
 *    5 12 13
 *    8 15 17
 *
 *  输入
 *   5
 *   10
 *  输出
 *    Na
 *
 * @author apple
 */

public class Star01 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();

        boolean isSuccess = false;

        int count = 0;
        for (int a = n; a <= m; a++){
            for (int b = a + 1; b <= m; b++){
                for (int c = a + 2; c <= m; c++) {
                    count ++;
                    if (a < b && b < c) {
                        if (a * a + b * b == c * c
                                && isZhishu(c, b)
                                && isZhishu(c, a)
                                && isZhishu(b, a)) {
                            // IF 两两互质 THEN输出
                            isSuccess = true;
                            System.out.println(a + " " + b + " " + c);
                        }
                    }
                }
            }
        }
        System.out.println(count);

        if (! isSuccess){
            System.out.println("Na");
        }
    }

    private static boolean isZhishu(int big, int small){

        /**
         * 0. 互为质数是指两个(或两个以上)自然数(0除外)的公因数只有1的；
         *    0是一个特殊数,它既没有约数,也没有倍数
         * */
        if (big == 0 || small == 0){
            return true;
        }

        /**
         * 1. 1与除0外的所有自然数互为质数
         * */
        if (small == 1){
            return true;
        }
        /**
         * 2. 判断两个数是否互为质数：
         *    大数取余小数，如果余数和小数互质，则大数和小数互质
         *   （用大数a取余小数b，如果余数c大于0时，小数b和余数c互为质数，则a和b互为质数）
         * */

        if (big % small == 0){
            return false;
        }else{
            return isZhishu(small, big % small);
        }
    }

}
