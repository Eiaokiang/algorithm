package linearList.queue;

/**
 * @Author: Eiaokiang
 * @Description:
 * @Date: Created in 17:26 2023/4/11
 */
public class Node<T> {

    public T item;

    public Node next;

    public Node(T item, Node next) {
        this.item = item;
        this.next = next;
    }
}
