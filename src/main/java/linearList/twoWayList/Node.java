package linearList.twoWayList;

/**
 * @Author: Eiaokiang
 * @Description:
 * @Date: Created in 10:50 2023/4/12
 */
public class Node<T> {

    public T item;

    public Node pre;

    public Node next;

    public Node(T item, Node pre, Node next) {
        this.item = item;
        this.pre = pre;
        this.next = next;
    }

}
