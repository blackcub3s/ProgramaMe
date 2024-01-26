#include <iostream>
using namespace std;

int main() {
    
    int n;
    cin >> n;
    
    //RECORRO FILES (CADA FILA ÉS CAS DE PROVA D'UN MUNDIAL)
    for (int i = 0; i < n; ++i) {
        
        //MIRO EQUIPS QUE TÉ EL MUNDIAL
        int nEquips;
        cin >> nEquips;
        
        //RECORRO ELS EQUIPS PER CADA CONFEDERACIÓ I ELS ACUMULO
        int sumEquipsConfederacio = 0;
        int entrada;
        for (int j = 0; j < 6; ++j) {
            cin >> entrada;
            sumEquipsConfederacio += entrada;
        }
        
        //IMPRIMEIXO EL NOMBRE D'EQUIPS QUE VAN A LA REPESCA INTERCONTINENTAL SI CAL
        cout << nEquips - sumEquipsConfederacio << endl;
    }       

    return 0;
}


