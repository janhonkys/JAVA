package DSA_projekt_GITnew;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


// Test class for the Tree class
class TreeTest {

    private Tree binaryTree;

    // Before each test
    @BeforeEach
    void setUp() {
        // Create a new tree before each test
        binaryTree = new Tree();
        // Add nodes to the binary tree
        binaryTree.addNode(10);
        binaryTree.addNode(8);
        binaryTree.addNode(7);
        binaryTree.addNode(9);
        binaryTree.addNode(12);
        binaryTree.addNode(11);
        binaryTree.addNode(13);
    }

    // Test method for the addNode() function of the Tree class
    @Test
    void testAddNode() {
        // Add a duplicate node
        binaryTree.addNode(13);

        // Check if the tree contains the added nodes
        assertTrue(binaryTree.contains(10));
        assertTrue(binaryTree.contains(8));
        assertTrue(binaryTree.contains(7));
        assertTrue(binaryTree.contains(9));
        assertTrue(binaryTree.contains(12));
        assertTrue(binaryTree.contains(11));
        assertTrue(binaryTree.contains(13));
        assertFalse(binaryTree.contains(14)); // Value is not in the tree
        assertFalse(binaryTree.contains(6));  // Value is not in the tree
    }

    // Test method for the contains() function of the Tree class
    @Test
    void testContains() {
        assertFalse(binaryTree.contains(5));  // Value is not in the tree

        binaryTree.addNode(5);  // Adding a new node
        assertTrue(binaryTree.contains(5)); // Value added to the tree

        assertFalse(binaryTree.contains(15)); // Value is not in the tree
    }

    // Test method for the sumAll() function of the Tree class
    @Test
    void testSumAll() {
        // Check if the sum of all nodes matches the expected sum
        assertEquals(70, binaryTree.sumAll(), "Sum of nodes should be 70");
    }

    // Test method for the sumInner() function of the Tree class
    @Test
    void testSumInner() {
        // Check if the sum of inner nodes matches the expected sum
        assertEquals(20, binaryTree.sumInner(), "Sum of inner nodes should be 20");
    }

    // Test method for the sumLeafs() function of the Tree class
    @Test
    void testSumLeafs() {
        // Check if the sum of leaf nodes matches the expected sum
        assertEquals(40, binaryTree.sumLeafs(), "Sum of leaf nodes should be 40");
    }

    // Test method for verifying the value of the root node
    @Test
    void testRootValue() {
        // Check if the value of the root node matches the expected value
        assertEquals(10, binaryTree.getRoot().getValue(), "Value of root node should be 10");
    }
}
