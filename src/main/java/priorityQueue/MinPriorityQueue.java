package priorityQueue;

/**
 * @Author: Eiaokiang
 * @Description:
 * @Date: Created in 14:49 2023/4/23
 */

/**
 * 最小优先队列
 */
public class MinPriorityQueue<T extends Comparable<T>> {

    private T[] items;

    private int N;

    public MinPriorityQueue(int capacity) {
        items = (T[]) new Comparable[capacity + 1];
        N = 0;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }


    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }


    //交换heap堆中i索引和j索引处的值
    private void exch(int i, int j) {
        T tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    private void swim(int k) {
        while (k > 1) {
            if (less(k, k / 2)) {
                exch(k, k / 2);
            }
            k = k / 2;
        }
    }

    public T delMin() {
        T min = items[1];
        exch(1, N);
        items[N] = null;
        N--;
        sink(1);
        return min;
    }

    private void sink(int k) {
        //如果没有子结点，则不再下沉
        while (2 * k <= N) {
            //找出子结点中的较小值的索引
            int min = 2 * k;
            if (2 * k + 1 <= N && less(2 * k + 1, 2 * k)) {
                min = 2 * k + 1;
            }
            //如果当前结点小于子结点中的较小值，则结束循环
            if (less(k, min)) {
                break;
            }
            //当前结点大，交换
            exch(min, k);
            k = min;
        }
    }


    public static void main(String[] args) throws Exception {
        String[] arr = {"G", "F", "E", "E", "D", "C", "B", "A"};
        MinPriorityQueue<String> minpq = new MinPriorityQueue<>(20);
        for (String s : arr) {
            minpq.insert(s);
        }
        System.out.println(minpq.size());
        String del;
        while(!minpq.isEmpty()){
            del = minpq.delMin();
            System.out.print(del+",");
        }
    }


}
