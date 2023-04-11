package linearList.linkList;

/**
 * @Author: Eiaokiang
 * @Description:
 * @Date: Created in 17:16 2023/4/11
 */
public class LinkList<T> {

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

    public void insert(T t){
        Node n = head;
        while (n.next != null){
            n = n.next;
        }
        n.next = new Node(t,null);
        N++;
    }

    public void insert(int i,T t){
        Node pre = head;
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



    public static void main(String[] args) {
        LinkList<String> linkList = new LinkList<String>();
        linkList.insert("a");

    }
}
