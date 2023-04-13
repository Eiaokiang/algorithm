package tree;

/**
 * @Author: Eiaokiang
 * @Description:
 * @Date: Created in 16:15 2023/4/13
 */
public class BinaryTree<Key extends Comparable,Value> {

    private Node root;

    private int N;


    public void put(Key key,Value value){
        root = put(root,key,value);
    }

    public int size(){
        return N;
    }

    private Node put(Node x,Key key,Value value){
        //根节点为空
        if (x == null){
            N++;
            return new Node(key,value,null,null);
        }

        int cmp = key.compareTo(x.key);
        if (cmp > 0){
            //新节点key大于当前节点，找当前节点右节点
            x.right = put(x.right,key,value);
        }else if (cmp < 0){
            //新节点key小于当前节点，找当前节点左节点
            x.left = put(x.left,key,value);
        }else {
            //值相同
            x.value = value;
        }
        return x;
    }

    public Value get(Key key){
        return get(root,key);
    }

    private Value get(Node x,Key key){
        if (x == null){
            return null;
        }

        int cmp = key.compareTo(x.key);

        if (cmp > 0){
            return get(x.right,key);
        }else if(cmp < 0){
            return get(x.left,key);
        }else {
            return (Value) x.value;
        }
    }

    public void delete(Key key){
        root = delete(root,key);
    }

    private Node delete(Node x,Key key){
        if (x == null){
            return null;
        }

        int cmp = key.compareTo(x.key);

        if (cmp > 0){
            //大于当前节点，返回一个节点连接到当前节点的右边
            x.right = delete(x.right,key);
        }else if(cmp < 0){
            //小于当前节点，返回一个节点连接到当前节点的左边
            x.left =delete(x.left,key);
        }else {
            //相等 则x刚好是要删除的节点，以下为真正删除动作

            //x的右节点不存在，直接返回左节点给上级连接
            if (x.right == null){
                return x.left;
            }

            //x的右节点不存在，直接返回左节点给上级连接
            if (x.left == null){
                return x.right;
            }



            //左右子树都存在，找右子树中最小的节店
            //（因为右子树节点都大于当前节点，找到最小的那个就是刚好的）
            Node minNode =x.right;
            while (minNode.left != null){
                minNode= minNode.left;
            }

            //删除右子树最小节点
            Node n = x.right;
            while (n.left != null){
                if (n.left.left == null){
                    n.left = null;
                }else {
                    n = n.left;
                }
            }


            //将当前节点的左右分配给右子树最小节点
            minNode.left = x.left;
            minNode.right = x.right;

            //用于被删除节点指的父节点连接。  右子树最小节点代替当前被删除节点返回
            x = minNode;

            N--;
        }

        return x;
    }

    public static void main(String[] args) {
        BinaryTree<Integer, String> tree = new BinaryTree<>();
        tree.put(4,"a");
        tree.put(6,"b");
        tree.put(2,"e");
        tree.put(1,"c");
        tree.put(5,"d");

        System.out.println(tree.get(5));
    }

}
