package heap;

/**
 * @Author: Eiaokiang
 * @Description:
 * @Date: Created in 16:56 2023/4/21
 */

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {


    public static void sort(Comparable[] source) {
        //1.创建比原数组大1的数组
        Comparable[] heap = new Comparable[source.length + 1];

        //2.构造有序堆
        createHeap(source, heap);

        //3.用有序堆对原数组排序

        //定义1个未排序的最后索引值
        int N = heap.length - 1;
        while (N != 1) {
            //交换完以后 最后的位置就是最大的了，所以后面就不参与
            exch(heap, 1, N);
            //排好序的不参与
            N--;
            sink(heap, 1, N);
        }
        //4.堆中数据有序，拷贝回去
        System.arraycopy(heap, 1, source, 0, source.length);
    }


    /**
     * 比较大小
     */
    private static boolean less(Comparable[] heap, int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }


    //交换heap堆中i索引和j索引处的值
    private static void exch(Comparable[] heap, int i, int j) {
        Comparable tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }


    /**
     * 堆构造方法：
     * 创建一个新数组，把原数组 0~length-1的数据拷贝到新数组的1~length处，再从新数组长度的一半处开始往1索引处扫描（从右往左），然后对扫描到的每一个元素做下沉（都是根节点）调整即可
     * <p>
     * 因为数组的一半往前是根节点，往后全是叶子节点
     */
    private static void createHeap(Comparable[] source, Comparable[] heap) {
        //1.把原数组的所有拷贝到堆数组的1往后
        System.arraycopy(source, 0, heap, 1, source.length);

        //2. 从索引出一半往左开始做下沉，这样的目的可使整体有序
        for (int i = (heap.length - 1) / 2; i > 0; i--) {
            sink(heap, i, heap.length - 1);
        }
    }


    private static void sink(Comparable[] heap, int target, int range) {

        //没有子节点了
        while (2 * target <= range) {

            //左右子节点中的较大值
            int max = 2 * target;
            if (2 * target + 1 <= range) {
                //存在右子节点
                if (less(heap, 2 * target, 2 * target + 1)) {
                    max = 2 * target + 1;
                }
            }

            //如果当前小于较大子节点值，交换
            if (less(heap, target, max)) {
                exch(heap, target, max);
            }

            //更新target
            target = max;
        }
    }


    public static void main(String[] args) throws Exception {
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        HeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
