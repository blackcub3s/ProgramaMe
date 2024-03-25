import java.util.Scanner;

/**
 * @author santi
 * @version 25 mar. 2024
 */
public class diaMundialPiano {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); //n casos
        
        for (int i = 0; i < n; ++i) {
            int anyIni = sc.nextInt();
            int anyFi = sc.nextInt();
            
            
            int contaBis = 0;
            int contaNoBis = 0;
            for (int j = anyIni; j <= anyFi; ++j) {
                if (j%4 == 0) {
                    if (j%100 == 0) {
                        if (j%400 == 0)
                           contaBis += 1;
                        else
                           contaNoBis += 1;
                    } else {
                        contaBis += 1;
                    }
                } else {
                    contaNoBis += 1;
                }
            }
            System.out.println(contaNoBis+" "+contaBis);
           
        }
    }
}
