package linearList.linkList;

import java.util.Iterator;

/**
 * @Author: Eiaokiang
 * @Description:
 * @Date: Created in 17:16 2023/4/11
 */

/**
 * 单向列表
 *
 * @param <T>
 */
public class LinkList<T> implements Iterable {

    private Node head;

    private int N;

    public LinkList() {
        head = new Node(null, null);
        N = 0;
    }

    public void clear() {
        head.item = null;
        head.next = null;
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int length() {
        return N;
    }

    public T get(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("位置不合法");
        }

        Node n = head.next;
        for (int index = 0; index < i; index++) {
            n = n.next;
        }

        return (T) n.item;
    }

    public void insert(T t) {
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = new Node(t, null);
        N++;
    }

    public void insert(int i, T t) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("位置不合法");
        }
        Node pre = head;
        //头节点不存数据只存节点，所以如果是在0插入也从要至少移动一次
        for (int j = 0; j <= i - 1; j++) {
            pre = pre.next;
        }

        //被挤到后面的节点
        Node curr = pre.next;

        //新节点后面接被挤节点
        Node newNode = new Node(t, curr);
        //前节点指向新节点
        pre.next = newNode;

        N++;

    }

    public T remove(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("位置不合法");
        }

        //找出该位置前一个节点
        Node pre = head;
        //头节点不存数据只存节点，所以如果是在0插入也从要至少移动一次
        for (int j = 0; j <= i - 1; j++) {
            pre = pre.next;
        }

        //该位置被remove前节点
        Node curr = pre.next;

        //前节点的下一个指向被remove的下一个
        pre.next = curr.next;


        N--;

        return (T) curr.item;
    }


    public int indexOf(T t) {
        Node n = head;
        for (int i = 0; n.next != null; i++) {
            n = n.next;
            if (n.item.equals(t)) {
                return i;
            }
        }
        return -1;
    }

    public void reverse() {
        if (N == 0) {
            return;
        }
        reverse(head.next);
    }

    /**
     * 链表反转
     *
     * @param curr
     * @return
     */
    private Node reverse(Node curr) {
        //到最后一个节点
        if (curr.next == null) {
            //最后一个节点变为头节点的下一个
            head.next = curr;
            return curr;
        } else {
            //不是最后一个节点，递归调用返回反转后的前一个节点
            Node pre = reverse(curr.next);

            pre.next = curr;
            curr.next = null;
            return curr;
        }
    }

    /**
     * 无环找中点值（快慢指针）
     */
    public static String getMid(Node first) {
        Node slow = first;
        Node fast = first;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return (String) slow.item;
    }

    /**
     * 单向链表是否有环
     */
    public static boolean isCircle(Node first) {
        Node fast = first;
        Node slow = first;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.equals(slow)) {
                return true;
            }
        }
        return false;
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
        Node<String> first = new Node<String>("aa", null);
        Node<String> second = new Node<String>("bb", null);
        Node<String> third = new Node<String>("cc", null);
        Node<String> fourth = new Node<String>("dd", null);
        Node<String> fifth = new Node<String>("ee", null);
        Node<String> six = new Node<String>("ff", null);
        Node<String> seven = new Node<String>("gg", null);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = seven;
        //查找中间值
        String mid = getMid(first);
        System.out.println("中间值为：" + mid);
        //循环列表最后节点指向头节点就行
        seven.next = first;
        //是否有环
        seven.next = second;
        System.out.println(isCircle(first));
        yosefu();

    }

    /**
     * 约瑟夫问题
     * 41人成环，123报数，报数为3退出
     */
    public static void yosefu() {

        Node first = null;
        Node pre = null;
        //构建循环链表
        for (int i = 1; i <= 41; i++) {
            if (i == 1) {
                first = new Node(i, null);
                pre = first;
                continue;
            }

            Node node = new Node(i, null);
            pre.next = node;

            pre = node;

            if (i == 41) {
                pre.next = first;
            }
        }

        //报数
        int count = 0;

        //3.遍历链表，每循环一次，count++
        Node<Integer> n = first;
        Node<Integer> before = null;
        while (n != n.next) {
            //4.判断count的值，如果是3，则从链表中删除这个结点并打印结点的值，把count重置为0；
            count++;
            if (count == 3) {
                //删除当前结点
                before.next = n.next;
                System.out.print(n.item + ",");
                count = 0;
                n = n.next;
            } else {
                before = n;
                n = n.next;
            }
        }
        /*打印剩余的最后那个人*/
        System.out.println(n.item);


    }
}
