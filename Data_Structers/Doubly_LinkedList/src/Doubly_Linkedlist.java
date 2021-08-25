public class Doubly_Linkedlist {
// head and tail for linkedlist
    Node head;
    Node tail;
    //constructer
    public Doubly_Linkedlist(){
        this.head = null;
        this.tail = null;
    }

    public void add_element_to_top(Node kutucuk){
        if(head == null){
            head = kutucuk;
            tail = kutucuk;
        }else{
            head.previous = kutucuk;
            kutucuk.next = head;
            head = kutucuk;
        }
    } 


    public void add_element_to_last(Node kutucuk){
       if (head == null){
           head = kutucuk;
           tail = kutucuk;
       }else {
           tail.next = kutucuk;
           kutucuk.next = null;
           kutucuk.previous = tail;
           tail = kutucuk;
       }
    }

    public void remove_top(){
        if(head.next == null){
            tail = null;
        }else{
            head.next.previous = null;
            head = head.next;
        }
    }

    public void remove_last(){
        if (head.next == null){
            tail = null;
        }else{
           tail.previous.next = null;
           tail = tail.previous;
        }
    }

    public void add_index(Node kutucuk,int index){
        if(index == 0){
            if(head != null) {
                kutucuk.next = head;
                head.next.previous = null;
                head = kutucuk;
            }else {
                System.out.println("linkedlist boş");
            }
        }else{
            Node gezen_kutucuk,temp;
            gezen_kutucuk = head;
            for (int i = 0; i <index-1 ; i++) {
                gezen_kutucuk = gezen_kutucuk.next;
            }
            temp = gezen_kutucuk.next;
            gezen_kutucuk.next = kutucuk;
            kutucuk.previous = gezen_kutucuk;
            kutucuk.next = temp;
        }
    }

    public void remove_index(int index){
            Node gezen_kutucuk, temp;
            gezen_kutucuk = head;
            for (int i = 0; i < index ; i++) {
                gezen_kutucuk = gezen_kutucuk.next;
            }
            temp = gezen_kutucuk.next;
            gezen_kutucuk.previous.next = temp;
            gezen_kutucuk.next.previous = gezen_kutucuk.previous;
            gezen_kutucuk.next = null;
            gezen_kutucuk.previous = null;

    }

    public String print_list(){
        Node kutucuk;
        String valuelar = "";
        kutucuk = head;
        while (kutucuk != null){
            valuelar = valuelar + kutucuk.value +" " + "<-->" + " ";
            kutucuk = kutucuk.next;
        }
        return valuelar;
    }

    public static void main(String[] args) {
        Doubly_Linkedlist double_list = new Doubly_Linkedlist();
        Node kutucuk1 = new Node(25);
        Node kutucuk2 = new Node(15);
        Node kutucuk3 = new Node(35);
        Node kutucuk4 = new Node(45);
        Node kutucuk5 = new Node(55);
        Node kutucuk6 = new Node(65);
        Node kutucuk7 = new Node(75);
        Node kutucuk8 = new Node(78);
        Node kutucuk9 = new Node(95);
        Node kutucuk10 = new Node(85);
        double_list.add_element_to_top(kutucuk1);
        double_list.add_element_to_top(kutucuk2);
        double_list.add_element_to_last(kutucuk3);
        double_list.add_element_to_last(kutucuk4);
        double_list.add_element_to_last(kutucuk5);
        double_list.add_index(kutucuk6,3);
        double_list.add_index(kutucuk7,2);
        double_list.remove_top();
        double_list.remove_last();
        double_list.remove_index(2);
        double_list.remove_index(1);
        double_list.add_element_to_top(kutucuk8);
        double_list.add_element_to_top(kutucuk9);
        double_list.add_element_to_top(kutucuk10);
        System.out.println(double_list.print_list()+"null");
    }
}
