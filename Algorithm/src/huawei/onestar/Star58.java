package huawei.onestar;

import java.util.*;

/**
 *         一个工厂有m条流水线
 *         来并行完成n个独立的作业
 *         该工厂设置了一个调度系统
 *         在安排作业时，总是优先执行处理时间最短的作业
 *         现给定流水线个数m
 *         需要完成的作业数n
 *         每个作业的处理时间分别为 t1,t2...tn
 *         请你编程计算处理完所有作业的耗时为多少
 *         当n>m时 首先处理时间短的m个作业进入流水线
 *         其他的等待
 *         当某个作业完成时，
 *         依次从剩余作业中取处理时间最短的
 *         进入处理
 *
 *         输入描述：
 *         第一行为两个整数(采取空格分隔)
 *         分别表示流水线个数m和作业数n
 *         第二行输入n个整数(采取空格分隔)
 *         表示每个作业的处理时长 t1,t2...tn
 *         0<m,n<100
 *         0<t1,t2...tn<100
 *
 *         输出描述
 *         输出处理完所有作业的总时长
 *
 *         案例
 *         输入
 *            3 5
 *            8 4 3 2 10
 *         输出
 *            13
 *         说明
 *         先安排时间为2,3,4的三个作业
 *         第一条流水线先完成作业
 *         调度剩余时间最短的作业8
 *         第二条流水线完成作业
 *         调度剩余时间最短的作业10
 *         总共耗时 就是二条流水线完成作业时间13(3+10)
 *
 *         3 9
 *         1 1 1 2 3 4 6 7 8
 *
 * @author apple
 */
public class Star58 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] inpA = sc.nextLine().split(" ");
        // Line
        int m = Integer.parseInt(inpA[0]);
        // ren wu
        int n = Integer.parseInt(inpA[1]);
        String[] inpB = sc.nextLine().split(" ");
        sc.close();
        // time
        List<Integer> timeList = new ArrayList<>();
        for (int i = 0; i < inpB.length; i++){
            timeList.add(Integer.parseInt(inpB[i]));
        }
        Collections.sort(timeList);

        /** 给一个数字串儿和一个正整数表示要输出m行 ，输出：m行有序字符矩阵，同行数字相加 输出和最大的一行
         *  2
         *  8 3 6 1 8
         *  --------
         *  1 6 8
         *  3 8
         *
         *  */
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        int x = 1;
        for (int i = 0; i < timeList.size(); i++){
            treeMap.put(x,treeMap.getOrDefault(x,0) + timeList.get(i));
            x++;
            if (x > m){
                x = 1;
            }
        }

        List<Integer> outpList = new ArrayList<>();
        treeMap.entrySet().stream().forEach(v ->{
            outpList.add(v.getValue());
        });
        Collections.sort(outpList);

        System.out.println(outpList.get(outpList.size()-1));
    }
}
