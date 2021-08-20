package zuoshen;

/**
 * 不用额外变量交换两个数
 * @author 78698
 */
public class ChangeNotNew {
    public static void main(String[] args){
        int a = 12;
        int b = 567;

        System.out.println("交换前：a= " + a + " b= " +b);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("交换后：a= " + a + " b= " +b);

    }
}
