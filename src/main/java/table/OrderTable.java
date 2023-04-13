package table;

/**
 * @Author: Eiaokiang
 * @Description:
 * @Date: Created in 14:06 2023/4/13
 */

/**
 * 符号表
 */
public class OrderTable<Key extends Comparable, Value>  {

    private Node head;

    private int N;

    public OrderTable() {
        head = new Node(null, null, null);
        N = 0;
    }


    public void put(Key key, Value value) {
        Node pre = head;
        Node curr = head.next;


        while (curr!=null &&  key.compareTo(curr.key)>0){
            pre = curr;
            curr = curr.next;
        }


        if (curr!=null && key.compareTo(curr.key)==0){
            curr.value=value;
            return;
        }

        Node newNode = new Node(key, value, curr);
        pre.next = newNode;

        N++;
    }

    public Value get(Key key) {
        Node n = head;
        while (n.next != null) {
            n = n.next;
            if (n.key.equals(key)) {
                return (Value) n.value;
            }
        }

        return null;
    }


    public void delete(Key key) {
        Node pre = head;
        while (pre.next != null) {
            Node curr = pre.next;
            if (curr.key.equals(key)) {
                pre.next = curr.next;
                N--;
                return;
            }
            pre = pre.next;
        }
    }

    public int size(){
        return N;
    }

    public static void main(String[] args) {
        OrderTable<String, Integer> table = new OrderTable<>();
        table.put("a",1);
        table.put("b",2);
        table.put("c",3);

        System.out.println(table.get(""));

        table.delete("a");
        System.out.println(table.get("a"));
        System.out.println(String.valueOf(table.size()));

    }
}
