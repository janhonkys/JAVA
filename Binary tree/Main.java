package DSA_projekt_GITnew;

public class Main {
    public static void main(String[] args) {

        //Create and add nodes to tree
        Tree binaryTree = new Tree();
        binaryTree.addNode(10);
        binaryTree.addNode(8);
        binaryTree.addNode(7);
        binaryTree.addNode(9);
        binaryTree.addNode(12);
        binaryTree.addNode(11);
        binaryTree.addNode(13);

        //Functions of binary tree (sum of nodes etc.)
        System.out.println("Sum of all nodes: " + binaryTree.sumAll());
        System.out.println("Sum of all leafs: " + binaryTree.sumLeafs());
        System.out.println("Sum of all inner nodes: " + binaryTree.sumInner());
        System.out.print("Nodes in depth 2: ");
        System.out.println(binaryTree.nodeInDepth(2));
        System.out.println("Is there a node with value 13 in the tree? " + binaryTree.contains(13));
        System.out.print("Leafs: ") ;
        binaryTree.printLeafs();

        System.out.println("");
        System.out.print("Preorder: ");
        binaryTree.preOrder();
        System.out.print("Inorder: ");
        binaryTree.inOrder();
        System.out.print("Postorder: ");
        binaryTree.postOrder();

        binaryTree.leftmost();
        binaryTree.rightmost();
    }
}
