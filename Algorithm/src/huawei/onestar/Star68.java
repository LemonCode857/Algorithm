package huawei.onestar;

import java.util.*;
// import java.util.stream.Collectors;

/**
 * 给定一个随机的整数数组(可能存在正整数和负整数)nums,
 * 请你在该数组中找出两个数，其和的绝对值(|nums[x]+nums[y]|)为最小值
 * 并返回这两个数(按从小到大返回)以及绝对值。
 * 每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 输入描述：
 *  一个通过空格空格分割的有序整数序列字符串，最多1000个整数，
 *  且整数数值范围是[-65535,65535]
 *
 * 输出描述：
 *   两个数和两数之和绝对值
 *
 *  示例一：
 *   输入
 *   -1 -3 7 5 11 15
 *   输出
 *   -3 5 2
 *
 * 说明：
 * 因为|nums[0]+nums[2]|=|-3+5|=2最小，
 * 所以返回-3 5 2
 *
 * @author 78698
 */
public class Star68 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> treeSet = new TreeSet<>();
        Arrays.stream(sc.nextLine().split(" ")).forEach(x ->{
            treeSet.add(Integer.parseInt(x));
        });
        sc.close();

        List<Integer> arrayList = new ArrayList<>(treeSet);
        // List<Integer> arrayList = treeSet.stream().collect(Collectors.toList());

        TreeMap<Integer, String> plusMap = new TreeMap<>();
        for (int a = 0; a < arrayList.size(); a++){
            for (int b = a; b < arrayList.size(); b++){
                int temA = arrayList.get(a);
                int temB = arrayList.get(b);
                if (temA != temB){
                    int sum = Math.abs(temA + temB);
                    if (temA > temB){
                        plusMap.put(sum, temB+" "+temA+" "+sum);
                    }else{
                        plusMap.put(sum, temA+" "+temB+" "+sum);
                    }
                }
            }
        }

        System.out.println(plusMap.get(plusMap.firstKey()));
    }
}
