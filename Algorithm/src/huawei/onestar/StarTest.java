package huawei.onestar;

import java.util.*;
import java.util.stream.Collectors;


/**
 * @author apple
 */
public class StarTest{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,Integer> inpMap = new HashMap<>();
        Arrays.stream(sc.nextLine().split(" ")).forEach(x ->{
           int i = Integer.parseInt(x);
           inpMap.put(i, inpMap.getOrDefault(i, 0) + 1);
        });

        Integer maxValue = inpMap.values().stream().max(Integer::compareTo).get();

        List<Integer> newList = inpMap.keySet().stream().filter(x -> inpMap.get(x).equals(maxValue)).sorted(Integer::compareTo).collect(Collectors.toList());

        Integer outp = 0;
        int size = newList.size();
        if (size % 2 == 0){
            outp = (newList.get(size / 2) + newList.get(size / 2 - 1)) / 2;
        }else{
            outp = newList.get(size / 2);
        }

        System.out.println(outp);

    }
}