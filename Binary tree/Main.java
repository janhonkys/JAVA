package DSA_projekt_GITnew;

public class Main {
    public static void main(String[] args) {

        Tree st = new Tree();
        st.vlozit(10);
        st.vlozit(8);
        st.vlozit(7);
        st.vlozit(9);
        st.vlozit(12);
        st.vlozit(11);
        st.vlozit(13);

        System.out.println("Suma všech uzlů: "+st.sectiVsechny());
        System.out.println("Suma všech listů: "+st.sectiListy());
        System.out.println("Suma všech vnitřních uzlů: "+st.sectiVnitrni());
        System.out.print("Uzly v hloubce 2: ");
        System.out.println(st.uzlyVhloubce(2));
        System.out.println("Je ve stromu uzel s hodnotou 13? "+st.obsahuje(13));
        System.out.print("Výpis listů: ") ;
        st.vypislisty();

        System.out.println("");
        System.out.print("Preorder: ");
        st.preOrder();
        System.out.print("Inorder: ");
        st.inorder();
        System.out.print("Postorder: ");
        st.postOrder();

        st.nejvicevlevo();
        st.nejvicevpravo();

    }
}
