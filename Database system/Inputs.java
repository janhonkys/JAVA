package projektPC2;

import java.util.Scanner;

public class Inputs {

    public static int pouzeCislo(int a, int b) {        //funkce na pouzeCislo v rozsahu a-b
        Scanner sc = new Scanner(System.in);
        int number = 0;
        boolean validInput = false;

        while (!validInput) {       //dokud nespluje podminky
            if (sc.hasNextInt()) {      //pokud sc je integer
                number = sc.nextInt();
                if((a-1) < number && (b+1) > number){       //pokud splnuje rozsah
                    validInput = true;
                }else{
                    System.out.println("Zadejte celé číslo v rozsahu "+ a+"-"+b+" :");
                }
            }
            else {
                //System.out.println("Neplatný vstup. Zadejte prosím celé číslo v rozsahu "+ a+"-"+b+" :");
                System.out.println("Zadejte celé číslo v rozsahu "+ a+"-"+b+" :");
                sc.next();
            }
        }
        return number;      //funkce vraci number
    }
}
