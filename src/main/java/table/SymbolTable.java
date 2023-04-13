package table;

/**
 * @Author: Eiaokiang
 * @Description:
 * @Date: Created in 14:06 2023/4/13
 */

/**
 * 符号表
 */
public class SymbolTable<Key, Value>  {

    private Node head;

    private int N;

    public SymbolTable() {
        head = new Node(null, null, null);
        N = 0;
    }


    public void put(Key key, Value value) {
        //遍历是否存在
        Node n = head;
        while (n.next != null) {
            n = n.next;
            if (n.key.equals(key)) {
                n.value = value;
                return;
            }
        }

        Node oldNext = head.next;
        Node newNode = new Node(key, value, oldNext);
        head.next = newNode;

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
        SymbolTable<String, Integer> table = new SymbolTable<>();
        table.put("a",1);
        table.put("b",2);
        table.put("c",3);

        System.out.println(table.get(""));

        table.delete("a");
        System.out.println(table.get("a"));
        System.out.println(String.valueOf(table.size()));

    }
}
