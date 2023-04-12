package linearList.stack;

import java.util.Iterator;

/**
 * @Author: Eiaokiang
 * @Description:
 * @Date: Created in 15:40 2023/4/12
 */
public class Stack<T> implements Iterable {

    //head永遠在第一個
    private Node head;
    private int N;

    public Stack() {
        head = new Node(null, null);
        N = 0;
    }

    public void push(T t) {
        Node old = head.next;
        Node newNode = new Node(t, old);
        head.next = newNode;
        N++;
    }

    public T pop() {
        Node popNode = head.next;
        if (popNode == null) {
            return null;
        }
        head.next = head.next.next;
        N--;

        return (T) popNode.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator<T> {
        private Node n = head;

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public T next() {
            Node node = n.next;
            n = n.next;
            return (T) node.item;
        }
    }

    public static boolean match(String str) {
        int right = 0;
        int left = 0;
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            char l = "(".toCharArray()[0];
            char r = ")".toCharArray()[0];
            if (l == aChar) {
                left++;
            }
            if (r == aChar) {
                right++;
            }
        }
        return right == left;
    }


    public static void main(String[] args) {
        //Stack<Integer> integerStack = new Stack<>();
        //integerStack.push(1);
        //integerStack.push(2);
        //integerStack.push(3);
        //
        //for (Object o : integerStack) {
        //    System.out.println(o);
        //}
        //
        //System.out.println("----------");
        //
        //integerStack.pop();
        //for (Object o : integerStack) {
        //    System.out.println(o);
        //}


        System.out.println(match("(上海)(长安)"));
        System.out.println(match("((上海)()()(长安))"));
        System.out.println(match("(上海()(长安)"));
        System.out.println(match("(上海)))(长安)"));
    }

}
