package tree;


import linearList.queue.Queue;

/**
 * @Author: Eiaokiang
 * @Description:
 * @Date: Created in 16:15 2023/4/13
 */
public class BinaryTree<Key extends Comparable, Value> {

    private Node root;

    private int N;


    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    public int size() {
        return N;
    }

    private Node put(Node x, Key key, Value value) {
        //根节点为空
        if (x == null) {
            N++;
            return new Node(key, value, null, null);
        }

        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            //新节点key大于当前节点，找当前节点右节点
            x.right = put(x.right, key, value);
        } else if (cmp < 0) {
            //新节点key小于当前节点，找当前节点左节点
            x.left = put(x.left, key, value);
        } else {
            //值相同
            x.value = value;
        }
        return x;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);

        if (cmp > 0) {
            return get(x.right, key);
        } else if (cmp < 0) {
            return get(x.left, key);
        } else {
            return (Value) x.value;
        }
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);

        if (cmp > 0) {
            //大于当前节点，返回一个节点连接到当前节点的右边
            x.right = delete(x.right, key);
        } else if (cmp < 0) {
            //小于当前节点，返回一个节点连接到当前节点的左边
            x.left = delete(x.left, key);
        } else {
            //相等 则x刚好是要删除的节点，以下为真正删除动作

            //x的右节点不存在，直接返回左节点给上级连接
            if (x.right == null) {
                return x.left;
            }

            //x的右节点不存在，直接返回左节点给上级连接
            if (x.left == null) {
                return x.right;
            }


            //左右子树都存在，找右子树中最小的节店
            //（因为右子树节点都大于当前节点，找到最小的那个就是刚好的）
            Node minNode = x.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }

            //删除右子树最小节点
            Node n = x.right;
            while (n.left != null) {
                if (n.left.left == null) {
                    n.left = null;
                } else {
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


    /**
     * 前序遍历 （根左右）
     *
     * @return
     */
    public Queue<Key> preErgodic() {
        Queue<Key> keys = new Queue<Key>();
        preErgodic(root, keys);
        return keys;
    }

    private void preErgodic(Node x, Queue key) {
        if (x == null) {
            return;
        }

        //当前节点放入队列
        key.enqueue(x.key);
        //左节点不为空则递归
        if (x.left != null) {
            preErgodic(x.left, key);
        }
        //右节点不为空则递归
        if (x.right != null) {
            preErgodic(x.right, key);
        }
    }

    /**
     * 中序遍历 （左根右）
     *
     * @return
     */
    public Queue<Key> midErgodic() {
        Queue<Key> keys = new Queue<Key>();
        midErgodic(root, keys);
        return keys;
    }

    private void midErgodic(Node x, Queue key) {
        if (x == null) {
            return;
        }

        //左节点不为空则递归
        if (x.left != null) {
            midErgodic(x.left, key);
        }
        //当前节点放入队列
        key.enqueue(x.key);
        //右节点不为空则递归
        if (x.right != null) {
            midErgodic(x.right, key);
        }
    }


    /**
     * 后序遍历 （左右根）
     *
     * @return
     */
    public Queue<Key> afterErgodic() {
        Queue<Key> keys = new Queue<Key>();
        afterErgodic(root, keys);
        return keys;
    }

    private void afterErgodic(Node x, Queue key) {
        if (x == null) {
            return;
        }

        //左节点不为空则递归
        if (x.left != null) {
            afterErgodic(x.left, key);
        }
        //右节点不为空则递归
        if (x.right != null) {
            afterErgodic(x.right, key);
        }
        //当前节点放入队列
        key.enqueue(x.key);
    }


    /**
     * 层序遍历（就是从根节点（第一层）开始，依次向下，获取每一层所有结点的值）
     */
    public Queue<Key> layerErgodic() throws InterruptedException {
        Queue<Key> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();
        nodes.enqueue(root);
        while (!nodes.isEmpty()) {
            Node x = nodes.dequeue();
            keys.enqueue((Key) x.key);
            if (x.left != null) {
                nodes.enqueue(x.left);
            }
            if (x.right != null) {
                nodes.enqueue(x.right);
            }
        }
        return keys;
    }


    /*
    最大深度
     */
    public int maxDepth() {
        return maxDepth(root);
    }

    public int maxDepth(Node x) {
        //根节点为空
        if (x == null) {
            return 0;
        }

        int max = 0;
        int maxL = 0;
        int maxR = 0;

        //计算左子树最大深度
        if (x.left != null) {
            maxL = maxDepth(x.left);
        }

        //计算右子树最大深度
        if (x.right != null) {
            maxR = maxDepth(x.right);
        }

        //.当前树的最大深度=左子树的最大深度和右子树的最大深度中的较大者+1 (根节点的1)
        max = maxL > maxR ? maxL + 1 : maxR + 1;
        return max;
    }


    public static void main(String[] args) throws InterruptedException {
        BinaryTree<String, String> tree = new BinaryTree<>();
        tree.put("E", "5");
        tree.put("B", "2");
        tree.put("G", "7");
        tree.put("A", "1");
        tree.put("D", "4");
        tree.put("F", "6");
        tree.put("H", "8");
        tree.put("C", "3");

        int i = tree.maxDepth();
        System.out.println(i);
    }

}
