# 1. INTRODUCCIÓ

En aquest repositori es resoldran problemes de la competició ProgramaMe. Tots els problemes pujats estan validats amb AC (_accepted_ o acceptat) fent servir el validador de la pàgina web https://aceptaelreto.com/ que implementa solucions als mateixos i compara els outputs amb la sortida dels programes que he fet i he publicat aquí, a menys que s'indiqui el contrari en el comentari del problema (si en algun cas no és acceptat diré quin error s'ha produït i per què no s'ha pogut fer funcionar). Cada problema té al titol un link a la pàgina mencionada, que conté el compilador per fer la validació del codi del qui l'intenti i una còpia de l'enunciat.

# 2. Escalfament pre-nadalenc (preparació 2024)

Els problemes d'aquesta secció es poden trobar a la [pàgina de la programaMe](https://programame.com/documents/ProblemsSets/2024/ProgramaMe-2024-Navidad.pdf)) o bé en el [pdf pujat al repositori](/Escalfament%20PreNadalenc%202024/ProgramaMe-2024-Navidad.pdf).

## [Problema A (Elegint la seu del mundial)](https://aceptaelreto.com/problem/statement.php?id=709)

Penso que la millor forma de resoldre aquest problema és mitjançant una estructura de dades que permeti emmagatzemar parelles de clau : valor de forma eficient, acumulant així per a cada cas de prova el nombre d'ocurrències -vots- que cada país té (és una parella clau -país- i valor -nombre d'ocurrències-). En Python l'estructura de dades que permet implementar aquesta solució són els diccionaris (`dict`), i en C++ i Java tenim els map (d'estructura molt més complicada que els diccionaris de Python).

En Java, podem declarar un map d'aquesta manera:

`Map<String, int> elMeuMap = new HashMap<String, int>();`

Per iterar a través d'un map podem fer servir la sintaxis for-each de la que ens proveeix Java i, un cop tenim cada parell <strong>clau:valor</strong> podem accedir al seu contingut mitjançant les funcions `getKey()` i `getValue()`. Cal fer notar que és necessari declarar cada <strong>parell_clauValor</strong> com un `Map.Entry<String, Integer>` i que quan iterem `elMeuMap` no podem iterarlo de manera com fèiem amb els tipus de dades primitius, sinó que ens cal cridar una funció en l'objecte que conté el nostre map `elMeuMap.entrySet()`, que retorna un `Set` o conjunt d'objectes `Map.Entry` (objectes clau:valor). 

Així doncs, la sintaxis per iterar un map quedaria de la següent manera:

```
for (Map.Entry<String, Integer> parell_clauValor : elMeuMap.entrySet()) {                             
       String clau = parell_clauValor.getKey(); 
       int valor = parell_clauValor.getValue();
} 
```

Cal també esmentar com crear un nou parell clau:valor dins d'un map, per una banda; i com accedir a un valor a partir d'una clau dins el diccionari, per l'altra. Per aconseguir la creació d'un nou parell farem servir la funció put(): així doncs `elMeuMap.put(clau, valor)` afegirà un parell clau:valor al diccionari. D'altra banda, per accedir al valor que tingui el diccionari per clau `clau` farem `elMeuMap.get(clau)`.

Finalment cal esmentar que en aquest problema és necessari l'ús de la funció `sc.next()` que permet consumir del canal estàndard d'entrada la següent paraula d'una linia d'strings (nextline en canvi consumiria tota una línia i no ens permetria resoldre bé el problema). 
El problema l'he resolt així:

https://github.com/blackcub3s/ProgramaMe/blob/35584fcbe66f34466e57c62ed98f0995b5fc5ba6/Escalfament%20PreNadalenc%202024/ProblemaA.java#L3-L73





## [Problema B (Places disponibles per al mundial)](https://aceptaelreto.com/problem/statement.php?id=710)



El problema B implica primer absorbir el primer enter de la seqüència d'entrada (que indica el nombre de casos de prova del mundial que inclou el test). Un cop fet això ja es pot anar a processar cada cas de prova (cada línia). En cada cas de prova es demana senzillament fer una diferència entre la suma dels equips assignats a les sis confederacions del mundial i el nombre d'equips E que participen en el mundial i imprimir-la per pantalla. La meva solució en java (no mostro l'import de l'Scanner, veure arxiu sencer):

https://github.com/blackcub3s/ProgramaMe/blob/d41cbd36ec54a9ed44250de4baa1bf9b5fc7b004/Escalfament%20PreNadalenc%202024/ProblemaB.java#L9-L34

La meva solució en C++, que no requereix netejar el búfer després de llegir tipus de dades primitius i requereix menys codi per fer-lo funcionar [^1]. 



https://github.com/blackcub3s/ProgramaMe/blob/aad3b0229793ab84210b2d8c770ae1f6af06df22/Escalfament%20PreNadalenc%202024/ProblemaB.cc#L1-L29




## [Problema C (Verificació de les entrades)](https://aceptaelreto.com/problem/statement.php?id=711)

Aquest problema no és tant complicat com el problema A. Tot i així, sí que té una petita complicació: cal saber carregar cada un dels casos de prova (nombres) com a strings i accedir a cada un dels digits d'aquests nombres individualment. Per fer aquest accés cal saber passar de char a enter. Hi ha dues formes de fer-ho: una, seria amb la funció `int n = Character.getNumericValue(nre.charAt(i));`; l'altra seria fer servir una funció comuna que permet convertir un string a enter, i per a fer-ho ens caldrà passar el char a String amb un truquet (concatenar un char amb un String buit ens permet obtenir un string!) i aleshores podrem utilitzar funcions ben conegudes que converteixin d'String a enter sense saber-nos les funcions que converteixen de Char a enter, així: `int n = Integer.parseInt(""+nre.charAt(i));`.

Aquest exercici també té la dificultat de recórrer les cadenes a l'esquerra i a la dreta del nombre en qüestió (cosa que he disseccionat en sengles funcions fora del main) i de vigilar què és posició parell d'un digit dins el nombre del cas de prova (index senar, si indexem des de zero) o posició senar d'un digit dins el nombre del cas de prova (index parell, si indexem des de zero):

https://github.com/blackcub3s/ProgramaMe/blob/8c9db2b48edfde816eb743478d3d55c0973071d7/Escalfament%20PreNadalenc%202024/ProblemaC.java#L7-L53

## [Problema D (Events dels partits)](https://aceptaelreto.com/problem/statement.php?id=712)

Aquest problema no el va enviar ningú quan es va fer el repte de l'escalfament pre-nadalenc (un repte amb més de 900 persones i amb poc temps per resoldre tots els problemes). Era, doncs, un problema visiblement complicat. La solució que proposo aquí funciona per al cas de prova proporcionat a l'enunciat de la web d'aceptaelreto, però es prega al lector prendre la solució amb cautela ja que el programa aquí mostrat dóna error de límit de temps excedit en enviar-lo al servidor de comprovació (TLE -_Time limit exceeded_-). Entenc que el problema no es produeix perquè la solució programada estigui innerentment mal programada, sino perquè la funció `sc.hasNextInt()` no funciona com seria d'esperar. No he aconseguit que aturi la sequència d'entrada de valors `N`, que és incerta ja que depèn del nombre de casos de prova i no ens els informen ni ens donen una senyal d'aturada de la seqüència d'entrada: això fa que el programa es quedi esperant un altre nombre i no s'aturari fins que no entri un caràcter NO numèric (cosa que mai tindrem als casos de prova). Si es pogués corregir aquest aspecte segurament funcionaria.

En la solució que jo proposo s'aconsegueix tenir en compte els casos de prova amb casos particulars com  `N==1` (un sol esdeveniment per partit, que a la pràctica és estrany, però es podria donar en els tests que facin per comprovar el nostre programa) i `N > 1` (més d'un esdeveniment per partit). També tinc en compte quan només es fa una consulta per a un esdeveniment del partit (`q == 1`), cridant exclusivament a la funció `fesSortidaPerConsulta_igual_a_1()`; també considero els casos en que `q > 1` tot fent ús de la funció `fesSortidaPerConsulta_amb_q_superior_a_1()`. Es aquesta última funció la que té un comportament un tant complicat: fer una finestra de q espais que es vagi desplaçant d'esquerra a dreta al llarg del vector `v` mirant el temps que passa entre l'esdeveniment inicial de la finestra i el següent, entre el següent i el tercer, i així successivament fins arribar al que ocupa la posició `q` (v el fem servir per guardar els diferents moments temporals on es van produint els events durant el partit). Després, aquesta finestra la mourem a la dreta una unitat i repetirem el procés anterior. D'aquest procés iteratiu, de cada finestra, ens guardem en una variable `tqMin` el temps mínim que passa fins a recorrer els `q` esdeveniments i la posició inicial `iMaxDens` per trobar un cop acabem de recórrer tot `v`amb la finestra l'esdeveniment inicial que dóna peu a la regió amb `q` esdeveniments amb _màxima densitat_. 




https://github.com/blackcub3s/ProgramaMe/blob/6475385f22f524f7732a35f38497e55ad9e6cf41/Escalfament%20PreNadalenc%202024/ProblemaD%20(corregir%20error%20massa%20temps%20execucio).java#L9-L100



## [Problema E (Fase de grups)](https://aceptaelreto.com/problem/statement.php?id=713)

TO DO


## [Problema F (Fase final)](https://aceptaelreto.com/problem/statement.php?id=714)

El progrema F l'he resolta




<!-- NOTES AL PEU DE PÀGINA -->
[^1]: Per exemple, en java ens cal instanciar un objecte de la classe Scanner `Scanner sc = new Scanner(System.in)` i ens cal cridar mètodes dinàmics de la mateixa `int varEntrada = sc.nextInt()` per introduir dades pel canal estàndard d'entrada; en canvi, en C++ només ens cal fer `#include <iostream>` i `cin >> varEntrada` després de declarar varEntrada com a entera. També es simplifica el canal estàndard de sortida: en comptes de `System.out.println(valor)` fem `cout << valor << endl`. Finalment, en C++ tampoc ens cal escriure el codi d'una classe ni la fila llarguíssima del main que requereix java `public static void main(String[] args)`, que es redueix a `int main() { //codi aqui    return 0;}`.
<!--FI NOTA AL PEU DE PÀGINA -->