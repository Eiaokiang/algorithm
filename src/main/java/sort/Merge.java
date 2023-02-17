package sort;

import java.util.Arrays;

/**
 * @Author: Eiaokiang
 * @Description:
 * @Date: Created in 14:23 2023/2/16
 */
public class Merge {
    
    private static Comparable[] assist;
    
    public static void sort(Comparable[] arr){
       assist = new Comparable[arr.length];
       int lo = 0;
       int hi = arr.length - 1;
       sort(arr,lo,hi);
    }
    private static void sort(Comparable[] arr,int lo,int hi){
        if (lo >= hi){
            return;
        }

        int mid = lo + (hi - lo)/2;

        sort(arr,lo,mid);
        sort(arr,mid+1,hi);
        merge(arr,lo,mid,hi);
    }

    private static void merge(Comparable[] arr, int lo, int mid, int hi) {
        int i = lo;
        int p1 = lo;
        int p2 = mid+1;

        while (p1 <= mid && p2 <= hi){
            if (less(arr[p1],arr[p2])){
                assist[i++] = arr[p1++];
            }else {
                assist[i++] = arr[p2++];
            }
        }


        while (p1 <= mid){
            assist[i++] = arr[p1++];
        }

        while (p2 <= hi){
            assist[i++] = arr[p2++];
        }

        for (int j = lo; j <= hi ; j++) {
            arr[j] = assist[j];
        }

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
        Merge.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
