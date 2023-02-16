import java.util.Arrays;

/**
 * @Author: Eiaokiang
 * @Description:
 * @Date: Created in 10:00 2023/2/15
 */
public class Select {

    public static void s(Comparable[] arr){
        for (int i = 0; i <= arr.length - 2; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (greater(arr[min],arr[j])){
                    min = j;
                }
            }
            ex(arr,i,min);
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
        Select.s(arr);
        System.out.println(Arrays.toString(arr));
    }
}
