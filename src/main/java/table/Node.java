package table;

/**
 * @Author: Eiaokiang
 * @Description:
 * @Date: Created in 14:20 2023/4/13
 */
public class Node<Key,Value> {

    public Key key;
    public Value value;
    public Node next;

    public Node(Key key, Value value,Node next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
