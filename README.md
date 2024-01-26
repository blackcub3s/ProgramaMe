# 1. INTRODUCCIÓ

En aquest repositori es resoldran problemes de la competició ProgramaMe. Tots els problemes pujats estaran validats amb el validador de la pàgina web https://aceptaelreto.com/, que implementa solucions als mateixos i compara els outputs amb la sortida dels programes que he fet i he publicat aquí.

# 2. Escalfament pre-nadalenc (preparació 2024)

Els problemes d'aquesta secció es poden trobar a la [pàgina de la programaMe](https://programame.com/documents/ProblemsSets/2024/ProgramaMe-2024-Navidad.pdf)) o bé en el [pdf pujat al repositori](/Escalfament%20PreNadalenc%202024/ProgramaMe-2024-Navidad.pdf).

## Problema A (Elegint la seu del mundial)

Valideu el problema i veieu l'enucniat aquí: [Problema A](https://aceptaelreto.com/problem/statement.php?id=709)
Penso que la millor forma de resoldre aquest problema, penso, és amb una estructura de dades que permeti emmagatzemar parelles de clau : valor per acumular dins cada país de forma eficient accedint a les claus de forma eficient. En python l'estructura de dades que implementa això són els els diccionaris (`dict`), i en C++ i Java tenim els map. 

Per al problema que ens ocupa podem implementar el map en java d'aquesta forma:

`Map<String, int> map_paisVots = new HashMap<String, int>();`

Cal aprendre moltes coses noves. Per fer-lo eficient he estat, literalment, dues hores! Per iterar un map podem fer servir la sintaxis for each i un cop tenim cada parell <strong>clau:valor</strong> podem accedir al seu contingut mitjançant les funcions `.getKey()` i `.getValue()`. Cal que noteu que cal declarar cada <strong>parell_clauValor</strong> com un `Map.Entry<String, Integer>` i quan iterem al `elMeuMap` no podem iterarlo de manera com feiem amb els tipus de dades primitius sino que cal cridar una funció, `elMeuMap.entrySet()`, que retorna un `Set` o conjunt d'objectes `Map.Entry` (objectes clau:valor). Així la sintaxis quedaria:

```
for (Map.Entry<String, Integer> parell_clauValor : elMeuMap.entrySet()) {                             
       String clau = parell_clauValor.getKey(); 
       int valor = parell_clauValor.getValue();
} 
```



El problema l'he resolt així:

https://github.com/blackcub3s/ProgramaMe/blob/35584fcbe66f34466e57c62ed98f0995b5fc5ba6/Escalfament%20PreNadalenc%202024/ProblemaA.java#L3-L73





## Problema B (Places disponibles per al mundial)

Aquest problema podeu validar-lo (i també veure'n l'enunciat) aquí a la pàgina d'aceptaElReto: [Problema B](https://aceptaelreto.com/problem/statement.php?id=710)

El problema B implica primer absorbir el primer enter de la seqüència d'entrada (que indica el nombre de casos de prova del mundial que inclou el test). Un cop fet això ja es pot anar a processar cada cas de prova (cada línia). En cada cas de prova es demana senzillament fer una diferència entre la suma dels equips assignats a les sis confederacions del mundial i el nombre d'equips E que participen en el mundial i imprimir-la per pantalla. La meva solució en java (no mostro l'import de l'Scanner, veure arxiu sencer):

https://github.com/blackcub3s/ProgramaMe/blob/d41cbd36ec54a9ed44250de4baa1bf9b5fc7b004/Escalfament%20PreNadalenc%202024/ProblemaB.java#L9-L34

La meva solució en C++, que no requereix netejar el búfer després de llegir tipus de dades primitius i requereix menys codi per fer-lo funcionar [^1]. 



https://github.com/blackcub3s/ProgramaMe/blob/aad3b0229793ab84210b2d8c770ae1f6af06df22/Escalfament%20PreNadalenc%202024/ProblemaB.cc#L1-L29




## Problema C




<!-- NOTES AL PEU DE PÀGINA -->
[^1]: Per exemple, en java ens cal instanciar un objecte de la classe Scanner `Scanner sc = new Scanner(System.in)` i ens cal cridar mètodes dinàmics de la mateixa `int varEntrada = sc.nextInt()` per introduir dades pel canal estàndard d'entrada; en canvi, en C++ només ens cal fer `#include <iostream>` i `cin >> varEntrada` després de declarar varEntrada com a entera. També es simplifica el canal estàndard de sortida: en comptes de `System.out.println(valor)` fem `cout << valor << endl`. Finalment, en C++ tampoc ens cal escriure el codi d'una classe ni la fila llarguíssima del main que requereix java `public static void main(String[] args)`, que es redueix a `int main() { //codi aqui    return 0;}`.
<!--FI NOTA AL PEU DE PÀGINA -->