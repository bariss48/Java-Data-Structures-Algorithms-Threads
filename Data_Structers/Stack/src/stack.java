public class stack {

    private int[] ar;
    private int pos = 0;

    public stack(int maxSize) {
        ar = new int[maxSize];
    }

    public int size() {
        return pos;
    }

    public boolean isEmpty() {
        return pos == 0;
    }

    public int peek() {
        return ar[pos - 1];
    }

    public void push(int value) {
        ar[pos++] = value;
    }

    public int pop() {
        return ar[--pos];
    }

    // Example usage
    public static void main(String[] args) {

        stack s = new stack(5);

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        System.out.println("|"+s.pop()+"|");
        System.out.println("|"+s.pop()+"|");
        System.out.println("|"+s.pop()+"|");

        s.push(3);
        s.push(4);
        s.push(5);

        while (!s.isEmpty()) System.out.println("|"+s.pop()+"|");

    }
}