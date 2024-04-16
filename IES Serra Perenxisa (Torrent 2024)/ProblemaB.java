package programame;

import java.util.Scanner;

public class ProblemaB {
    

    public static boolean casDeProva(Scanner sc) {
        String nS = sc.nextLine();
        int llarg = nS.length();
        
        boolean iniciFiOK = false;
        if (nS.charAt(0) == nS.charAt(llarg-2)) {
            if (nS.charAt(1) == nS.charAt(llarg-1)) {
                iniciFiOK = true;
            }            
        } 
        
        if (iniciFiOK) {
            int nZeros = 0;
            int nUns = 0;
            for (int i = 0; i < llarg; ++i) {
                if (nS.charAt(i) == '0')
                    nZeros += 1;
                else
                    nUns += 1;
            }         
            if (nZeros == nUns)
                return true;
            else
                return false;
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        //llegeixo l enter que informa del nre de casos de prova totals (nCasos)
        int nCasos = sc.nextInt();
        sc.nextLine(); 
        
        //menjo i tracto cada cas de prova amb la funciO corresponent
        for (int i = 0; i < nCasos; ++i) {
            if (casDeProva(sc)) {
                System.out.println("EQUILIBRADA");
            } else {
                System.out.println("ERROR");
            }
        }
	sc.close();
    }
}   