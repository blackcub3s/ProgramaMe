
import java.util.Scanner;

/*
https://aceptaelreto.com/problem/statement.php?id=712&cat=165
 */

/*@author santi * @fecha  27 ene. 2024 */
public class ProblemaD {
    
    //PRE: v --> vector amb els temps en que es produeixen events
    //     q ----> nombre d'events consecutius dels quals volem consultar
    //             on es dóna la màxima densitat d'ocurrència. CAL QUE(2 <= q <= v.length))
    //     N ----> N és v.length())
    //POST: Sortida demanada pel Canal estàndard de sortida
    public static void fesSortidaPerConsulta_amb_q_superior_a_1(int[] v, int q, int N) {
        if (N == q) {
            System.out.println(v[0]+" "+v[N-1]+" "+q);
        } else { //N > q (obvi)
            int iMaxDens = -1; //index inicial del vector v on trobem l'agrupació q amb maxima densitat d'events.
            int tqMin = Integer.MAX_VALUE;
            int j = 0;

            //funcionara per a q >= 2 pero n oper a q igual a 1 que caldar canviar
            //FINESTRA QUE DESPLAÇA EL BUCLE INTERIOR A LO LLARG DEL VECTOR PER TROBAR EL tqMin i l'iMaxDens
            while (j < N - q) {
                int tq = 0;     //temps que passa desde el primer event trobat fins a q
                for (int i = 0; i < q - 1; ++i) {
                    tq += v[j+i+1] - v[j+i];
                }
                if (tq < tqMin) {
                    tqMin = tq;
                    iMaxDens = j;
                }
                j = j + 1;
            }

            //NOTA QUE NO HAGUÉS FUNCIONAT PER A q IGUAL A 1
            System.out.println(v[iMaxDens]+" "+v[iMaxDens + q - 1]+" "+q);
        }
    }   
    
    //PRE: v --> vector amb els temps en que es produeixen events
    //     cal que q valgui sempre 1 (no passem per paràmetre perquè ja ho controlem fora)
    //     N ----> N és v.length())    
    //POST: Sortida demanada pel Canal estàndard de sortida
    public static void fesSortidaPerConsulta_igual_a_1(int[] v, int N) {

        //CAS EN QUE N >= 2 (si N == 1 NO ENTRAÀ AL BUCLE)
        boolean valorDuplicat = false;
        for (int i = 0; i < N - 1; ++i) {
            if (v[i] == v[i+1]) { //event duplicat en un mateix moment (ex entrada i sortida jugadors)
                System.out.println(v[i]+" "+v[i+1]+" "+2);
                return;
            } 
        }
        
        //CAS EN QUE N >= 1 (perfecte)
        if (!valorDuplicat) //no existeix event duplicat
            System.out.println(v[0]+" "+v[0]+" "+1);
    }  
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //CAL RECORRER DIVERSOS CASOS DE PROVA. OJO QUE A L'INPUT
        //ET POSEN NOMÉS UN CAS DE PROVA
        
        while (sc.hasNextInt()) { //NO ES PARA...
            
            int N = sc.nextInt(); //nre events anotats
            sc.nextLine(); //buffer netejat

            int[] v = new int[N]; //vector d'events i temps

            for (int i = 0; i < N; ++i) {
                v[i] = sc.nextInt(); //guardo el temps de cada event
                sc.nextLine(); //no faig servir la descripcio de l'event, me la menjo.
            }

            //MIREM NOMBRE DE CONSULTES
            int Q = sc.nextInt();
            sc.nextLine(); //menjo salt de línia

            //RECORREM LES CONSULTES
            for (int i = 0; i < Q; ++i) {
                int q = sc.nextInt();
                sc.nextLine(); //menjo salt línia

                if (q == 1)
                    fesSortidaPerConsulta_igual_a_1(v, N);   
                else
                    fesSortidaPerConsulta_amb_q_superior_a_1(v, q, N);
            }

            //IMPRIMIM LINIES DE FINAL DEL CAS DE PROVA
            System.out.println("---");
        }
    }
}
