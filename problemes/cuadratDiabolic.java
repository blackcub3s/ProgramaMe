

package cuadradosDiabolicos;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/** @author santi
 * @version 21 mar. 2024 */
public class cuadratDiabolic {

    public static int[][] llegirQuadrat(int n, Scanner sc) {
        int[][] m = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                m[i][j] = sc.nextInt();
            }
        }
        return m;
    }

    public static boolean esQuadratDiabolic(int[][] m) {
        
        int n = m.length;
        
        //MIRO A FILES (finestra desplaSSSable)
        int sumImp = 0; //fila imparell (si no inicialitzo a 0 dona error. PQ?)
        int sumPar = 0; //fila parell (si no inicialitzo a 0 dona error. PQ?)
        for (int i = 0; i < n - 1; ++i) {
            sumImp = 0;
            sumPar = 0;
            for (int j = 0; j < n; ++j) {
                sumImp += m[i][j];
                sumPar += m[i+1][j];
            }
      
            if (sumPar != sumImp)
                return false;
        }
        
        // SI HEM ARRIBAT FINS AQUI EL PARELL DE FILES m[i] i m[i+1]
        // SUMARa IGUAL (sumPar == sumImp). ALESHORES ENS OCUPEM DE MIRAR
        // LA RESTA DE REQUISITS D'UN QUADRAT ESOTeRIC. 
        // AR ANEM A MIRAR SI ES COMPLEIX PER COLUMNES I PER LES DUES DIAGONALS 
        // PRINCIPALS. 
 
        //COMPROVO COLUMNES : sumCol haura de ser igual a sumPar o sumImp.
        for (int i = 0; i < n; ++i) {
            int sumCol = 0;
            for (int j = 0; j < n; ++j) {
                sumCol += m[j][i];
            }
            if (sumCol != sumPar)
                return false;
        }
        
        //COMPROVO DIAGONALS PRINCIPAL I DIAGONAL SECUNDARIA
        int sumDiagSecundaria = 0;
        int sumDiagPrincipal = 0;
        for (int i = 0; i < n; ++i) {
            sumDiagPrincipal += m[i][i]; 
            sumDiagSecundaria += m[i][n-1-i]; 
        }
        //com s ha dit puc comparar sumDiagSecundaria amb sumCol
        //o sumPar (ja que en aquest punt del programa tenen el mateix valor).
        return sumDiagSecundaria == sumPar;    
    }
    
    public static boolean esEsoteric(int[][] m) {
        int n = m.length;
        int rangNombres = n*n;
        
        //trobem la constant mAgica (CM) i CM2:
        int CM = 0; 
        for (int nre: m[0])
            CM += nre;
        
        int CM2 =  4*CM/n;
        
        //AVALUEM CONDICIONS 
        //(DE MeS SENZILLA A MeS COSTOSA COMPUTACIONALMENT)
        
        //ESCAIRES O BORDES (INDISTINT SI n parell o imparell):
        int sumaBordes = m[0][0] + m[n-1][0] + m[0][n-1] + m[n-1][n-1];
        if (sumaBordes != CM2)
            return false;

        
        if (n%2 != 0) { //n imparell (CONDICIo 2 i 3)
            
            //CENTRE
            int centreX4 = m[n/2][n/2] * 4;
            if (centreX4 != CM2) {
                return false;
            }
            //CENTRES LATERALS
            int sumaMigLtrls = m[0][n/2] + m[n/2][0] + m[n-1][n/2] + m[n/2][n-1];
            if (sumaMigLtrls != CM2) {
                return false;
            }
            
        } else { //n parell (CONDICIO 2 i 4)
            
            //SUMA CENTRES (GROC)
            int cDaltEsq = m[(n/2)-1][(n/2)-1];
            int cDaltDre = m[(n/2)-1][(n/2)];
            int cBaixEsq = m[(n/2)][(n/2)-1];
            int cBaixDre = m[n/2][n/2];
            if (cDaltEsq + cDaltDre + cBaixEsq + cBaixDre != CM2){
                return false;
            }
           
            
            //SUMA MIG LATERALS (VERD)
            int dalt = m[0][(n/2)-1] + m[0][n/2];
            int baix = m[n-1][(n/2)-1] + m[n-1][n/2];
            int esq  = m[(n/2)-1][0] + m[n/2][0];
            int dre  = m[(n/2)-1][n-1] + m[n/2][n-1];
            if (dalt + baix + esq + dre != 2*CM2) {
                return false;
            }
        }
        
        //SI TOT ES COMPLEIX COMPROVEM CONDICIo 1 (MeS COSTOSA, AL FINAL)
        Set<Integer> conjunt = new HashSet<>();
        for (int i = 1; i <= rangNombres; ++i)
            conjunt.add(i);
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if(conjunt.remove(m[i][j])) {
                    --rangNombres;  
                }
            }
        }
        if (rangNombres != 0) 
            return false;
        return true;    
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = -1;
        int[][] m;
        while (n != 0) {
            n = sc.nextInt(); //dimesiO del quadrat
            if (n != 0) {
                m = llegirQuadrat(n,sc);
                boolean diabolic = esQuadratDiabolic(m);
                if (diabolic)
                    if (esEsoteric(m)) 
                        System.out.println("ESOTERICO");
                    else
                        System.out.println("DIABOLICO");
                else
                    System.out.println("NO");
            }
        }
    }
}
