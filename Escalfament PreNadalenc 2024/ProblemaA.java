

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

/* @author santi   @fecha  26 ene. 2024*/
public class ProblemaA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //llegeixo cada cas de prova mentre n'hi hagi (condició finalitzacio nVots == 0, dins bucle amb break
        while (true) {
            Map<String, Integer> paisVots = new HashMap<>(); //declaro un nou hashMap (mapa)
            int nVots = sc.nextInt(); //llegeixo nombre de vots esperats (nre strings)
            sc.nextLine(); //netejo bufer
            
            //CAS EN QUE S'ACABA LA SEQUÈNCIA
            if (nVots == 0)
                break;
            
            //LLEGEIXO ELS STRINGS (PAISOS) I ELS CONTO DINS 
            //CADA VALOR DE LA CLAU CORRESPONENT (PER A UN CAS DE PROVA DONAT)
            String pais = "";
            for (int i = 0; i < nVots; ++i) {
                pais = sc.next(); //llegeixo paraula a paraula
                if (paisVots.containsKey(pais)) //el pais ja ha sigut afegit a dins el map (sumem +1 als vots existents)
                    paisVots.put(pais, paisVots.get(pais) + 1);
                else //el pais no existeix dins el map (posem un vot)
                    paisVots.put(pais, 1);
            }

            
            //MIRO EL PAIS GUANYADOR O SI HI HA EMPATS (EL HASMAP ESTÀ ORDENAT)
            //I SI HI HA UN SOL PAIS NO CAL MIRAR EL HASH
            if (paisVots.size() == 1)
                System.out.println(pais);
            else {
                
                //primera posicio es el pais amb mes vots. Segona posicio es el 
                //segon pais amb mes vots. Si coincideixen hi ha empat
                
                int maxVots = 0; //sempre hi haurà com a minim un vot aixi que 0 es un enter que podem escollir.
                String paisMaxVots = "";
                
                //RECORREM EL MAP PER TROBAR ELS PAISOS MES VOTATS
                //BOOLEA empat clau per resoldre els empats (ha COSTAT!)
                boolean empat = false;
                for (Map.Entry<String, Integer> parell_paisVot : paisVots.entrySet()) {                 
                    
                    String paiset = parell_paisVot.getKey();
                    int votetsPaiset = parell_paisVot.getValue();
                   
                    //System.out.printf("pais: %s", paiset);
                    //System.out.printf("| vots: %d\n", votetsPaiset); 
                    
                    if (votetsPaiset > maxVots) {
                        maxVots = votetsPaiset;
                        paisMaxVots = paiset;
                        empat = false;
                    } else if (votetsPaiset == maxVots)                     
                        empat = true; 
                }        
                
                //IMPRIMIM EL RESULTAT PER PANTALLA
                if (empat)
                    System.out.println("EMPATE");
                else
                    System.out.println(paisMaxVots);
            }           
        }
    }   
}
