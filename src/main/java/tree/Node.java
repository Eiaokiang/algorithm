package tree;

/**
 * @Author: Eiaokiang
 * @Description:
 * @Date: Created in 16:16 2023/4/13
 */
public class Node<Key,Value> {

     Key key;
     Value value;
     Node left;
     Node right;

    public Node(Key key, Value value, Node left, Node right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
