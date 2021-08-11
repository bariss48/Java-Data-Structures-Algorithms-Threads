package DataStructures.Trees;

public class BinaryTree {


    class Node {

        public int data;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value) {
            data = value;
            left = null;
            right = null;
            parent = null;
        }
    }

    private Node root;

    public BinaryTree() {
        root = null;
    }

    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (key < current.data) {
                if (current.left == null)
                    return current;
                current = current.left;
            } else if (key > current.data) {
                if (current.right == null)
                    return current;
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    public void put(int value) {
        Node newNode = new Node(value);
        if (root == null)
            root = newNode;
        else {
            Node parent = find(value);
            if (value < parent.data) {
                parent.left = newNode;
                parent.left.parent = parent;
                return;
            } else {
                parent.right = newNode;
                parent.right.parent = parent;
                return;
            }
        }
    }

    public boolean remove(int value) {
        Node temp = find(value);
        if (temp.data != value)
            return false;
        if (temp.right == null && temp.left == null) {
            if (temp == root)
                root = null;
            else if (temp.parent.data < temp.data)
                temp.parent.right = null;
            else
                temp.parent.left = null;
            return true;
        }
        else if (temp.left != null && temp.right != null) {
            Node successor = findSuccessor(temp);

            successor.left = temp.left;
            successor.left.parent = successor;

            if (successor.right != null && successor.parent != temp) {
                successor.right.parent = successor.parent;
                successor.parent.left = successor.right;
                successor.right = temp.right;
                successor.right.parent = successor;
            }
            if (temp == root) {
                successor.parent = null;
                root = successor;
                return true;
            }
            else {
                successor.parent = temp.parent;

                if (temp.parent.data < temp.data)
                    temp.parent.right = successor;
                else
                    temp.parent.left = successor;
                return true;
            }
        }
        else {
            if (temp.right != null) {
                if (temp == root) {
                    root = temp.right;
                    return true;
                }
                temp.right.parent = temp.parent;
                if (temp.data < temp.parent.data)
                    temp.parent.left = temp.right;
                else
                    temp.parent.right = temp.right;
                return true;
            }
            else {
                if (temp == root) {
                    root = temp.left;
                    return true;
                }
                temp.left.parent = temp.parent;
                if (temp.data < temp.parent.data)
                    temp.parent.left = temp.left;
                else
                    temp.parent.right = temp.left;
                return true;
            }
        }
    }


    public Node findSuccessor(Node n) {
        if (n.right == null)
            return n;
        Node current = n.right;
        Node parent = n.right;
        while (current != null) {
            parent = current;
            current = current.left;
        }
        return parent;
    }

    public Node getRoot() {
        return root;
    }

    public void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.left);
            System.out.print(localRoot.data + " ");
            inOrder(localRoot.right);
        }
    }

    public void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.data + " ");
            preOrder(localRoot.left);
            preOrder(localRoot.right);
        }
    }

    public void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.left);
            postOrder(localRoot.right);
            System.out.print(localRoot.data + " ");
        }
    }
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.put(45);
        tree.put(35);
        tree.put(25);
        tree.put(15);
        tree.put(100);
        System.out.println("PREORDER");
        tree.preOrder(tree.root);
        System.out.println();
        System.out.println("INORDER");
        tree.inOrder(tree.root);
        System.out.println();
        System.out.println("POSTORDER");
        tree.postOrder(tree.root);
        System.out.println();
        System.out.println("Datası 45 olan Node'un sağındaki Node'un Datası:");
        System.out.println(tree.find(45).right.data);
        tree.remove(15);
        System.out.println(tree.root.right.data);
    }

}

