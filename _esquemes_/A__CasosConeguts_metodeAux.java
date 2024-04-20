import java.util.Scanner;

public class PrimerEsquema_CasosConeguts {
    
    //PRE: lectura de Ncasos de prova del main [BORRAR O ADAPTAR]
    //POST: sortida per pantalla del processament fet amb cada cas de prova [BORRAR O ADAPTAR]
    public static void casDeProva(Scanner sc) {
        //fer codi amb sc.nextInt(), sc.nextLine() o sc.next() o el que toqui
        System.out.println("SUBSTITUIR AIXO PER LA LECTURA DE CADA CAS DE PROVA");       
    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        //llegeixo l enter que informa del nre de casos de prova totals (nCasos)
        int nCasos = sc.nextInt();
        sc.nextLine() //aquesta linia es pot ometre si el cas de prova no llegeix strings i nomes llegeix enters
        //menjo i tracto cada cas de prova amb la funciO corresponent
        for (int i = 0; i < nCasos; ++i) {
            casDeProva(sc);
        }
	sc.close();
    }
}   
