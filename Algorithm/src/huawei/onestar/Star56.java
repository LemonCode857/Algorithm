package huawei.onestar;

import java.util.*;

/**
 * 【GPU执行任务】
 *          为了充分发挥Gpu算力，
 *          需要尽可能多的将任务交给GPU执行，
 *          现在有一个任务数组，
 *          数组元素表示在这1s内新增的任务个数，
 *          且每秒都有新增任务，
 *          假设GPU最多一次执行n个任务，
 *          一次执行耗时1s，
 *          在保证Gpu不空闲的情况下，最少需要多长时间执行完成。
 *
 *          输入描述
 *            第一个参数为gpu最多执行的任务个数
 *            取值范围1~10000
 *            第二个参数为任务数组的长度
 *            取值范围1~10000
 *            第三个参数为任务数组
 *            数字范围1~10000
 *
 *          输出描述
 *            执行完所有任务需要多少秒
 *
 *          例子
 *            输入
 *             3
 *             5
 *             1 2 3 4 5
 *            输出
 *             6
 *
 *             说明，一次最多执行3个任务  最少耗时6s
 *
 *           例子2
 *             输入
 *              4
 *              5
 *              5 4 1 1 1
 *             输出
 *              5
 *
 *            说明，一次最多执行4个任务  最少耗时5s
 *
 * @author apple
 */
public class Star56 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // Gpu一次执行任务数量
        int canDo = Integer.parseInt(sc.nextLine().trim());
        // 任务数组长度（有p用啊这,描述中没有说这个参数和第三个参数数组长度不一样这个场景该如何处理，要直接return吗）
        int wLen = Integer.parseInt(sc.nextLine().trim());
        // 任务数组
        String[] strAry = sc.nextLine().split(" ");
        sc.close();

        int[] workAry = new int[strAry.length];
        for(int i = 0; i < strAry.length; i++){
            workAry[i] = Integer.parseInt(strAry[i]);
        }

        // 单次执行完未执行的任务数量
        int notDo = 0;
        // 计时
        int time = 0;
        // 转圈儿开始
        for(int wantDo : workAry){
            // 一下没跑完还有notDo个没跑
            if (wantDo - canDo + notDo > 0){
                notDo = wantDo + notDo - canDo;
            }else{
                // 一下跑完了
                notDo = 0;
            }
            time++;
        }
        // System.out.println(notDo);
        // 再次转圈儿处理notDo
        while(notDo > 0){
            notDo -= canDo;
            time++;
        }

        System.out.println(time);

    }

}
