package huawei.onestar;

import java.util.*;
import java.util.stream.Collectors;


/**
 * 【公司员工出勤】
 *     公司用一个字符串来标识员工的出勤信息
 *
 *     absent:    缺勤
 *     late:      迟到
 *     leaveearly:早退
 *     present:   正常上班
 *
 *     现需根据员工出勤信息,判断本次是否能获得出勤奖,
 *     能获得出勤奖的条件如下：
 *         1.缺勤不超过1次
 *         2.没有连续的迟到/早退
 *         3.任意连续7次考勤 缺勤/迟到/早退 不超过3次
 *
 *      输入描述：
 *       用户的考勤数据字符串记录条数  >=1
 *       输入字符串长度 <10000 ;
 *       不存在非法输入
 *       如：
 *        2
 *        present
 *        present absent present present leaveearly present absent
 *
 *       输出描述：
 *       根据考勤数据字符串
 *       如果能得到考勤奖输出true否则输出false
 *       对于输出示例的结果应为
 *        true false
 *
 *       示例一：
 *        输入：
 *         2
 *         present
 *         present present
 *
 *        输出：
 *         true true
 *
 *       示例二
 *        输入：
 *         2
 *         present
 *         present absent present present leaveearly present absent
 *        输出：
 *         true false
 *
 * @author 78698
 */
public class Star59 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        ArrayList<List<String>> inpAl = new ArrayList<>();
        for (int i = 0; i < num; i++){
            String[] kq = sc.nextLine().split(" ");
            List<String> kqList = Arrays.stream(kq).collect(Collectors.toList());
            inpAl.add(kqList);
        }
        sc.close();

        StringBuilder sb = new StringBuilder();

        for (List<String> ls : inpAl){
            /** 1.缺勤不超过1次 */
            if (ls.contains("absent")){
                sb.append("false").append(" ");
                continue;
            }
            /** 2.没有连续的迟到late/早退leaveearly*/
            boolean hasFalg = true;
            for (int i = 0; i < inpAl.size() - 1; i++){
                String strA = ls.get(i);
                String strB = ls.get(i+1);
                if (("late".equals(strA) && "leaveearly".equals(strB)) || ("late".equals(strB) && "leaveearly".equals(strA)){
                    hasFalg = false;
                    break;
                }
            }
            if (!hasFalg){
                sb.append(hasFalg).append(" ");
                continue;
            }

            /** 3.任意连续7次考勤 缺勤/迟到/早退 不超过3次*/
            int qczCount = 0;
            int lianCount = 0;
            for (int i = 0; i < inpAl.size(); i++){
                if (!"present".equals(inpAl.get(i))){
                    qczCount++;
                }
                lianCount += 1;
            }
            if ((lianCount <= 7) && (qczCount >= 3)){
                sb.append("false").append(" ");
            }else{
                hasFalg = true;
                for(int i = 0; i < lianCount -1);
            }
        }



    }
}