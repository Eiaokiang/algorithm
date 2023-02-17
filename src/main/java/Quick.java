import java.util.Arrays;

/**
 * @Author: Eiaokiang
 * @Description:
 * @Date: Created in 16:16 2023/2/17
 */
public class Quick {

    public static void sort(Comparable[] arr){
        int lo = 0;
        int hi = arr.length - 1;
        sort(arr,lo,hi);
    }

    private static void sort(Comparable[] arr,int lo,int hi){
        if (hi <= lo){
            return;
        }

        int partition = partition(arr, lo, hi);
        sort(arr,lo,partition-1);
        sort(arr,partition+1,hi);
    }

    private static int partition(Comparable[] arr, int lo, int hi) {
        Comparable key = arr[lo];

        int left = lo;
        int right = hi +1;

        while (true){

            while (less(key,arr[--right])){
                if (right == lo){
                    break;
                }
            }

            while (less(arr[++left],key)){
                if (left == hi){
                    break;
                }
            }


            if(left >= right){
                break;
            }else {
                ex(arr,left,right);
            }

        }

        ex(arr,lo,right);

        return right;


    }

    private static Boolean less(Comparable a,Comparable b){
        return a.compareTo(b) <0;
    }

    private static void ex(Comparable[] arr,int i,int j){
        Comparable temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr ={2,5,3,4,7,1,8,5,9,6};
        Quick.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
