import java.util.Arrays;

/**
 * @Author: Eiaokiang
 * @Description:
 * @Date: Created in 9:37 2023/2/15
 */
public class Bubb {


    public static void s(Comparable []arr){
        for (int i = arr.length -1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (greater(arr[j],arr[j+1])){
                    ex(arr,j,j+1);
                }
            }
        }
    }

    private static boolean greater(Comparable a , Comparable b){
        return a.compareTo(b)>0;
    }

    private static void ex(Comparable[] arr,int i,int j){
        Comparable temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr ={2,3,3,445,52423,1,867};
        Bubb.s(arr);
        System.out.println(Arrays.toString(arr));
    }

}
