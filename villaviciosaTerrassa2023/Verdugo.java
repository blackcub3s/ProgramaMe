
package villaviciosaTerrassa2023;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Verdugo {
    

    public static void casDeProva(Scanner sc, String pOculta, String proposta) {
        Set<Character> setOculta = new HashSet<>(); //lletres de la paraula oculta_
        Set<Character> setProvades = new HashSet<>(); //lletres ja trobades per l'usuari
        

        //afegim les lletres de la paraula oculta al conjunt 
        //(aixi duplicats no s'afegeixen)
        for (int i = 0; i < pOculta.length(); ++i) {
            setOculta.add(pOculta.charAt(i));
        }
        
        int fallosOnEtPenjen = 7;
        int intentsGastats = 0;
        boolean colgando = true;
        for (int i = 0; i < proposta.length(); ++i) {
            if (!setProvades.contains(proposta.charAt(i))) { //si no s'ha intentat
                if (setOculta.contains(proposta.charAt(i))) { //ha encertat lletra
                    setOculta.remove(proposta.charAt(i)); 
                    setProvades.add(proposta.charAt(i));
                } else {
                    intentsGastats += 1;
                    setProvades.add(proposta.charAt(i));
                }
                
                if (setOculta.isEmpty()) {
                    System.out.println("SALVADO");
                    colgando = false;
                    break;
                }                      
                else if (intentsGastats == fallosOnEtPenjen) {
                    System.out.println("AHORCADO");
                    colgando = false;
                    break;
                }

            }
        }
        if (colgando)
            System.out.println("COLGANDO");
    }

    
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String pOculta;
        String proposta;

        while (true) {
            pOculta = sc.nextLine();
            if (pOculta.equals("."))
                break;

            proposta = sc.nextLine();

            // processa el cas de prova
            casDeProva(sc, pOculta, proposta);
        }
        sc.close();
    }

}   
