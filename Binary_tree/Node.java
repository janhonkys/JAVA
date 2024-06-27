package DSA_projekt_GIT;

public class Node {
    private int value;
    private Node left;
    private Node right;

    // Constructor
    public Node(int value) {
        this.value = value;
    }

    // Getter and setter for the value of the node
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // Getter and setter for the left child of the node
    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    // Getter and setter for the right child of the node
    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
