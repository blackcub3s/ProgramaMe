package villaviciosaTerrassa2023;

import java.util.Scanner;

public class Termoclastismo {
    
    //PRE: n > 0
    //POST: llegeix i processa n valors de temperatura "t" 
    //      compresos en interval -50 <= t <= 300 
    public static void casDeProva(Scanner sc, int n) {
        int tMin = 301;
        int tMax = -51;
        int nMax = 0;
        int nMin = 0;
        //guardo les tmratures d'un cas d prova per trobar la distancia minima
        int[] vTemps = new int[n];
        
        for (int i = 0; i < n; ++i) {
            int t = sc.nextInt();
            vTemps[i] = t;

            //BUSCO T MAXIMES I T MINIMES MENTRE GUARDO LES DADES DE T AL VECTOR
            //I BUSCO EL NOMBRE DE TMAXIMES I T MINIMES PER DESPRES PODER CREAR
            //ARRAYS QUE CONTINGUIN ELS SEUS INDEXOS (NECESSITEM CALCULAR LA LONGITUD)
            //PER EVITAR FER SERVIR ARRAY LIST QUE OCUPA MES MEMORIA
            if (t > tMax) {
                tMax = t;  
                nMax = 0; 
            }
            if (t < tMin) {
                tMin = t;
                nMin = 0; 
            }
            if (t == tMin)
                nMin += 1;
            if (t == tMax)
                nMax += 1; 
        }
        
        if (tMin == tMax)  //SÉ QUE ALESHORES LA DISTANCIA MINIMA SERA 0
            System.out.println(tMin+" "+tMax+" "+0);
        else { //CAS EN QUE DISTANCIA MINIMA SERA >= 1
            System.out.printf(tMin+" "+tMax+" "); //calculo la distancia minima a sota

            
            int[] arr_Imax = new int[nMax];
            int[] arr_Imin = new int[nMin];
            //GUARDO ELS INDEXOS ON ESTAN LES TEMPERATURES MAXIMES 
            //I MINIMES REPETIDES RECORRENT EL vTemps:
            int posMax = 0;
            int posMin = 0;
            for (int i = 0; i < vTemps.length; ++i) {
                if (vTemps[i] == tMax) {
                    arr_Imax[posMax] = i;
                    ++posMax;
                }
                else if (vTemps[i] == tMin) {
                    arr_Imin[posMin] = i;
                    ++posMin;
                }
            }

            //ARA QUE JA TINC ELS indexos de vTemps on hi ha els (o el) iMax guardats
            // dins "arr_Imax" i els (o el) iMin guardats en "arr_Imin" podem veure 
            // que ambdós arrays estan ordenats ja! Per tant, puc aplicar un algoritme
            // de comparació que no requereixi fer comparacions de tots amb tots.
            //
            // primer començem pel primer valor d'arr_Imin i pel primer de arr_Imax.
            // si la diferència en valor absolut és 1 ja hauriem trobat la 
            // distància mínima i parariem.
            // en cas contrari continuariem comparant aumentant l'índex de l'arraylist
            // el nombre del qual sigui més petit en la comparació:
            //
            // vegeu a continuació:
            
            
            int i = 0;
            int j = 0;
            int distancia = 200001; //o b 200001
            while (i < nMax && j < nMin && distancia != 1) {
                //FONAMENTAL FER EL MINIM!
                distancia = Math.min(distancia, Math.abs(arr_Imax[i] - arr_Imin[j]));
                
                if (arr_Imax[i] > arr_Imin[j])
                    j = j + 1; 
                else if (arr_Imax[i] < arr_Imin[j])
                    i = i + 1;
            }
            System.out.println(distancia);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        while (n != 0) {
            casDeProva(sc,n); 
            n = sc.nextInt();
        }        
    }
}   
