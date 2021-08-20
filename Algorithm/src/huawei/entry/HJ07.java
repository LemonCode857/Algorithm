package huawei.entry;
/**
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class HJ04{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int node = str.indexOf(".");
        int left = Integer.parseInt(str.substring(0, node));
        int right = Integer.parseInt(str.substring(node+1, node+2));

        if (right >= 5){
            System.out.println(left + 1);
        }else{
            System.out.println(left);
        }
    }
}
 */

import java.util.*;

public class HJ07 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int node = str.indexOf(".");
        int left = Integer.parseInt(str.substring(0, node));
        int right = Integer.parseInt(str.substring(node + 1, node + 2));

        if (right >= 5){
            System.out.println(left + 1);
        }else{
            System.out.println(left);
        }
    }
}
