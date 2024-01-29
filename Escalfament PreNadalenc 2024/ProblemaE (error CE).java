
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author santi
 * @fecha  29 ene. 2024
 * 
 */
public class ProblemaE {
    
    public static int[][] imprimeixClassificats(int N, int Q, Scanner sc) {
         //matriu de la classificació (N equips, 5col)
         //columnes: equip,  punts, GF, GC, Dif
        int[][] m = new int[N][5];
        int i = 0;
        int enfrentaments = (N*(N - 1))/2;
        while (i < enfrentaments) {
            //llegeixo les dades de cada enfrentament
            int codiEq1 = sc.nextInt();
            int codiEq2 = sc.nextInt();
            int golsEq1 = sc.nextInt();
            int golsEq2 = sc.nextInt();
            sc.nextLine(); //netejo bufer
            
            //classifico les dades dins la matriu m de la classificació 
            //fixeu-vos que equipK ocupa fila K-1 de la matriu, ja que
            //la indexació dels arrays comença de zero:
            m[codiEq1 - 1][0] = codiEq1; //empleno els noms de l'equip a acada iteracio
            m[codiEq2 - 1][0] = codiEq2; //empleno els noms de l'equip a acada iteracio
            
            
            
            if (golsEq1 > golsEq2) 
                m[codiEq1 - 1][1] += 3; //sumo 3 punts (guanya eq1)
            else if (golsEq1 < golsEq2)
                m[codiEq2 - 1][1] += 3; //sumo 3 punts (guanya eq2)
            else {
                m[codiEq2 - 1][1] += 1; //empat +1 punt
                m[codiEq1 - 1][1] += 1; //empat +1 punt
            }
            
           
            m[codiEq1 - 1][2] += golsEq1; //sumo els gols a favor d'eq1
            m[codiEq2 - 1][2] += golsEq2; //sumo els gols a favor d'e2
            
            m[codiEq1 - 1][3] += golsEq2; //sumo els gols EN CONTRA d eq1
            m[codiEq2 - 1][3] += golsEq1; //sumo els gols EN CONTRA d eq2           
            
            m[codiEq1 - 1][4] += golsEq1 - golsEq2; //acumulem dif de gols eq1
            m[codiEq2 - 1][4] += golsEq2 - golsEq1; //cumulem dif de gols eq2
            
            i = i + 1;
        }
        return m;    
    }
    
    /*
    public static void imprimeixMatriu(int[][] m, String judici) {
        System.out.println("MATRIU CLASSIFICACIO "+judici);
        System.out.println("EQ PTS GF GC DIF");
        for (int[] fila : m)
            System.out.println(Arrays.toString(fila));
        System.out.println("###########");      
    }
    */
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //PROCESSEM CASOS DE PROVA (PARAR QUAN ENTREM ALGO QUE NO SIGUI UN ENTER)
        do {
            int N = sc.nextInt();
            int Q = sc.nextInt();
            sc.nextLine(); //netejo bufer
            
            int[][] m = imprimeixClassificats(N,Q,sc); //tracto cada cas de prova aquí dins
            
            //IMPRIMEIXO MATRIU NO ORDENADA
            //imprimeixMatriu(m,"NO ORDENADA");
            
            //-----INICI XAT GPT-----
            
            //PER ORDENAR LA MATRIU CAL FER SERVIR TRES COMPARADORS ANIDATS
            //EL PRIMER COMPARADOR ORDENA PER LA COLUMNA DELS PUNTS (2A COLUMNA),
            //EL SEGON PER LA COLUMNA DE LA DIFERÈNCIA DE GOLS (5A COLUMNA)-----
            //I L'ÚLTIM COMPARADOR PER LA 3A COLUMNA PELS GOLS A FAVOR
            Comparator<int[]> customComparator = Comparator
                    .comparingInt((int[] row) -> row[1]) // Sort by the SECOND column
                    .thenComparingInt(row -> row[4])     // Then sort by the FIFTH column
                    .thenComparingInt(row -> row[2])     // Finally, sort by the THIRD column
                    .reversed();                          // All in descending order

            // ORDENAR LA MATRIU FENT SERVIR EL COMPARADOR
            Arrays.sort(m, customComparator);            

            //-----FINAL XAT GPT-----
            
            
            //IMPRIMEIXO MATRIU ORDENADA
            //imprimeixMatriu(m,"ORDENADA");
          
            
            //IMPRIMEIXO EQUIPS CLASSIFICATS PER ORDRE DE CLASSIFICACIÓ
            if (Q == 1)
                System.out.println(m[0][0]);
            else {
                for (int i = 0; i < Q - 1; ++i) {
                    System.out.printf(m[i][0]+" ");
                }
                System.out.printf("%d\n",m[Q-1][0]);
            }
        } while(sc.hasNextInt());
    }
}
