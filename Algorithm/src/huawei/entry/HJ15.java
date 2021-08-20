package huawei.entry;

import java.util.*;

public class HJ15{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        getOneCount(num);
        sc.close();
    }
    public static void getOneCount(int n){
        int res = 0;
        while(n > 0){
            // 取反加1，按位与
            int rightOne = n & (~n + 1);
            // 再异或
            n ^= rightOne;
            res++;
        }
        System.out.println(res);
    }
}

/**
import java.util.*;

public class HJ15{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;
        for (int i = 0; i < 32; i++){
            if ((num & 1) == 1){
                count ++;
            }
            // 无符号右移
            num = num >>> 1;
        }
        System.out.println(count);
        sc.close();
    }
}
 */
