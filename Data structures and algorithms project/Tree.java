package DSA_projekt;

public class Tree {
    private Uzel koren;

    public Tree() {
    }

    public Uzel getKoren() {
        return koren;
    }

    public void setKoren(Uzel koren) {
        this.koren = koren;
    }


//my custom code
//    public int secVsech(){
//        int sum = 0;
//        if(koren == null){
//            return 0;
//        }else{
//            sum += koren.getData();
//            sum += sumchil(koren);
//        }
//        return sum;
//    }
//
//    private int sumchil(Uzel koren) {
//        int sum = 0;
//        if(koren.getLevy() != null){
//            sum += koren.getLevy().getData();
//            sum += sumchil(koren.getLevy());
//        }
//        if(koren.getPravy() != null){
//            sum += koren.getPravy().getData();
//            sum += sumchil(koren.getPravy());
//        }
//        return sum;
//    }
//
//    public int secList(){
//        int sum = 0;
//        if(koren == null){
//            return 0;
//        }else{
//            sum += secList(koren);
//        }
//        return sum;
//    }
//
//    private int secList(Uzel u){
//        int sum = 0;
//        if((u.getLevy() == null) && (u.getPravy() == null)){
//            sum += u.getData();
//        }
//        if(u.getLevy() != null){
//            sum += secList(u.getLevy());
//        }
//        if(u.getPravy() != null){
//            sum += secList(u.getPravy());
//        }
//        return sum;
//    }



    public int sectiVsechny() {

        if (koren == null) {
            return 0;
        }
        int sum = koren.getData();
        sum += sumChild(koren);
        return sum;

    }

    private static int sumChild(Uzel u) {
        int sum = 0;
        if (u.getLevy() != null) {
            sum += u.getLevy().getData() + sumChild(u.getLevy());
        }
        if (u.getPravy() != null) {
            sum += u.getPravy().getData() + sumChild(u.getPravy());
        }

        return sum;
    }

    public int sectiListy() {

        if (koren == null) {
            return 0;
        }
        int sum = sumListy(koren);
        return sum;
    }

    private static int sumListy(Uzel u) {
        int sum = 0;
        if (u.getLevy() == null && u.getPravy() == null) {
            sum = u.getData();

        } else {
            if (u.getLevy() != null) {
                sum += sumListy(u.getLevy());
            }
            if (u.getPravy() != null) {
                sum += sumListy(u.getPravy());
            }
        }
        return sum;

    }

    public int sectiVnitrni() {
        // TODO Auto-generated method stub
        if (koren == null) {
            return 0;
        }
        int sum = sumVnitrnich(koren);
        return sum;
    }

    private int sumVnitrnich(Uzel u) {
        int sum = 0;
        if (u.getLevy() != null || u.getPravy() != null) {
            sum = u.getData();
        }
        if (u.getLevy() != null) {
            sum += sumVnitrnich(u.getLevy());
        }
        if (u.getPravy() != null) {
            sum += sumVnitrnich(u.getPravy());
        }
        return sum;
    }

    public String uzlyVhloubce() {
        if (koren == null) {
            return "";
        }
        int depth = 3;
        int tmpdepth = 1;
        String s = depth(koren, tmpdepth, depth);
        return s;
    }

    private String depth(Uzel u, int tmpdepth, int depth) {
        String s = "";
        if (tmpdepth == depth) {
            s = u.getData() + " ";
        } else {
            if (u.getLevy() != null) {
                s += depth(u.getLevy(), tmpdepth+1, depth);
            }
            if (u.getPravy() != null) {
                s += depth(u.getPravy(), tmpdepth+1, depth);
            }
        }
        return s;
    }


    public void Seznam() {
        if(koren == null) {
            return;
        }
        Uzel tmp = koren;
        while(tmp != null) {
            Uzel exPrav = tmp.getPravy();
            tmp.setPravy(tmp.getLevy());

            tmp.setLevy(null);

            Uzel end = tmp;
            while(true) {
                if(end.getPravy() == null) {
                    end.setPravy(exPrav);
                    break;
                }
                end = end.getPravy();
            }
            tmp = tmp.getPravy();
        }
    }


    public void flatten(Uzel node)
    {
        // Base case - return if root is NULL
        if (node == null)
            return;
        // Or if it is a leaf node
        if (node.getLevy() == null && node.getPravy() == null)
            return;
        // If root.left children exists then we have to make
        // it node.right (where node is root)
        if (node.getLevy() != null) {
            // Move left recursively
            flatten(node.getLevy());
            // Store the node.right in Node named tempNode
            Uzel tempNode = node.getPravy();
            node.setPravy(node.getLevy());
            node.setPravy(null);
            // Find the position to insert the stored value
            Uzel curr = node.getPravy();
            while (curr.getPravy() != null)
                curr = curr.getPravy();
            // Insert the stored value
            curr.setPravy(tempNode);
        }
        // Now call the same function for node.right
        flatten(node.getPravy());
    }

}
