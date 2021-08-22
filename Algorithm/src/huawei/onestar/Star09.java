package huawei.onestar;

import java.util.*;


/**
 * 【最大花费】
 *     双11众多商品进行打折销售，小明想购买一些自己心意的商品
 *     但由于受购买资金限制，所以他决定从众多心意商品中购买3件
 *     而且想尽可能的花完资金
 *     现在请你设计一个程序帮助小明计算尽可能花费的最大资金额
 *
 *  输入描述
 *      第一行为整型数组M 数组长度小于100 数组元素记录单个商品的价格
 *      单个商品价格<1000
 *      第二行输入为购买资金的额度R
 *      R<100000
 *
 *  输出描述
 *      输出为满足上述条件的最大花费额度
 *      如果不存在满足上述条件的商品请返回-1
 *
 *  例子1
 *     输入
 *      23,26,36,27
 *      78
 *     输出
 *      76
 *
 *  例子2
 *     输入
 *       23,30,40
 *       26
 *     输出
 *       -1
 *
 *     备注：输入格式正确
 *
 * @author apple
 */
public class Star09 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        // 预算
        int budget = sc.nextInt();

        String[] strAry = str.split(",");
        // 价格数组
        int[] intAry = new int[strAry.length];

        for(int i = 0; i < strAry.length; i++){
            intAry[i] = Integer.parseInt(strAry[i]);
        }

        TreeSet<Integer> treeSet = new TreeSet<Integer>();

        // 任意选三个数，每次任意选一个，选3次
        for (int a = 0; a < intAry.length; a ++){
            for (int b = 0; b < intAry.length; b++){
                for (int c = 0; c < intAry.length; c++){
                    // 循环选完之后把这个三个数求和，把和保存下来，然后在这些和中找到<=预算R的最大的那一个和，推荐用treeSet存储
                    // 【注意】：买3件，并不是要把同一个商品买3遍
                    if (a != b && a != c && b != c){
                        int sum = intAry[a] + intAry[b] + intAry[c];
                        if (sum <= budget){
                            treeSet.add(sum);
                        }
                    }

                }
            }
        }

        if (treeSet.size() != 0){
            // 获取treeSet中最大的那个值
            /**Java.util.TreeSet.last()方法用于返回TreeSet的最后一个元素。
             * 这里的最后一个元素被引用到集合中最高的元素。如果元素是整数类型，则返回最大的整数。
             * 如果元素是字符串类型，则按字母顺序检查元素，并返回以字典顺序的最后一个字母开头的字符串，而不管长度如何。
             * */
            System.out.println(treeSet.last());
        }else{
            System.out.println(-1);
        }

    }
}
