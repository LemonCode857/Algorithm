package areyouok;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 3
 * 1 1
 * 5 1
 * 28 3
 *
 * 0
 * 4
 * 5
 * @author 78698
 */
public class MinSheng01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        List<Integer> outpList = new ArrayList<>();
        int a = 0;
        int b = 0;
        while (num > 0){
            num--;
            String[] inpAry = sc.nextLine().split("//s+");
            a = Integer.parseInt(inpAry[0]);
            b = Integer.parseInt(inpAry[1]);

            // a = b = 0
            if ((a == 0) || (b == 0)){
                outpList.add(0);
                continue;
            }

            // a = b = 1
            if ((a == b) && (a == 1)){
                outpList.add(1);
            }

            // a > b
            if ( a > b){
                
            }


        }

    }
}
