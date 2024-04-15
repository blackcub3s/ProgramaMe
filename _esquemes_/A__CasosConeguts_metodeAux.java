import java.util.Scanner;

public class PrimerEsquema_CasosConeguts {
    
    //PRE: n casos de prova
    //POST: sortida per pantalla per a cada cas de prova [DEFINIR]
    public static void casDeProva(int n, Scanner sc) {
        //fer codi amb sc.nextInt(), sc.nextLine() o sc.next() o el que toqui
        System.out.println("SUBSTITUIR AIXO PER LA LECTURA DE CADA CAS DE PROVA");       
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
