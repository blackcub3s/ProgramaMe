import java.util.Scanner;

public class Posa_classe_corresponent_aqui {
    

    public static void casDeProva(Scanner sc, int n) {
        //sc.nextLine() o sc.next() o sc. el que toqui
        System.out.println("SUBSTITUIR AIXO PER LA LECTURA DE CADA CAS DE PROVA");       
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        while (n != 0) {
            casDeProva(sc,n); 
            n = sc.nextInt();
        } 
        sc.close();        
    }

}   