package huawei.entry;

import java.util.*;

/**
 public class HJ11 {
 public static void main(String[] agrs){
 Scanner sc = new Scanner(System.in);
 String str = sc.nextLine();
 StringBuilder sb = new StringBuilder(str);
 sb.reverse();
 System.out.println(sb);
 }
 }
 */

public class HJ11{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--){
            sb.append(str.charAt(i));
        }
        System.out.println(sb);
    }
}

