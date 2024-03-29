package DSA_projekt;

public class Main {
    public static void main(String[] args) {

        Uzel u1 = new Uzel(5);
        Uzel u2 = new Uzel(8);
        Uzel u3 = new Uzel(13);
        Uzel u4 = new Uzel(15);
        Uzel u5 = new Uzel(-1);
        Tree st = new Tree();
        st.setKoren(u1);

        u1.setLevy(u2);
        u1.setPravy(u3);
        u2.setLevy(u4);
        u2.setPravy(u5);


        //System.out.println("Suma vsech uzlu1: "+st.secVsech());
        System.out.println("Suma vsech uzlu: "+st.sectiVsechny());



        System.out.println("Suma vsech listu: "+st.sectiListy());
        //System.out.println("Suma vsech listu1: "+st.secList());

        System.out.println("Suma vsech vnitrnich: "+st.sectiVnitrni());

        System.out.println("Uzly v hloubce 3: "+st.uzlyVhloubce()+". ");

        st.Seznam();

        //st.flatten(u1);
        System.out.println("Konec");


    }
}
