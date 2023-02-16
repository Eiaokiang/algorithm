import java.util.Arrays;

/**
 * @Author: Eiaokiang
 * @Description:
 * @Date: Created in 11:03 2023/2/16
 */

/**
 * 希尔排序
 * 插入排序的升级版，先按h分组再排序
 * 时间复杂度：算不出，但事后分析法优于插入排序
 */
public class Shell {

    public static void s(Comparable[] arr){
        int n = arr.length;

        //h 为距离进行分组 从1开始
        int h = 1;
        //固定公式 计算当前数组最大的距离h
        while (h < n/2){
            h = 2*h +1;
        }
        // 1. 分组
        //（下标）0+h,0+2h..分为一组
        //（下标）1+h,1+2h..分为一组
        //（下标）3+h,3+2h..分为一组
        //..

        //2. 排序



        //当距离相距为1时，说明只有一组局部有序的数组了，还需最后一次排序，h=0时退出
        while (h >= 1){
            //从第h个开始，h到n后都是要比较的arr[i]  所以i从h开始一直到n
            for (int i = h; i < n; i++) {
                //
                for (int j = i; j >= h; j-=h) {
                    if (greater(arr[j],arr[j-h])){
                        ex(arr,j,j-h);
                    }else {
                        break;
                    }
                }
            }
            //固定公式  不断减小距离
            h = h/2;
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
        Integer[] arr ={2,5,3,4,7,1,8,5,9,6};
        Shell.s(arr);
        System.out.println(Arrays.toString(arr));
    }
}
