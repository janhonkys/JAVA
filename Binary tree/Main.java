package DSA_projekt_GITnew;

public class Main {
    public static void main(String[] args) {

        //Create and add nodes to tree
        Tree binaryTree = new Tree();
        binaryTree.add(10);
        binaryTree.add(8);
        binaryTree.add(7);
        binaryTree.add(9);
        binaryTree.add(12);
        binaryTree.add(11);
        binaryTree.add(13);

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
