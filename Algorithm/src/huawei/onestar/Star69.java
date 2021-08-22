package huawei.onestar;

import java.util.*;

/**
 * 【字符串消消乐】
 * 游戏规则：输入一个只包含英文字母的字符串，
 *         字符串中的俩个字母如果相邻且相同，就可以消除。
 *         在字符串上反复执行消除的动作，
 *         直到无法继续消除为止，
 *         此时游戏结束。
 *         输出最终得到的字符串长度。
 *
 *         输出：原始字符串str只能包含大小写英文字母，字母的大小写敏感，长度不超过100，
 *         输出游戏结束后字符串的长度
 *
 *         备注：输入中包含非大小写英文字母是均为异常输入，直接返回0。
 *
 *         事例：mMbccbc输出为3
 *
 * @author apple
 */
public class Star69 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (str.replaceAll("[A-Z]", "").replaceAll("[a-z]", "").length() != 0){
            System.out.println(0);
            return;
        }

        // 写多读少用LinkedList
        LinkedList<Character> linkedList = new LinkedList<>();
        for (char c : str.toCharArray()){
            linkedList.add(c);
        }

        int count = linkedList.size();
        while (count != 0){
            for (int i = 0; i < linkedList.size() - 1; i++){
                // 判断包装类型间的相等判断应该用equals，而不是'=='
                if (linkedList.get(i).equals(linkedList.get(i + 1))){
                    linkedList.remove(i);
                    linkedList.remove(i);
                }
            }
            count --;
        }

        System.out.println(linkedList.size());

        // for test
        /**
        for (char aa : linkedList){
            System.out.println(aa);
        }
         */
    }
}
