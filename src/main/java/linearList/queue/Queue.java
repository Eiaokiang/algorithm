package linearList.queue;

import java.util.Iterator;

/**
 * @Author: Eiaokiang
 * @Description:
 * @Date: Created in 16:24 2023/4/12
 */
public class Queue<T> implements Iterable {

    private Node head;
    private Node last;
    private int N;

    public Queue() {
        head = new Node(null,null);
        last = null;
        N = 0;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return N==0;
    }
    //返回队列中元素的个数
    public int size(){
        return N;
    }

    public void enqueue(T t){

        if (last == null){
            Node newNode = new Node(t, null);
            last = newNode;
            head.next = last;
        }else {
            Node pre = last;
            Node newNode = new Node(t, null);
            pre.next = newNode;
            last =newNode;
        }

        N++;
    }


    public T dequeue(){

        if (isEmpty()){
            return null;
        }

        Node curr = head.next;
        head.next = curr.next;

        if (isEmpty()){
            last = null;
        }

        N--;

        return (T) curr.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }
    private class QIterator implements Iterator<T>{
        private Node n = head;
        @Override
        public boolean hasNext() {
            return n.next!=null;
        }
        @Override
        public T next() {
            Node node = n.next;
            n = n.next;
            return (T) node.item;
        }
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");

        for (Object o : queue) {
            System.out.println(o);
        }

        System.out.println("----------");

        queue.dequeue();
        for (Object o : queue) {
            System.out.println(o);
        }

    }

}
