
package regionalZaragoza2020;

import java.util.Scanner;

public class Acronimos {
    
    //PRE: n casos de prova (linies que tenen paraules)
    //POST: sortida per pantalla per a cada cas de prova [DEFINIR]
    public static void casDeProva(int n, Scanner sc) {
        String linia = sc.nextLine();
        String[] par = linia.split(" ");
        for (int i = 0; i < par.length; ++i) {
            String sortida = "";
            if (Character.isUpperCase(par[i].charAt(0))) {
                System.out.print(par[i].charAt(0));
            }
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        //llegeixo l enter que informa del nre de casos de prova totals (nCasos)
        int nCasos = sc.nextInt();
        sc.nextLine(); 
        
        //menjo i tracto cada cas de prova amb la funciO corresponent
        for (int i = 0; i < nCasos; ++i) {
            casDeProva(nCasos, sc);
        }
	sc.close();
    }
}   