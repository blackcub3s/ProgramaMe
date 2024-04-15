

package regionalZaragoza2020;
import java.util.Scanner;

public class EspiralGalactica {
    
    //PRE: N imparell i 0 <= N <= 100 000
    public static void casDeProva(Scanner sc, int N) {
        int[][] m = new int[N][N];
        
        //GUARDO MATRIU DEL FIRMAMENT
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                m[i][j] = sc.nextInt();
            }        
        }     
        
        //CONTO ESTRELLES EN L'ESPIRAL (POSICIO INICIAL ESPIRAL EN i I j N mig)
        int i = N/2;
        int j = N/2;
        int sumE = m[i][j]; //inicialitzo amb el valor de la casella central
        
        boolean espiralSumada = false;    
        String[] cas = {"amunt","dreta","avall","esquerra"};
        
        int nreEstrellesEnLinia = 2; //primer 2 celes, despres 3, despres 4...
        
        while (!espiralSumada) {
            for (int k = 0; k < cas.length; ++k) {
                for (int l = 0; l < nreEstrellesEnLinia - 1; ++l) {
                    if (cas[k].equals("amunt")) {
                        i = i - 1;
                        if (i >= 0)
                            sumE += m[i][j];
                        else {
                            espiralSumada = true;
                            break;
                        }
                    } else if (cas[k].equals("dreta")) {
                        j = j + 1;
                        if (j < N)
                            sumE += m[i][j];
                        else {
                            espiralSumada = true;
                            break;
                        }                  
                    } else if (cas[k].equals("avall")) {
                        i = i + 1;
                        if (i < N)
                            sumE += m[i][j];
                        else {
                            espiralSumada = true;
                            break;
                        }                  
                    } else if (cas[k].equals("esquerra"))  {
                        j = j - 1;
                        if (j >= 0)
                            sumE += m[i][j];
                        else {
                            espiralSumada = true;
                            break;
                        }                
                    }
                }
                if (espiralSumada)
                    break;
                
                nreEstrellesEnLinia += 1;
            }
        }
        System.out.println(sumE);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        while (N != 0) {
            casDeProva(sc,N); 
            N = sc.nextInt();
        } 
        sc.close();        
    }

    
}   
