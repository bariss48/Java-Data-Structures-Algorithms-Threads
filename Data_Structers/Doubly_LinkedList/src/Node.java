public class Node {

    Node next;
    Node previous;
    int value;

    public Node(){}

    public Node(int value){
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    public Node(Node next, Node previous, int value){
        this.next = next;
        this.previous = previous;
        this.value = value;
    }

}
