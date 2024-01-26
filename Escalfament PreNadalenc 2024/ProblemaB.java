

import java.util.Scanner;

/**
 * @author santi
 * @fecha  24 ene. 2024
 */
public class ProblemaB {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine(); //consumeixo bufer
        
        //RECORRO FILES (CADA FILA ÉS CAS DE PROVA D'UN MUNDIAL)
        for (int i = 0; i < n; ++i) {
            
            //MIRO EQUIPS QUE TÉ EL MUNDIAL
            int nEquips = sc.nextInt();
            
            //RECORRO ELS EQUIPS PER CADA CONFEDERACIÓ I ELS ACUMULO
            int sumEquipsConfederacio = 0;
            for (int j = 0; j < 6; ++j) {
                sumEquipsConfederacio += sc.nextInt();
            }
            sc.nextLine(); //consumeixo bufer
            
            //IMPRIMEIXO EL NOMBRE D'EQUIPS QUE VAN A LA REPESCA INTERCONTINENTAL
            //SI S'ESCAU
            System.out.println(nEquips - sumEquipsConfederacio); 
        }   
    }
}
