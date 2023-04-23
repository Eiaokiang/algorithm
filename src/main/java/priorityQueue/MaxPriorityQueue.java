package priorityQueue;

/**
 * @Author: Eiaokiang
 * @Description:
 * @Date: Created in 14:49 2023/4/23
 */

/**
 * 最大优先队列(和堆一样代码)
 */
public class MaxPriorityQueue<T extends Comparable<T>> {

    private T[] items;

    private int N;

    public MaxPriorityQueue(int capacity){
        items = (T[]) new Comparable[capacity + 1];
        N = 0;
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }


    private boolean less(int i, int j){
        return items[i].compareTo(items[j]) <0;
    }


    //交换heap堆中i索引和j索引处的值
    private void exch( int i, int j) {
        T tmp =  items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    public void insert(T t){
        items[++N] = t;
        swim(N);
    }

    private void swim(int k) {
        while (k > 1){
            if (less(k /2,k)){
                exch(k /2 ,k);
            }
            k = k / 2;
        }
    }

    public T delMax(){
        T max = items[1];
        exch(1,N);
        items[N] = null;
        N--;
        sink(1);
        return max;
    }

    private void sink(int k){
        while (2*k <= N){
            int max = 2*k;
            if (2*k+1 <= N){
                if (less(2*k,2*k+1)){
                    max = 2*k+1;
                }
            }

            if (!less(k,max)){
                break;
            }
            exch(k,max);
            k = max;
        }
    }



        public static void main(String[] args) throws Exception {
            String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
            MaxPriorityQueue<String> maxpq = new MaxPriorityQueue<>(20);
            for (String s : arr) {
                maxpq.insert(s);
            }
            System.out.println(maxpq.size());
            String del;
            while(!maxpq.isEmpty()){
                del = maxpq.delMax();
                System.out.print(del+",");
            }
        }


}
