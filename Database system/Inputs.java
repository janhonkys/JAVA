package projektPC2;

import java.util.Scanner;

public class Inputs {

    public static int pouzeCislo(int a, int b) {
        Scanner sc = new Scanner(System.in);
        int number = 0;
        boolean validInput = false;

        while (!validInput) {
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                if((a-1) < number && (b+1) > number){
                    validInput = true;
                }else{
                    System.out.println("Zadejte celé číslo v rozsahu "+ a+"-"+b+" :");
                }
            }
            else {
                System.out.println("Zadejte celé číslo v rozsahu "+ a+"-"+b+" :");
                sc.next();
            }
        }
        return number;
    }
}
