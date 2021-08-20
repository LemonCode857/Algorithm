package zuoshen;

import java.util.*;

/**
 * 选择排序
 * @author 78698
 */
public class SelectSort {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

    }

    public static void getSort(int[] ary){
        // 如果数组为空或其长度小于2那还排个88
        if (ary == null ||ary.length < 2){
            return;
        }
        // i 到 N-1
        for (int i = 0; i < ary.length - 1; i++){
            int min = i;
            for (int y = i; y < ary.length - 1; y++){
                // i 到 N-1 上获得最小值的下标

            }

        }
    }
}
