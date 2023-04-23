package heap;


/**
 * 堆（完全二叉树，即每一层树都是满的，且用数组实现）
 * 除了树的最后一层结点不需要是满的，其它的每一层从左到右都是满的，如果最后一层结点不是满的，那么要求左满右不满
 * 每个结点都大于等于它的两个子结点。但子节点顺序没有要求
 * 如果一个结点的位置为k，则它的父结点的位置为[k/2],而它的两个子结点的位置则分别为2k和2k+1。
 *
 * @Author: Eiaokiang
 * @Description:
 * @Date: Created in 16:04 2023/4/19
 */
public class Heap<T extends Comparable<T>> {

    private T[] items;
    private int N;

    public Heap(int capacity) {
        //0索引不用  所以+1
        this.items = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }


    //判断i是否小于j
    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    private void exch(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }


    public void insert(T t) {
        //++N 是为了吧0 索引废弃
        items[++N] = t;
        //插入索引放入 插入的节点有可能比父节点大，所以要上浮
        swim(N);
    }

    /**
     * 上浮算法，新插入的一直和父节点比较即可
     *
     * @param k
     */
    private void swim(int k) {
        //到了根节点
        while (k > 1) {
            //如果父节点小于当前节点 交换
            if (less(k / 2, k)) {
                exch(k / 2, k);
            }
            k = k / 2;
        }
    }

    /**
     * 删除最大元素
     */
    public T delMax() {
        //第一个就是最大的
        T max = items[1];

        //交换最后一个元素
        exch(1, N);

        items[N] = null;
        N--;

        //最后一个元素不一定是最大的所以要下沉
        sink(1);
        return max;
    }


    /**
     * 下沉算法
     */
    private void sink(int k) {

        //到了最底层不需要循环了
        while (2 * k <= N) {

            int max = 2 * k;
            if (2 * k + 1 <= N) {
                //存在右子节点
                if (less(2 * k, 2 * k + 1)) {
                    max = 2 * k + 1;
                }
            }

            //已经不小于子节点中的较大者了，退出循环
            if (!less(k, max)) {
                break;
            }
            exch(k, max);
            k = max;
        }
    }


    public static void main(String[] args) throws Exception {
        Heap<String> heap = new Heap<String>(20);
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        for (String s : arr) {
            heap.insert(s);
        }
        //heap.insert("S");
        //heap.insert("G");
        //heap.insert("I");
        //heap.insert("E");
        //heap.insert("N");
        //heap.insert("H");
        //heap.insert("O");
        //heap.insert("A");
        //heap.insert("T");
        //heap.insert("P");
        //heap.insert("R");
        String del;
        while ((del = heap.delMax()) != null) {
            System.out.print(del + ",");
        }


    }

}
