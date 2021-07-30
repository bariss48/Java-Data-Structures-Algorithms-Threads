public class LinkedList {
	
   // Author ßaris Kara 30.07.2021
   
    Node tail;
    Node head;

    public LinkedList() {
        this.tail = null;
        this.head = null;
    }

    public void add_to_linkedlist(Node kutucuk){
        if(head == null) {
            head = kutucuk;
            tail = kutucuk;
        }else{
            kutucuk.next = head;
            head = kutucuk;
        }
    }

    public void add_tail(Node kutucuk){
        if(head == null){
            head = kutucuk;
            tail = kutucuk;
        }else{
            tail.next = kutucuk;
            tail = kutucuk;
        }
    }

    public void add_index(Node kutucuk,int index){
        Node gezen_kutum;
        if(head != null){
            gezen_kutum = head;
            for (int i = 0; i <index-1 ; i++) {
                if (gezen_kutum.next != null) {
                    gezen_kutum = gezen_kutum.next;
                }
            }
            Node temp;
            temp = gezen_kutum.next;
            gezen_kutum.next = kutucuk;
            kutucuk.next = temp;
        }else{
            System.out.println("Malesef linkedlist boş olduğu için eklenemedi!");
        }
    }

    public void last_element_delete(){
        Node gezen_kutucuk , arkadan_gelen_kutu;
        if (head == tail){
            head = null;
            tail = null;
        }else if(head != null){
            gezen_kutucuk = head;
            arkadan_gelen_kutu = null;
            while (gezen_kutucuk.next != null){
                arkadan_gelen_kutu = gezen_kutucuk;
                gezen_kutucuk = gezen_kutucuk.next;
            }
            arkadan_gelen_kutu.next = null;
            tail = arkadan_gelen_kutu;
        }
    }

    public void first_element_delete(){
        Node kutucuk;
        if(head.next == null){
            head = null;
        }else{
            kutucuk = head;
            kutucuk = kutucuk.next;
            head = kutucuk;
        }
    }

    public void index_delete(int index){
        Node gezen_kutucuk,arkadan_gelen_kutucuk;
        gezen_kutucuk = head;
        arkadan_gelen_kutucuk = null;
        if (index == 1 && head != null){
           head = null;
        }else {
            for (int i = 0; i < index - 1; i++) {
                if (gezen_kutucuk.next != null) {
                    arkadan_gelen_kutucuk = gezen_kutucuk;
                    gezen_kutucuk = gezen_kutucuk.next;
                }
                arkadan_gelen_kutucuk.next = gezen_kutucuk.next;
                gezen_kutucuk = null;
            }
        }
    }

    public String traversal_to_linkedlist(){
        Node kutucuk;
        String yazdir = "";
        kutucuk = head;
        while(kutucuk != null){
            yazdir = yazdir + (kutucuk.value) + ("-->");
            kutucuk = kutucuk.next;
        }
        return yazdir;
    }

    public static void main(String[] args) {
        Node kutucuk1 = new Node(5);
        Node kutucuk2 = new Node(8);
        Node kutucuk3 = new Node(12);
        Node kutucuk4 = new Node(21);
        Node kutucuk5 = new Node(23);
        Node kutucuk6 = new Node(27);
        Node kutucuk7 = new Node(23);

        LinkedList list = new LinkedList();
        list.add_to_linkedlist(kutucuk1);
        list.add_to_linkedlist(kutucuk2);
        list.add_to_linkedlist(kutucuk3);
        list.add_tail(kutucuk4);
        list.add_tail(kutucuk5);
        list.add_index(kutucuk6,3);
        list.last_element_delete();
        list.last_element_delete();
        list.add_index(kutucuk7,4);
        list.first_element_delete();
        list.index_delete(2);
        list.index_delete(2);

        System.out.print(list.traversal_to_linkedlist()+"null");
    }







}
