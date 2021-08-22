package huawei.onestar;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 【众数中位数】
 * 1.众数是指一组数据中出现次数最多的那个数据,一组数据可以有多个众数,也可以没有众数。
 *         2.中位数是指把一组数据从小到大排列，最中间的那个数，
 *         如果这组数据的个数是奇数，那最中间那个就是中位数
 *         如果这组数据的个数为偶数，那就把中间的两个数之和除以2就是中位数
 *         3.查找整型数组中元素的众数并组成一个新的数组
 *         求新数组的中位数
 *
 *         输入描述
 *         输入一个一维整型数组，数组大小取值范围   0<n<1000
 *         数组中每个元素取值范围，  0<e<1000
 *
 *         输出描述
 *         输出众数组成的新数组的中位数
 *
 *         示例一
 *         输入：
 *         10 11 21 19 21 17 21 16 21 18 16
 *         输出
 *         21
 *
 *         示例二
 *         输入
 *         2 1 5 4 3 3 9 2 7 4 6 2 15 4 2 4
 *         输出
 *         3
 *
 *          示例三
 *         输入
 *         5 1 5 3 5 2 5 5 7 6 7 3 7 11 7 55 7 9 98 9 17 9 15 9 9 1 39
 *         输出
 *         7
 * @author apple
 */
public class Star34 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        /**
         * 1.获取输入根据空格分解为新的数组
         * 2.将数组转化成流
         * 3.遍历数组，并存放于HashMap中利用HashMap特性，Key为输入的数组中的值，Value为数组中的值出现的次数
         * */
        Arrays.stream(in.nextLine().split(" "))
                .forEach(x -> {
                    int i = Integer.parseInt(x);
                    map.put(i, map.getOrDefault(i, 0)+1);
                });
        in.close();

        /**
         * 0.获取最大Value
         * 1.获取map中的所有Values，并形成为流
         * 2.排序然后找最大.max(Integer::compareTo)
         * 3.返回其中值最大的元素.get()
         * */
        Integer max = map.values().stream().max(Integer::compareTo).get();

        /**
         * 1.获取map的所有的Key，并形成流
         * 2.筛选出所有Value值为最大Value所对应的Key
         * 3.进行排序
         * 4.形成List，即：得到了由众数组成的新数组
         * */
        List<Integer> newArr = map.keySet().stream()
                .filter(k -> map.get(k).equals(max))
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());

        /**
         * 获取并输出新数组的中位数
         * */
        Integer res = 0;
        int size = newArr.size();
        if (size % 2 == 0) {
            res = (newArr.get(size / 2) + newArr.get(size / 2 - 1)) / 2;
        } else {
            res = newArr.get(size / 2);
        }

        System.out.println(res);

    }
}
