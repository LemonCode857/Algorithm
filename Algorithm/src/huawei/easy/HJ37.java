package huawei.easy;

import java.util.*;

public class HJ37{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int mon = sc.nextInt();
            System.out.println(getSum(mon));
        }
    }

    public static int getSum(int mon){
        if (mon < 1){
            return 0;
        }
        int a = 1;
        int b = 1;
        int sum = 1;
        for (int i = 2; i < mon; i++){
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }
}
