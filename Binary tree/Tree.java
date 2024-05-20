package DSA_projekt_GITnew;

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

    public void vlozit(int hodnota) {
        Uzel novy = new Uzel(hodnota);
        if(koren == null){
            koren = novy;
            return;
        }else{
            Uzel tmp = koren;
            while(true){
                if(tmp.getHodnota() > hodnota){
                    if(tmp.getLevy() == null){
                        tmp.setLevy(novy);
                        return;
                    }else{
                        tmp = tmp.getLevy();
                    }
                }else{
                    if(tmp.getPravy() == null){
                        tmp.setPravy(novy);
                        return;
                    }else{
                        tmp = tmp.getPravy();
                    }
                }
            }
        }
    }

    public boolean obsahuje(int hodnota){
        if(koren == null){
            return false;
        }else{
            Uzel tmp = koren;
            while(true){
                if(tmp.getHodnota() == hodnota){
                    return true;
                }else{
                    if(tmp.getHodnota() > hodnota){
                        if(tmp.getLevy() != null){
                            tmp = tmp.getLevy();
                        }else{
                            return false;
                        }
                    }else{
                        if(tmp.getPravy() != null){
                            tmp = tmp.getPravy();
                        }else{
                            return false;
                        }
                    }
                }
            }
        }
    }
    
    public void vypislisty(){
        vypislisty(koren);
    }

    private void vypislisty(Uzel tmp) {
        if(tmp == null){
            return;
        }else{
            if((tmp.getLevy() == null) && (tmp.getPravy() == null)){
                System.out.print(tmp.getHodnota()+" ");
            }else{
                vypislisty(tmp.getLevy());
                vypislisty(tmp.getPravy());
            }
        }
    }

    public void preOrder() {
        preOrder(koren);
        System.out.println();
    }

    private void preOrder(Uzel u) {
        if (u == null) {
            return;
        }
        System.out.print(u.getHodnota() + " ");
        preOrder(u.getLevy());
        preOrder(u.getPravy());
    }

    public void inorder() {
        inorder(koren);
        System.out.println();
    }

    private void inorder(Uzel u) {
        if (u == null) {
            return;
        }
        inorder(u.getLevy());
        System.out.print(u.getHodnota() + " ");
        inorder(u.getPravy());
    }

    public void postOrder() {
        postOrder(koren);
        System.out.println();
    }

    private void postOrder(Uzel u) {
        if (u == null) {
            return;
        }
        postOrder(u.getLevy());
        postOrder(u.getPravy());
        System.out.print(u.getHodnota() + " ");
    }

    public void nejvicevlevo() {
        Uzel tmp = koren;
        int depth = 0;
        if (koren == null) {
            return;
        } else {
            while ((tmp.getLevy() != null) || (tmp.getPravy() != null)) {
                if (tmp.getLevy() != null) {
                    tmp = tmp.getLevy();
                    depth++;
                } else if (tmp.getPravy() != null) {
                    tmp = tmp.getPravy();
                    depth++;
                }
            }
        }
        System.out.println("Uzel nejvíce vlevo: " + tmp.getHodnota() +" a je v hloubce: "+depth);
    }

    public void nejvicevpravo() {
        Uzel tmp = koren;
        int depth = 0;
        if (koren == null) {
            return;
        } else {
            while ((tmp.getPravy() != null) || (tmp.getLevy() != null)) {
                if (tmp.getPravy() != null) {
                    tmp = tmp.getPravy();
                    depth++;
                } else if (tmp.getLevy() != null) {
                    tmp = tmp.getLevy();
                    depth++;
                }
            }
        }
        System.out.println("Uzel nejvíce vpravu: " + tmp.getHodnota() +" a je v hloubce: "+depth);
    }

    public int sectiVsechny() {
        if (koren == null) {
            return 0;
        }
        int sum = koren.getHodnota();
        sum += sumChild(koren);
        return sum;
    }

    private int sumChild(Uzel u) {
        int sum = 0;
        if (u.getLevy() != null) {
            sum += u.getLevy().getHodnota() + sumChild(u.getLevy());
        }
        if (u.getPravy() != null) {
            sum += u.getPravy().getHodnota() + sumChild(u.getPravy());
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

    private int sumListy(Uzel u) {
        int sum = 0;
        if (u.getLevy() == null && u.getPravy() == null) {
            sum = u.getHodnota();
        }
        else {
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
        if (koren == null) {
            return 0;
        }
        int sum = sumVnitrnich(koren);
        return sum;
    }

    private int sumVnitrnich(Uzel u) {
        int sum = 0;
        if (u.getLevy() != null || u.getPravy() != null) {
            sum = u.getHodnota();
        }
        if (u.getLevy() != null) {
            sum += sumVnitrnich(u.getLevy());
        }
        if (u.getPravy() != null) {
            sum += sumVnitrnich(u.getPravy());
        }
        return sum;
    }

    public String uzlyVhloubce(int depthv) {
        if (koren == null) {
            return "";
        }
        int depth = depthv;
        int tmpdepth = 1;
        String s = depth(koren, tmpdepth, depth);
        return s;
    }

    private String depth(Uzel u, int tmpdepth, int depth) {
        String s = "";
        if (tmpdepth == depth) {
            s = u.getHodnota() + " ";
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
}
