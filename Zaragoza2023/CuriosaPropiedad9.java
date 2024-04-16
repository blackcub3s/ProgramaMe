/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package regionalZaragoza2020;

import java.util.Arrays;
import java.util.Scanner;

public class CuriosaPropiedad9 {
    

    public static void casDeProva(Scanner sc, int n) {
        String nS = Integer.toString(n);
        int[] vN_petit = new int[nS.length()];
        int[] vN_gran = new int[nS.length()];
        for (int i = 0; i < nS.length(); ++i) {
            vN_petit[i] = Integer.parseInt(""+nS.charAt(i));
        }
        Arrays.sort(vN_petit);
        
        for (int i = 0; i < nS.length(); ++i) {
            vN_gran[i] = vN_petit[nS.length()-1-i];
        }        
        
        String petit = "";
        String gran = "";
        for (int i = 0; i < nS.length(); ++i) {
            petit += Integer.parseInt(""+vN_petit[i]);
            gran += Integer.parseInt(""+vN_gran[i]);
        }               
        
        petit = petit.replaceFirst("^0+", ""); //uso expressio regularp er treure el padding de l'esquerra de zeros

        int diferencia = Integer.parseInt(gran) - Integer.parseInt(petit);
        int quocient = diferencia/9;
        System.out.println(gran+" - "+petit+" = "+diferencia+" = "+quocient+" x "+9);

        
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        while (n != 0) {
            casDeProva(sc,n); 
            n = sc.nextInt();
        } 
        sc.close();        
    }

}   