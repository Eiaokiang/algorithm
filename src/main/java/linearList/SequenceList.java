package linearList;

import java.util.Arrays;

/**
 * @Author: Eiaokiang
 * @Description:
 * @Date: Created in 17:56 2023/2/17
 */
public class SequenceList<T> {

    private T[] eles;

    private int N;


    public SequenceList(int capacity) {
        eles = (T[]) new Object[capacity];
        N = 0;
    }


    public void clear(){
        //eles = (T[]) new Object[eles.length];
        N = 0;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int length(){
        return N;
    }

    public T get(int i){
        if (i<0 || i>=N){
            throw new RuntimeException("元素不存在");
        }
        return eles[i];
    }

    public void insert(int i,T t){
        if (i<0 || i > eles.length - 1){
            throw new RuntimeException("index error");
        }
        if (N+1 > eles.length){
            throw new RuntimeException("容量不足");
        }

        for (int j = N; j > i; j--) {
            eles[j] = eles[j-1];
        }
        N++;
        eles[i] = t;
    }

    public void insert(T t){
        if (N+1 > eles.length){
            throw new RuntimeException("容量不足");
        }

        eles[N++] = t;
    }

    @Override
    public String toString() {
        return  Arrays.toString(eles);
    }

    public static void main(String[] args) {
        SequenceList<Integer> list = new SequenceList<Integer>(3);
        System.out.println(list.length());
        System.out.println(list.isEmpty());
        list.insert(1);
        list.insert(1);
        System.out.println(list.toString());

        System.out.println(list.isEmpty());
        list.insert(0,2);
        System.out.println(list.length());
        System.out.println(list.toString());
    }


}
