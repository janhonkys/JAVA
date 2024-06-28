package DSA_projekt_GIT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NodeTest {

    private Node node;

    // Before each test, create a new Node instance with value 10
    @BeforeEach
    void setup() {
        node = new Node(10);
    }

    // Test the constructor and getValue() method
    @Test
    void testConstructorAndGetter() {
        assertEquals(10, node.getValue(), "Value of node should be 10");
    }

    // Test the setValue() method
    @Test
    void testSetValue() {
        node.setValue(25);
        assertEquals(25, node.getValue(), "Value of node should be updated to 25");
    }

    // Test setting left and right children using setLeft() and setRight() methods
    @Test
    void testSetLeftAndSetRight() {
        Node nodeLeft = new Node(5);
        Node nodeRight = new Node(15);

        node.setLeft(nodeLeft);
        node.setRight(nodeRight);

        assertEquals(5, node.getLeft().getValue(), "Value of left child node should be 5");
        assertEquals(15, node.getRight().getValue(), "Value of right child node should be 15");
    }

    // Test setting left and right children to null using setLeft() and setRight() methods
    @Test
    void testSetLeftAndRightToNull() {
        node.setLeft(null);
        node.setRight(null);

        assertNull(node.getLeft(), "Left child should be set to null");
        assertNull(node.getRight(), "Right child should be set to null");
    }
}
