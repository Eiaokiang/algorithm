package tree;

/**
 * @Author: Eiaokiang
 * @Description:
 * @Date: Created in 18:17 2023/4/13
 */
public class BinaryTree2<Key extends Comparable,Value> {

    private Node root;

    private int N;


    public void put(Key key,Value value){
        root = put(root,key,value);
    }

    private Node put(Node x,Key key,Value value){
        if (x == null){
            N++;
            return new Node(key,value,null,null);
        }

        return null;
    }

}
