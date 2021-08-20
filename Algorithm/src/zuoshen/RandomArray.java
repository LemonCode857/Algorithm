package zuoshen;



/**
 * 随机数组产生器
 * @author 78698
 */
public class RandomArray {
    public static void main(String[] args){
           getRandomArray( 6,  10);

    }

    /**  (int)(Math.random() * N)  返回 [0, n-1] 整数*/
    public static void getRandomArray(int maxSize, int maxValue){
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
        }

        for(int a : arr){
            System.out.println(a);
        }
    }


}
