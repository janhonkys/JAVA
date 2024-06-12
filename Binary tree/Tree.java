package DSA_projekt_GITnew;

public class Tree {
    private Node root;

    // Constructor
    public Tree() {
    }

    // Getter and setter for root
    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    // Method to add a node to the tree
    public void addNode(int value) {
        // If the tree is empty, create a new node as the root
        if(root == null){
            root = new Node(value);
            return;
        }

        // Find the appropriate position for the new node in the tree
        Node tmp = root;
        while(true){
            // If the value already exists in the tree, do not insert duplicates
            if(tmp.getValue() == value){
                return;
            }
            // Decide whether to move left or right based on the value of the current node
            if(tmp.getValue() > value){
                // Go left
                if(tmp.getLeft() == null){
                    // If the left child is null, insert the new node here
                    tmp.setLeft(new Node(value));
                    return;
                }else{
                    // Continue to the left side
                    tmp = tmp.getLeft();
                }
            }else{
                // Go right
                if(tmp.getRight() == null){
                    // If the right child is null, insert the new node here
                    tmp.setRight(new Node(value));
                    return;
                }else{
                    // Continue to the right side
                    tmp = tmp.getRight();
                }
            }
        }
    }

    // Method to check if the tree contains a given value
    public boolean contains(int value){
        // If the tree is empty, the value cannot be found
        if(root == null){
            return false;
        }

        // Start the search from the root node
        Node tmp = root;
        while(true){
            // If the current node's value matches the search value, return true
            if(tmp.getValue() == value){
                return true;
            }else{
                // If the search value is less than the current node's value, move to the left subtree
                if(tmp.getValue() > value){
                    // If a left child exists, continue the search. Otherwise, the value is not in tree.
                    if(tmp.getLeft() != null){
                        tmp = tmp.getLeft();
                    }else{
                        return false;
                    }
                }else{
                    // If the search value is greater than the current node's value, move to the right subtree
                    // If a right child exists, continue the search. Otherwise, the value is not in tree.
                    if(tmp.getRight() != null){
                        tmp = tmp.getRight();
                    }else{
                        return false;
                    }
                }
            }
        }
    }

    // Method to print the leaf nodes of the tree
    public void printLeafs(){
        // Start printing leaf nodes from the root of the tree
        printLeafs(root);
    }

    // Recursive helper method to print leaf nodes starting from the given node
    private void printLeafs(Node tmp) {
        // If the current node is null, return
        if(tmp == null){
            return;
        }

        // If the current node is a leaf node, print value
        if((tmp.getLeft() == null) && (tmp.getRight() == null)){
            System.out.print(tmp.getValue()+" ");
        }else{
            // If the current node is not a leaf node, recursively call printLeafs on its left and right children
            printLeafs(tmp.getLeft());
            printLeafs(tmp.getRight());
        }
    }

    // Method to perform a pre-order traversal of the tree
    public void preOrder() {
        // Start the pre-order traversal from the root of the tree
        preOrder(root);
        System.out.println();
    }

    // Recursive helper method to perform pre-order traversal starting from the given node
    private void preOrder(Node node) {
        // If the current node is null, return
        if (node == null) {
            return;
        }
        // Print the value of the current node
        System.out.print(node.getValue() + " ");
        // Recursively traverse the left subtree in pre-order
        preOrder(node.getLeft());
        // Recursively traverse the right subtree in pre-order
        preOrder(node.getRight());
    }

    // Method to perform an in-order traversal of the tree
    public void inOrder() {
        // Start the in-order traversal from the root of the tree
        inOrder(root);
        System.out.println();
    }

    // Recursive helper method to perform in-order traversal starting from the given node
    private void inOrder(Node node) {
        // If the current node is null, return
        if (node == null) {
            return;
        }
        // Recursively traverse the left subtree in in-order
        inOrder(node.getLeft());
        // Print the value of the current node
        System.out.print(node.getValue() + " ");
        // Recursively traverse the right subtree in in-order
        inOrder(node.getRight());
    }


    // Method to perform a post-order traversal of the tree
    public void postOrder() {
        // Start the post-order traversal from the root of the tree
        postOrder(root);
        System.out.println();
    }

    // Recursive helper method to perform post-order traversal starting from the given node
    private void postOrder(Node node) {
        // If the current node is null, return
        if (node == null) {
            return;
        }
        // Recursively traverse the left subtree in post-order
        postOrder(node.getLeft());
        // Recursively traverse the right subtree in post-order
        postOrder(node.getRight());
        // Print the value of the current node
        System.out.print(node.getValue() + " ");
    }

    // Method to find and print the leftmost node in the tree along with its depth
    public void leftmost() {
        // Start the search from the root node
        Node tmp = root;
        // Initialize the depth counter
        int depth = 0;
        // If the tree is empty, there is no leftmost node
        if (root == null) {
            return;
        }
        // Traverse down the tree until reaching the leftmost node
        while ((tmp.getLeft() != null) || (tmp.getRight() != null)) {
            // Move to the left child if it exists and increment the depth
            if (tmp.getLeft() != null) {
                tmp = tmp.getLeft();
                depth++;
                // Move to the right child if the left child doesn't exist and increment the depth
            } else if (tmp.getRight() != null) {
                tmp = tmp.getRight();
                depth++;
            }
        }
        // Print the value and depth of the leftmost node
        System.out.println("Leftmost node: " + tmp.getValue() +" and is in depth: "+depth);
    }

    // Method to find and print the rightmost node in the tree along with its depth
    public void rightmost() {
        // Start the search from the root node
        Node tmp = root;
        // Initialize the depth counter
        int depth = 0;
        // If the tree is empty, there is no rightmost node
        if (root == null) {
            return;
        }
        // Traverse down the tree until reaching the rightmost node
        while ((tmp.getRight() != null) || (tmp.getLeft() != null)) {
            // Move to the right child if it exists and increment the depth
            if (tmp.getRight() != null) {
                tmp = tmp.getRight();
                depth++;
                // Move to the left child if the right child doesn't exist and increment the depth
            } else if (tmp.getLeft() != null) {
                tmp = tmp.getLeft();
                depth++;
            }
        }
        // Print the value and depth of the rightmost node
        System.out.println("Rightmost node: " + tmp.getValue() +" and is in depth: "+depth);
    }

    // Method to calculate the sum of all nodes in the tree
    public int sumAll() {
        // Start the summation from the root node
        return sumAll(root);
    }

    // Recursive method to calculate the sum of all nodes starting from the given node
    private int sumAll(Node node) {
        // If the current node is null, return 0
        if(node == null){
            return 0;
        }
        // Calculate the sum of the current node's value and the sums of its left and right subtrees recursively
        int sum = node.getValue();
        sum += sumAll(node.getLeft());
        sum += sumAll(node.getRight());
        return sum;
    }


    // Method to calculate the sum of values of all leaf nodes in the tree
    public int sumLeafs() {
        // Start the summation from the root node
        return sumLeafs(root);
    }

    // Recursive helper method to calculate the sum of values of all leaf nodes starting from the given node
    private int sumLeafs(Node node) {
        // If the current node is null, return 0
        if(node == null){
            return 0;
        }
        // Initialize sum to 0
        int sum = 0;
        // If the current node is a leaf node, add its value to the sum
        if (node.getLeft() == null && node.getRight() == null) {
            sum = node.getValue();
        }
        // Recursively calculate the sum of leaf nodes in the left and right subtrees
        sum += sumLeafs(node.getLeft());
        sum += sumLeafs(node.getRight());
        return sum;
    }

    // Method to calculate the sum of values of all inner nodes in the tree
    public int sumInner() {
        // Start the summation from the root node
        return sumInner(root);
    }

    // Recursive helper method to calculate the sum of values of all inner nodes starting from the given node
    private int sumInner(Node node) {
        // If the current node is null, return 0
        if (node == null) {
            return 0;
        }
        // Initialize sum to 0
        int sum = 0;
        // If the current node is not the root and has at least one child, add its value to the sum
        if ((node != root) && (node.getLeft() != null || node.getRight() != null)) {
            sum = node.getValue();
        }
        // Recursively calculate the sum of inner nodes in the left and right subtrees
        sum += sumInner(node.getLeft());
        sum += sumInner(node.getRight());
        return sum;
    }

    // Method to find and return the values of nodes at a specific depth in the tree
    public String nodeInDepth(int depth) {
        // If the tree is empty, return an empty string
        if (root == null) {
            return "";
        }
        // Start the depth traversal from depth 1
        int tmpDepth = 1;
        // Call the recursive helper method to find nodes at the specified depth
        String s = nodeInDepth(root, tmpDepth, depth);
        return s;
    }

    // Recursive helper method to find nodes at the specified depth starting from the given node
    private String nodeInDepth(Node node, int tmpDepth, int depth) {
        // Initialize an empty string to store the values of nodes at the specified depth
        String s = "";
        // If the current depth matches the specified depth, add the value of the current node to the result string
        if (tmpDepth == depth) {
            s = node.getValue() + " ";
        } else {
            // If the current depth does not match the specified depth, recursively explore the left and right subtrees
            if (node.getLeft() != null) {
                s += nodeInDepth(node.getLeft(), tmpDepth + 1, depth);
            }
            if (node.getRight() != null) {
                s += nodeInDepth(node.getRight(), tmpDepth + 1, depth);
            }
        }
        return s;
    }
}
