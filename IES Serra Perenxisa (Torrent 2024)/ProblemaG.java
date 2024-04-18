package programame;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class ProblemaG {
    
    public static Set<String> llegeixDesenvolupadors(Scanner sc) {
        //el conjunt de tecnologies que tenen els desenvolupadors
        Set<String> tecDes = new HashSet<>();
        int D = sc.nextInt(); //llegeixo el nombre D de desenvolupadors
        sc.nextLine(); //netejo bufer després de llegir enter i abans del proper nextline
        
        //recorrem cada linia (cada linia es un desenvolupador 
        //seguit d ls seves habilitats)
        for (int i = 0; i < D; ++i) {
            String linia = sc.nextLine();
            String[] hd = linia.split(" ");  //hd es habiliatt desenvolupador
            
            //afegim les habilitats del desenvolupador al set
            //(ens despreocupem dels duplicats, el set ja se n'encarrega que no
            //n'hi hagin)
            for (int j = 1; j < hd.length; ++j)
                tecDes.add(hd[j]); 
        }
        return tecDes;
        
    }
    
    public static void llegeixProjectes(Scanner sc, Set<String> tecDes) {
        int P = sc.nextInt(); //llegeixo el nombre P de projectes
        sc.nextLine();
        
        //RECORRO ELS PROJECTES
        for (int i = 0; i < P; ++i) {
            
            String linia = sc.nextLine();
            String[] hrp = linia.split(" ");  //hrp es habilitats requerida pel projecte
            
            //RECORRO LES HABILITATS REQUEREIDES PER CADA PROJECTE I SI ALGUN 
            //PROJECTE VEIEM QUE ELS SEUS DESENVOLUPADORS FALLEN EN ALGUNA HAB
            //ILITAT PAREM I SORTIM DEL BUCLE SEGUENT:
            boolean projectePossible = true;
            for (int j = 1; j < hrp.length; ++j) {
                if(!(tecDes.contains(hrp[j]))) {
                    System.out.println("IMPOSIBLE");
                    projectePossible = false;
                    break;
                }
            }
            if (projectePossible)
                System.out.println("POSIBLE");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        llegeixProjectes(sc, llegeixDesenvolupadors(sc));   
    }
}
