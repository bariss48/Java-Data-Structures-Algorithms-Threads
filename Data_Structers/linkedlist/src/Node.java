public class Node {
    int value;
    Node next;

    Node() {}

    public Node(int value) {
        this(value, null);
     }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
