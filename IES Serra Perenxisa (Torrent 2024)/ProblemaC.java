package programame;

import java.util.Scanner;

public class ProblemaC {
    
    //PRE: la sequencia de N A B X Y en una linia seguida de N enters en la seguent.
    //POST: sortim el nombre de likes combinat dels dos servidors per cada cas de prova.
    public static void casDeProva(Scanner sc) {
        int N = sc.nextInt();
        int A = sc.nextInt(); //gustas server A
        int B = sc.nextInt(); //no gustas server A
        int X = sc.nextInt(); //gustas server B
        int Y = sc.nextInt(); //no gustas server B
        
        //usuaris de tipus 1 (el que dona like si li agrada)
        //usuaris de tipus 2 (el que dona dislike si no li agrada)
        //usuaris de tipus 3 son els que donen like o dislike en base al 
        // feedback del server (si el server te mes likes que dislikes o igual
        //nombre de likes o dislikes l'usuari votarà un like, mentre que 
        //en cas contrari (mes dislikes que likes) votarà un dislike.

        for (int i = 0; i < N; ++i) {  
            int tipusLlegit = sc.nextInt();
            
            int dA = A - B;//diff de vots positius - negatius en servidor A
            int dB = X - Y;//diff de vots positius - negatius en servidor B
            
            //El que sempre vota positiu (tipus1) acumula el seu vot positiu al 
            //servidor amb mes vots positius que negatius si es el cas.
            if (tipusLlegit == 1) { 
                if (dA >= dB) //en cas dA == dB fer X += 1 o A += 1 es indistint
                    A += 1;
                else if (dA < dB)
                    X += 1;
            }
            //En canvi, el que sempre vota negatiu (tipus 2) acumula el seu vot
            //negatiu al servidor amb mes vots negatius que positius si es l cas
            else if (tipusLlegit == 2) {
                if (dA >= dB) //en cas dA == dB --> B += 1 o Y += 1 es indistint    
                    Y += 1;  //sumo als dislikes del servid. B (el pitjor serv.)
                else if (dA < dB)
                    B += 1; //sumo als negatius del servidor A        
            }
            //Finalment, els que voten a partir del feedback que reben del
            //servidor caldrà que els dirigim sempre en el servidor on hi 
            //hagi una diferència més favorable. ELLS SON ELS QUE MARQUEN
            //la diferència per poder manipular els vots.
            else if (tipusLlegit == 3){
                if (dA > dB) { //serv. A aquí t resultats més favorables que B
                    if (A >= B) //USUARI3 donarà vot positiu! El posem al millor server (A).
                        A += 1;
                    else    //SI (A < B) faria dislike al serverA. Solució: el posem al server B i preservem server A.
                        Y += 1; 
                }
                else if (dA <= dB) { //QUAN (dA < dB SERVIDOR B TE RESULTATS MES FAVORABLES (SI dA == dB es igual a quin servidor sumem els vots)).
                    if (X >= Y)      //si (X>Y) USUARI 3 DONA VOT POSITIU AL SERVIDOR B. EL POSEM AL B.
                        X += 1;
                    else            //SI (X < Y) USUARI 3 ANIRIA A DONAR UN VOT NEGATIU AL SERVIDOR B. PER TANT ELVOT NEGATIU EL POSEM AL server A.
                        B += 1;
                } 
            }   
        }
        //IMPRIMEIXO SUMATORI DE VOTS POSITIUS DELS DOS SERVIDORS
        System.out.println(A+X);
    }
        
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt(); //casos de prova totals
        for (int i = 0; i < T; ++i) {
            casDeProva(sc);
        }
	sc.close();
    }
}   