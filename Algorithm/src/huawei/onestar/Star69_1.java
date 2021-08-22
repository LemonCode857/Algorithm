package huawei.onestar;



        import java.util.LinkedList;
        import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2021/8/17
 * Time: 18:42
 * Description:100%
 */
public class Star69_1 {
    public static void main(String[] args) {
        /*
        游戏规则：输入一个只包含英文字母的字符串，
        字符串中的俩个字母如果相邻且相同，就可以消除。
        在字符串上反复执行消除的动作，
        直到无法继续消除为止，
        此时游戏结束。
        输出最终得到的字符串长度。

        输出：原始字符串str只能包含大小写英文字母，字母的大小写敏感，长度不超过100，
        输出游戏结束后字符串的长度

        备注：输入中包含非大小写英文字母是均为异常输入，直接返回0。

        事例：mMbccbc输出为3
         */

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();

        int a = getAdd(str);
        int b = getAss(str);
        System.out.println(a == b);
        System.out.println("a= " + a + ", b= " + b);

    }

    private static int getAdd(String str){
        if (str.replaceAll("[A-Z]", "").replaceAll("[a-z]", "").length() != 0){
            System.out.println(0);
            return 0;
        }

        // 写多读少用LinkedList
        LinkedList<Character> linkedList = new LinkedList<>();
        for (char c : str.toCharArray()){
            linkedList.add(c);
        }

        int count = linkedList.size();
        while (count != 0){
            for (int i = 0; i < linkedList.size() - 1; i++){
                if (linkedList.get(i).equals(linkedList.get(i + 1))){
                    linkedList.remove(i);
                    linkedList.remove(i);
                }
            }
            count --;
        }

        //System.out.println(linkedList.size());
        return linkedList.size();

        // for test
        /**
         for (char aa : linkedList){
         System.out.println(aa);
         }
         */
    }

    // 源网站解法
    private static int getAss(String str){
        int len = str.replaceAll("[A-Z]", "")
                .replaceAll("[a-z]", "")
                .length();
        if (len != 0) {
            System.out.println(0);
            return 0;
        }

        LinkedList<Character> characters = new LinkedList<>();
        for (char c : str.toCharArray()) {
            characters.add(c);
        }

        int count = 0;
        while (characters.size() != count) {
            count = characters.size();
            for (int i = 0; i < characters.size() - 1; i++) {
                // 包装类型间的相等判断应该用equals，而不是'=='
                if (characters.get(i) == characters.get(i + 1)) {
                    characters.remove(i);
                    characters.remove(i);
                    i--;
                }
            }
        }

        return characters.size();
    }
}





