import java.util.Scanner;

/**
 * @author santi
 * @version 25 mar. 2024
 */
public class picosPatas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); //n casos
        
        for (int i = 0; i < n; ++i) {
            int patosCasProva = sc.nextInt();
            System.out.println(patosCasProva+" "+patosCasProva*2);
        }
    }
}
