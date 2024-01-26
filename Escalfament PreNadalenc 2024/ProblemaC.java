import java.util.Scanner;

/** @author santi  @fecha  27 ene. 2024  */
public class ProblemaC {
    
    
    public static int tractaParell(String nre, int i) {
        int n = Character.getNumericValue(nre.charAt(i)); //tela amb aquesta funció, per passar de char a enter.
        
        int mesGranEsq = -1;
        for (int j = i - 1; j >= 0; --j) {
            int a =  Character.getNumericValue(nre.charAt(j));
            if (a > mesGranEsq)
                mesGranEsq = a;
        }
        return n*2 + mesGranEsq;
    }
    
    
    public static int tractaImparell(String nre, int i) {
        int n = Character.getNumericValue(nre.charAt(i)); //tela amb aquesta funció, per passar de char a enter.
        
        int menorDreta = 10;
        for (int j = i + 1; j < nre.length(); ++j) {
            int a =  Character.getNumericValue(nre.charAt(j));
            if (a < menorDreta)
                menorDreta = a;
        }
        return n*3 + menorDreta;
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nCasos = sc.nextInt();
        
        //itero als casos de prova
        for (int i = 0; i < nCasos; ++i) {
            String nombre = sc.next();
            
            //calculo el codi de verificació
            int codi = 0;
            for (int j = 0; j < nombre.length(); ++j) {
                if (j % 2 == 0) //ex. j==0 es posicio 1 (imparell)
                    codi += tractaImparell(nombre,j);
                else
                    codi += tractaParell(nombre,j);
            }
            System.out.println(codi);
        } 
    }
}
