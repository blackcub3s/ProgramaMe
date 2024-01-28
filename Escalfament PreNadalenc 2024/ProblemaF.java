

import java.util.Scanner;
/**
 * https://aceptaelreto.com/problem/statement.php?id=714
 * @author santi
 * @fecha  28 ene. 2024
 */
public class ProblemaF {
    
    //PRE: N es el nombre d'equips (2 <= N <= 64)
    //POST: Mostra pel CE de sortida l'equip guanyador del cas de prova donat.
    public static void tractaCasDeProva(int N, Scanner sc) {
        //noteu que inicialment nom[i] es l'equip que ha marcat el gols[i] 
        //en el partit que es celebra entre equps noms[i] i noms[i+1]
        String[] noms = new String[N]; //noms dels equips per ordre de sequencia
        int[] gols = new int[N];       //gols de l'equip per ordre de sequencia
        
        //GUARDEM ELS NOMS DELS EQUIPS DINS ARRAY DE noms
        for (int i = 0; i < N; ++i)
            noms[i] = sc.next(); //pillem seguent equip
        
        while (N != 1) {
            //LLEGIM ELS N GOLS MARCATS 
            //(a vuitens de final N gols són 16 nombres, a quarts son 8, ...)
            for (int i = 0; i < N; ++i)
                gols[i] = sc.nextInt(); 
               
            //1A ITERACIÓ: NOMÉS RECORRO EL VECTOR DE NOMS FINS A LA MEITAT.
            //AMB VECTOR DE GOLS DECIDEIXO ELS EQUIPS GUANYADORS REUBICANT ELS 
            //NOMS DELS GUANYADORS A LA PRIMERA MEITAT DE ARRAY NOMS.
            int j = 0;
            int i = 0;
            while (j < N - 1) {  //també serviria la condicio i < N/2 :)
                if (gols[j] > gols[j+1])
                    noms[i] = noms[j];
                else if (gols[j] < gols[j+1])
                    noms[i] = noms[j+1];
                j = j + 2;
                i = i + 1;
            }
            //Passem de la fase de N/2 enfrentaments a N/4
            //despres a N/8 fins que N/N = 1 que és quan es troba el guanyador.
            N = N/2; 
        }
        sc.nextLine(); //netejo bufer
        System.out.println(noms[0]); //mostro guanyador del cas de prova
    }
    
    
    public static void main(String[] args) {
        int N;
        Scanner sc = new Scanner(System.in);
        do {
            N = sc.nextInt();
            sc.nextLine();
            if (N >= 2)
                tractaCasDeProva(N, sc);
        } while (N != 0);
    }
}
