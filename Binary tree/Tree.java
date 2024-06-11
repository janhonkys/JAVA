package DSA_projekt_GITnew;

public class Tree {
    private Node root;
    public Tree() {
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void addNode(int value) {
        Node newNode = new Node(value);
        if(root == null){
            root = newNode;
            return;
        }

        Node tmp = root;
        while(true){
            if(tmp.getValue() == value){
                return;
            }
            if(tmp.getValue() > value){
                if(tmp.getLeft() == null){
                    tmp.setLeft(newNode);
                    return;
                }else{
                    tmp = tmp.getLeft();
                }
            }else{
                if(tmp.getRight() == null){
                    tmp.setRight(newNode);
                    return;
                }else{
                    tmp = tmp.getRight();
                }
            }
        }
    }


    public boolean contains(int value){
        if(root == null){
            return false;
        }
        Node tmp = root;
        while(true){
            if(tmp.getValue() == value){
                return true;
            }else{
                if(tmp.getValue() > value){
                    if(tmp.getLeft() != null){
                        tmp = tmp.getLeft();
                    }else{
                        return false;
                    }
                }else{
                    if(tmp.getRight() != null){
                        tmp = tmp.getRight();
                    }else{
                        return false;
                    }
                }
            }
        }
    }

    
    public void printLeafs(){
        printLeafs(root);
    }

    private void printLeafs(Node tmp) {
        if(tmp == null){
            return;
        }else{
            if((tmp.getLeft() == null) && (tmp.getRight() == null)){
                System.out.print(tmp.getValue()+" ");
            }else{
                printLeafs(tmp.getLeft());
                printLeafs(tmp.getRight());
            }
        }
    }

    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getValue() + " ");
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeft());
        System.out.print(node.getValue() + " ");
        inOrder(node.getRight());
    }

    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.print(node.getValue() + " ");
    }

    public void leftmost() {
        Node tmp = root;
        int depth = 0;
        if (root == null) {
            return;
        }
        while ((tmp.getLeft() != null) || (tmp.getRight() != null)) {
            if (tmp.getLeft() != null) {
                tmp = tmp.getLeft();
                depth++;
            } else if (tmp.getRight() != null) {
                tmp = tmp.getRight();
                depth++;
            }
        }
        System.out.println("Leftmost node: " + tmp.getValue() +" and is in depth: "+depth);
    }

    public void rightmost() {
        Node tmp = root;
        int depth = 0;
        if (root == null) {
            return;
        }
        while ((tmp.getRight() != null) || (tmp.getLeft() != null)) {
            if (tmp.getRight() != null) {
                tmp = tmp.getRight();
                depth++;
            } else if (tmp.getLeft() != null) {
                tmp = tmp.getLeft();
                depth++;
            }
        }
        System.out.println("Rightmost node: " + tmp.getValue() +" and is in depth: "+depth);
    }

    public int sumAll() {
        return sumAll(root);
    }

    private int sumAll(Node node) {
        if(node == null){
            return 0;
        }
        int sum = node.getValue();
        sum += sumAll(node.getLeft());
        sum += sumAll(node.getRight());
        return sum;
    }

    public int sumLeafs() {
        return sumLeafs(root);
    }

    private int sumLeafs(Node node) {
        if(node == null){
            return 0;
        }
        int sum = 0;
        if (node.getLeft() == null && node.getRight() == null) {
            sum = node.getValue();
        }
        sum += sumLeafs(node.getLeft());
        sum += sumLeafs(node.getRight());
        return sum;
    }

    public int sumInner() {
        return sumInner(root);
    }

    private int sumInner(Node node) {
        if (node == null) {
            return 0;
        }
        int sum = 0;
        if ((node != root) && (node.getLeft() != null || node.getRight() != null)) {
            sum = node.getValue();
        }
        sum += sumInner(node.getLeft());
        sum += sumInner(node.getRight());
        return sum;
    }

    public String nodeInDepth(int depthv) {
        if (root == null) {
            return "";
        }
        int tmpdepth = 1;
        String s = nodeInDepth(root, tmpdepth, depthv);
        return s;
    }

    private String nodeInDepth(Node node, int tmpdepth, int depth) {
        String s = "";
        if (tmpdepth == depth) {
            s = node.getValue() + " ";
        } else {
            if (node.getLeft() != null) {
                s += nodeInDepth(node.getLeft(), tmpdepth+1, depth);
            }
            if (node.getRight() != null) {
                s += nodeInDepth(node.getRight(), tmpdepth+1, depth);
            }
        }
        return s;
    }
}
