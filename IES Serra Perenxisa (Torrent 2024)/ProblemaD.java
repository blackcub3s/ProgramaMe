package programame;

import java.util.Scanner;

public class ProblemaD {
    
    //PRE: n casos de prova (es possible que es pugui esborrar)
    //POST: sortida per pantalla per a cada cas de prova [DEFINIR]
    public static void casDeProva(Scanner sc) {


        int nO = 0;
        int nX = 0;
        
        String judici = "";
        String linia = sc.nextLine();
        String jugada;
        
        //consumim primera linia  
        for (int i = 0; i < 3; ++i) {
            jugada = ""+linia.charAt(i);
            if (jugada.equals("O"))
                nO += 1;
            else if (jugada.equals("X"))
                nX += 1;
        }
        
        //consumim segona linia        
        linia = sc.nextLine();        
        
        for (int j = 0; j < 3; ++j) {
            jugada = ""+linia.charAt(j);
            
            if (jugada.equals("O"))
                nO += 1;
            else if (jugada.equals("X"))
                nX += 1;            
            
            
            if (j == 1) {
                if (jugada.equals("-"))
                    judici = "IMPOSIBLE";
                else if (jugada.equals("O"))
                    judici = "CIRCULO";
                else
                    judici = "CRUZ";
            }
        }  
        
        //consumim tercera linia          
        linia = sc.nextLine();
        for (int i = 0; i < 3; ++i) {
            jugada = ""+linia.charAt(i);
            if (jugada.equals("O"))
                nO += 1;
            else if (jugada.equals("X"))
                nX += 1;
        }          
        
        //JUDICI
        if (judici.equals("IMPOSIBLE"))
            System.out.println("IMPOSIBLE");
        else if (judici.equals("CIRCULO")) {
            if (nO - nX == 1  || nO - nX == 0)
                System.out.println("CIRCULO");
            else
                System.out.println("IMPOSIBLE");
        }
        else {//caso cruz {
            if (nX - nO == 1 || nX - nO == 0)
                System.out.println("CRUZ");
            else
                System.out.println("IMPOSIBLE");
        }
    }

  
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        //llegeixo l enter que informa del nre de casos de prova totals (nCasos)
        int nCasos = sc.nextInt();
        sc.nextLine(); 
        
        //menjo i tracto cada cas de prova amb la funciO corresponent
        for (int i = 0; i < nCasos; ++i) {
            casDeProva(sc);
        }
	sc.close();
    }
}   