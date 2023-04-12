package linearList.twoWayList;

import java.util.Iterator;

/**
 * @Author: Eiaokiang
 * @Description:
 * @Date: Created in 10:52 2023/4/12
 */
public class TwoWayList<T> implements Iterable{

    private Node head;
    private Node last;

    private int N;

    public TwoWayList() {
        head = new Node(null, null, null);
        last = null;
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int length() {
        return N;
    }

    public void clear() {
        head.item = null;
        head.next = null;
        head.pre = null;
        N = 0;
        last = null;
    }

    public void insert(T t) {
        //要双向赋值
        if (last == null) {
            Node newLast = new Node(t, head, null);
            head.next = newLast;
            last = newLast;
        } else {
            Node oldLast = last;
            Node newLast = new Node(t, oldLast, null);
            oldLast.next = newLast;
            last = newLast;
        }
        N++;
    }

    public void insert(int i, T t) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("位置不合法");
        }

        Node pre = head;
        for (int j = 0; j <= i; j++) {
            pre = pre.next;
        }

        Node curr = pre.next;

        Node newNode = new Node(t, pre, curr);
        pre.next = newNode;
        curr.pre = newNode;

        N++;
    }


    public T get(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("位置不合法");
        }

        Node n = head;
        for (int j = 0; j <= i; j++) {
            n = n.next;
        }

        return (T) n.item;
    }

    public int indexOf(T t){
        Node n = head;
        for (int i = 0; n.next!=null; i++) {
            n = n.next;
            if (n.item.equals(t)){
                return i;
            }
        }
        return -1;
    }

    public T remove(int i){
        if (i < 0 || i >= N) {
            throw new RuntimeException("位置不合法");
        }

        Node pre = head;
        for (int j = 0; j <= i; j++) {
            pre = pre.next;
        }

        Node curr = pre.next;

        Node currNext = curr.next;
        pre.next = currNext;
        currNext.pre = pre;

        N--;

        return (T) curr.item;
    }



    private class LIterator implements Iterator<T> {

        private Node n;
        public LIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public T next() {
            n = n.next;
            return (T) n.item;
        }

    }
    @Override
    public Iterator iterator() {
        return new LIterator();
    }

    public static void main(String[] args) {
        TwoWayList<String> twoWayList = new TwoWayList<>();
        twoWayList.insert("a");
        twoWayList.insert("b");
        twoWayList.insert("c");
        twoWayList.insert("d");

        System.out.println(twoWayList.indexOf("a"));

        for (Object o : twoWayList) {
            System.out.println(o);
        }
    }

}
