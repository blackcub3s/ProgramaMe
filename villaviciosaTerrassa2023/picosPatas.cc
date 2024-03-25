#include <iostream>
using namespace std;

int main() {
  int n;
  cin >> n; //n casos
  
  int pato;
  for (int i = 0; i < n; ++i) {
    cin >> pato;
    cout << pato << " " << pato*2 << endl;
  }
  return 0;
}