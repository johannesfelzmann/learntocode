Fragensammlung VoWi:

________________________________________________________________________________________________________________________
Datenabstraktion:

Welche der folgenden Aussagen gelten in Java für die unterschiedlichen Arten von Variablen und Parametern?

	Formale Parameter und lokale Variablen können gleich heißen.            F
	Lokale Referenzvariablen werden automatisch vorinitialisiert.           F
	Lokale Variablen werden mit private deklariert.                         F
	Klassenvariablen werden bei der Objekterzeugung angelegt.               F
	Klassenvariablen werden mit static deklariert.                          T
	Objektvariablen und lokale Variablen können gleich heißen.              T
	Objektvariablen werden automatisch vorinitialisiert.                    T
	Objektvariablen werden bei der Objekterzeugung angelegt.                T

Welche der folgenden Aussagen treffen auf Objektmethoden bzw. Klassenmethoden zu?

	Aufrufe von this(...) sind nur in Objektmethoden erlaubt.               F
	In Klassenmethoden bezeichnet this die aktuelle Klasse.                 F
	In Klassenmethoden darf this nicht vorkommen.                           T
	Jede Methode f() aus einer Klasse C ist durch C.f() aufrufbar.          F
	Jede nicht als static deklarierte Methode ist eine Objektmethode.       T
	Klassenmethoden haben keinen Zugriff auf Objektvariablen.               T
	Objektmethoden haben keinen Zugriff auf Klassenvariablen.               F
	Objektmethoden haben Zugriff auf Objekt- und Klassenvariablen.          T    

Welche der folgenden Aussagen stimmen in Bezug auf Datenabstraktion?

	Das Resultat ist ein abstrakter Datentyp.                               T
	Data-Hiding behindert die Datenabstraktion.                             F
	Datenabstraktion verhindert Änderungen von Objektzuständen.             F
	Datenkapselung fügt Variablen und Methoden zu einer Einheit zusammen.   T
	Datenkapselung ist ein anderer Begriff für Data-Hiding.                 F
	Datenkapselung und Data-Hiding sind für Datenabstraktion nötig.         T
	Klassen implementieren abstrakte Datentypen.                            T
	Kommentare sind in abstrakten Datentypen bedeutungslos.                 F

Welche der folgenden Aussagen müssen für jede Verwendung von this(...) bzw. this in einem Konstruktor zutreffen?

    this(...); darf nur als erste Anweisung vorkommen.                      T    
    this(...); darf nur als letzte Anweisung vorkommen.                     F
    this darf in Konstruktoren nicht verwendet werden.                      F
    this ist nur in static Konstruktoren verwendbar.                        F
    this = null; darf nur als erste Anweisung vorkommen.                    F
    this referenziert das Objekt, das gerade initialisiert wird.            T
    Wird this(...); aufgerufen, gibt es keinen Default-Konstruktor.         T
    Zu Beginn gilt: this == null.                                           F

________________________________________________________________________________________________________________________
Datenstrukturen:

Welche der folgenden Aussagen stimmen in Bezug auf die unterschiedlichen Arten 
linearer und assoziativer Datenstrukturen?

	Assoziative Datenstrukturen erlauben wahlfreie Zugriffe.                T
	Assoziative Datenstrukturen haben wie Arrays eine fixe Größe.           F
	Assoziative Datenstrukturen verwenden Schlüssel zur Adressierung.       T
	Einträge in Queues sind nach Schlüsseln sortiert.                       F
	put(k,v) gibt null zurück wenn der Schlüssel k schon existiert.         F
	Die Methodennamen push und pop weisen auf LIFO-Verhalten hin.           T
	Double-Ended-Queues können auch wie Stacks verwendet werden.            T
	Assoziative Datenstrukturen haben LIFO- oder FIFO-Verhalten.            F

Welche der folgenden Aussagen stimmen in Bezug auf rekursive Datenstrukturen?

	Doppelt verkettete Listen sind in beide Richtungen traversierbar.       T
	Fortschritt erfolgt durch induktiven Aufbau und Dereferenzierung.       T
	Auch zyklische Datenstrukturen müssen fundiert sein.                    T
	Zur Fundierung können spezielle Knoten verwendet werden.                T
	Zur Fundierung wird meist null verwendet.                               T
	Jeder Knoten, der mehrere Knoten referenziert, ist Teil eines Baums.    F
	Schleifen erlauben kein vollständiges Traversieren.                     F
	
Welche der folgenden Aussagen stimmen in Bezug auf die Unterscheidung 
zwischen Datenstrukturen und abstrakten Datentypen?
    
    Abstrakte Datentypen beschreiben vorwiegend Schnittstellen.             T
    Abstrakte Datentypen implementieren Algorithmen.                        F
    Abstrakte Datentypen lassen verwendete Algorithmen meist offen.         T
    Abstrakte Datentypen müssen bestimmte Datenstrukturen festlegen.        F
    Abstrakte Datentypen spezifizieren Typen von Methoden-Parametern.       T    
    Datenstrukturen beschreiben, wie Operationen auf Daten zugreifen.       T
    Datenstrukturen lassen offen, wie Daten zusammenhängen.                 F
    Datenstrukturen legen die Typen ihrer Einträge fest.                    F
    Datenstrukturen sind unabhängig von bestimmten Programmiersprachen.     T
    Jede Datenstruktur hat eine festgelegte Maximalgröße.                   F
    
a sei eine Variable mit einer leeren assoziativen Datenstruktur, wobei Schlüssel und Werte vom Typ String sind 
(und null sein können). X und Y seien zwei voneinander verschiedene String-Konstanten (static final). 
Nach welchen der folgenden Aufruf-Sequenzen liefert a.get(X) den String in Y als Ergebnis?

	a.put(a.get(X), a.get(Y)); a.put(X, X); a.put(Y, Y);                    F
	a.put(X, X); a.put(a.get(X), a.get(Y)); a.put(Y, Y);                    F
	a.put(X, X); a.put(Y, Y); a.put(a.get(X), a.get(Y));                    T
	a.put(X, X); a.put(Y, Y); a.put(a.get(Y), a.get(X));                    F
	a.put(X, Y); a.put(a.get(Y), a.get(X)); a.put(Y, X);                    T
	a.put(X, Y); a.put(X, X); a.put(a.get(X), a.get(Y));                    F
	a.put(X, Y); a.put(Y, X); a.put(a.get(X), a.get(Y));                    T
	a.put(Y, X); a.put(a.get(Y), a.get(X)); a.put(X, Y);                    T
	a.put(Y, X); a.put(X, Y); a.put(a.get(Y), a.get(X));                    T
	
x, y und z seien Objektreferenzen ungleich null. Welche der folgenden Bedingungen müssen für jede Implementierung 
der Methoden boolean equals(Object obj) und int hashCode() in Java gelten?
    
    Aus x.equals(y) folgt x.hashCode() == y.hashCode().                     T
    Aus !x.equals(y) folgt x.hashCode() != y.hashCode().                    F
    Aus x.equals(y) folgt y.equals(x).                                      T 
    Aus !x.equals(y) folgt !y.equals(x).                                    T       
    Aus x.equals(y) folgt !y.equals(x).                                     F
    null.equals(null) gibt true zurück.                                     F   
    x.equals(null) gibt false zurück.                                       T
    x.hashCode() >= 0 gibt true zurück.                                     F
    Aus x.hashCode() == y.hashCode() folgt x.equals(y).                     F
    null.equals(x) gibt false zurück.                                       F

t sei eine Variable mit einem einfachen (unbalancierten) binären Suchbaum ganzer Zahlen, der durch diese Anweisungen 
aufgebaut wurde: STree t = new STree(); t.add(4); t.add(9); t.add(7); Welche der folgenden Aussagen treffen auf t zu?

	Der Baum hat eine Tiefe von 2.                                          F
	Der Baum hat eine Tiefe von 3.                                          T    
    Der Knoten mit Wert 7 hat zumindest ein Kind.                           F            
	Der Knoten mit Wert 7 ist die Wurzel.                                   F
	Der Knoten mit Wert 7 ist ein Blattknoten.                              T
	Der Knoten mit Wert 9 hat zumindest ein Kind.                           T
	Der Knoten mit Wert 9 ist ein Blattknoten.                              F

t sei eine Variable mit einem einfachen (unbalancierten) binären Suchbaum ganzer Zahlen, der durch diese Anweisungen 
aufgebaut wurde: STree t = new STree(); t.add(7); t.add(9); t.add(4); Welche der folgenden Aussagen treffen auf t zu?

	Der Baum hat eine Tiefe von 2.                                          T    
	Der Baum hat eine Tiefe von 3.                                          F
	Der Knoten mit Wert 7 ist die Wurzel.                                   T
	Der Knoten mit Wert 7 ist ein Blattknoten.                              F
	Der Knoten mit Wert 9 ist ein Blattknoten.                              T

x sei eine Referenz auf einen Knoten (Typ Node) in einer einfach verketteten Liste mit mindestens 
einem existierenden Nachfolger (in der Objektvariablen next). Welche der folgenden Anweisungs-Sequenzen 
entfernen den direkten Nachfolger von x aus einer Liste, ändern sonst aber nichts?

	x.next.next.next = x.next.next;                                         F
	Node n = x.next.next; n.next = x;                                       F
	Node d = x.next; d = d.next;                                            F        
	Node d = x.next; x.next = d.next;                                       T
	Node n = x.next.next; x.next = n;                                       T    

________________________________________________________________________________________________________________________
Dynamische und statische Bindung:

Welche der folgenden Aussagen stimmen in Bezug auf dynamisches und statisches Binden?

	Bei statischem Binden kennt der Compiler die auszuführende Methode.     T
	Dynamisches Binden ist zusammen mit Untertypbeziehungen nötig.          T
	Ein dynamischer Typ ist stets eine Klasse, kein Interface.              T
	Ein statischer Typ ist stets ein Interface, keine Klasse.               F
	Klassenmethoden werden immer dynamisch gebunden.                        F    
	Objektmethoden werden immer dynamisch gebunden.                         F
	Objektmethoden werden in deklarierten Typen von Objekten ausgeführt.    F
	Private Methoden werden immer statisch gebunden.                        T
	Objektmethoden werden in dynamischen Typen von Objekten ausgeführt.     T
	Ein statischer Typ ist stets ein Interface, keine Klasse.               F

R, S und T seien Referenztypen. Welche der folgenden Aussagen treffen zu?

	Aus R Untertyp von S und S Untertyp von T folgt: R Untertyp von T.      T
	Aus S ist Klasse und T ist Interface folgt: S ist Untertyp von T.       F
	Aus S Untertyp von T folgt: Kommentare in S und T sind gleich.          F
	Aus S Untertyp von T und T Untertyp von S folgt: S.class==T.class.      T
	T ist Untertyp von T.                                                   T
	
S und T seien Referenztypen, sodass der Compiler folgenden Programmtext fehlerfrei compiliert: 
T x = new S(); x.foo(); Welche der folgenden Aussagen treffen für alle passenden S, T, x und foo() zu?

	Die Methode foo() muss in S vorkommen, in T aber nicht.                 F
	Durch x.foo() wird die Methode in S ausgeführt.                         T
	Es gilt: x.getClass() == T.class                                        F
	Kommentare zu foo() in T müssen auch auf foo() in S zutreffen.          T
	S ist Untertyp von T.                                                   T
	
T sei ein Referenztyp (Klasse oder Interface), und x sei eine durch R x = new S(); deklarierte Variable, 
wobei der Compiler keinen Fehler meldet. Welche der folgenden Aussagen treffen für alle passenden R, S, T und x zu?

	Mit S ist Untertyp von T gilt: ((T)x).getClass() == R.class             F
	Mit S ist Untertyp von T gilt: ((T)x).getClass() == S.class             T
	Mit S ist Untertyp von T gilt: ((T)x).getClass() == T.class             F
	(T)null liefert zur Laufzeit keinen Fehler.                             T
	(T)x ändert den deklarierten Typ von x auf T.                           T
	(T)x liefert keinen Laufzeitfehler wenn R Untertyp von T ist.           T    
	(T)x liefert Laufzeitfehler wenn T nicht Untertyp von R ist.            F
	(T)x liefert Laufzeitfehler wenn S nicht Untertyp von T ist.            T
	(T)x ändert den dynamischen Typ von x auf T.                            F
		
T sei ein Referenztyp (Klasse oder Interface), und x sei eine Variable eines Referenztyps mit x != null. 
Welche der folgenden Aussagen treffen für alle T und x zu?

	Aus x instanceof T folgt x.getClass() == T.class.                       F
	Aus x.getClass() == T.class folgt x instanceof T.                       T        
	Gilt x.getClass() == T.class, dann ist T eine Klasse.                   T
	Gilt x instanceof T, dann ist T der deklarierte Typ von x.              F
	Gilt x instanceof T, dann ist T der dynamische Typ von x.               F
	Gilt x instanceof T, dann ist T eine Klasse.                            F
	x.getClass() liefert (interne Repr. vom) deklarierten Typ von x.        F    
	x.getClass() liefert (interne Repr. vom) dynamischen Typ von x.         T
			
________________________________________________________________________________________________________________________
Probetest 1:

    new MCQuestion(
            "Welche der folgenden Aussagen treffen auf Objektmethoden bzw. Klassenmethoden zu?",
    
            new Choice(true, "In Objektmethoden bezeichnet  this  das aktuelle Objekt."),
            new Choice(true, "Objektmethoden haben Zugriff auf Objekt- und Klassenvariablen."),
            new Choice(true, "Klassenmethoden haben keinen Zugriff auf Objektvariablen."),
            new Choice(true, "In Klassenmethoden darf  this  nicht vorkommen."),
            new Choice(true, "Jede nicht als  static  deklarierte Methode ist eine Objektmethode.")
    ),
    
    new MCQuestion(
            "s sei eine Variable mit einem leeren Stack ganzer Zahlen.\n" +
            "Nach welchen der folgenden Aufruf-Sequenzen liefert  s.peek()  die Zahl  1  als Ergebnis?",
    
            new Choice(false, "s.push(3); s.push(1); s.push(2);"),
            new Choice(false, "s.push(1); s.push(2); s.push(3);"),
            new Choice(false, "s.push(1); s.push(2); s.push(s.peek());"),
            new Choice(false, "s.push(1); s.push(s.peek()); s.push(2);"),
            new Choice(false, "s.push(1); s.push(2); s.push(s.pop());")
    ),
    
    new MCQuestion(
            "x sei eine Referenz auf einen Knoten (Typ Node) in einer einfach verketteten Liste\n" +
            "mit mindestens einem existierenden Nachfolger (in der Objektvariablen next).\n" +
            "Welche der folgenden Anweisungs-Sequenzen entfernen den direkten Nachfolger von x\n" +
            "aus einer Liste, ändern sonst aber nichts?",
    
            new Choice(true, "x.next = x.next.next;"),
            new Choice(false, "x.next.next = x.next.next.next;"),
            new Choice(false, "x.next.next = x.next;"),
            new Choice(true, "Node n = x.next.next; x.next = n;"),
            new Choice(false, "Node d = x.next; d = d.next;")
    ),
    
    new MCQuestion(
            "Welche der folgenden Aussagen stimmen in Bezug auf rekursive Datenstrukturen?",
    
            new Choice(true, "Doppelt verkettete Listen sind in beide Richtungen traversierbar."),
            new Choice(true, "Zur Fundierung wird meist  null  verwendet."),
            new Choice(true, "Auch zyklische Datenstrukturen müssen fundiert sein."),
            new Choice(false, "Eine Datenstruktur ist rekursiv wenn ihre Methoden rekursiv sind."),
            new Choice(false, "Schleifen erlauben kein vollständiges Traversieren.")
    ),
    
    new MCQuestion(
            "Welche der folgenden Aussagen stimmen in Bezug auf dynamisches und statisches Binden?",
    
            new Choice(false, "Objektmethoden werden immer dynamisch gebunden."),
            new Choice(false, "Ein dynamischer Typ ist stets eine Klasse, kein Interface."),
            new Choice(true, "Dynamisches Binden ist zusammen mit Untertypbeziehungen nötig."),
            new Choice(false, "Objektmethoden werden in deklarierten Typen von Objekten ausgeführt."),
            new Choice(false, "'final' Methoden werden immer dynamisch gebunden.")
    )
    
    new MCQuestion(
            "x, y und z seien Objektreferenzen ungleich null.\n" +
            "Welche der folgenden Bedingungen müssen für jede Implementierung der Methoden\n" +
            "boolean equals(Object obj)  und  int hashCode()  in Java gelten?",

            new Choice(false, "null.equals(x)  gibt  false  zurück."),
            new Choice(false, "null.equals(null)  gibt  true  zurück."),
            new Choice(false, "x.hashCode() >= 0  gibt  true  zurück."),
            new Choice(true, "Aus  !x.equals(y)  folgt  !y.equals(x)."),
            new Choice(true, "Aus  x.equals(y)  und  x.equals(z)  folgt  y.equals(z).")
    ),

    new MCQuestion(
            "q sei eine Variable, die eine leere Double-Ended-Queue ganzer Zahlen enthält.\n" +
            "Nach welchen der folgenden Aufruf-Sequenzen liefert  q.peekFirst()\n" +
            "die Zahl  1  als Ergebnis?",

            new Choice(false, "q.addFirst(1); q.addFirst(2); q.pollFirst();"),
            new Choice(false, "q.addLast(3); q.addLast(2); q.addLast(1);"),
            new Choice(true, "q.addLast(1); q.addLast(2); q.pollLast();"),
            new Choice(false, "q.addFirst(1); q.addFirst(2);"),
            new Choice(false, "q.addFirst(1); q.addFirst(2); q.pollLast();")
    ),
	
________________________________________________________________________________________________________________________
Test 2:

Welche der folgenden Aussagen treffen in Bezug auf Algorithmen und Datenstrukturen zu?

	Absicherung gegen schlechte Datenverteilung kann die Laufzeit erhöhen.          T
	Arrays sind sehr effizient wenn normale Arrayzugriffe ausreichen.               T
	Bei unbekannter Datenverteilung gehen wir von Zufallsverteilung aus.            F
	Ein AVL-Baum ist stets effizienter als ein einfacher Suchbaum.                  F
	Lineare Listen sind einfach zu implementieren.                                  T
	
Welche der folgenden Aussagen treffen auf die Ein- und Ausgabe über Streams in Java zu?

	'new FileWriter(s)' erzeugt einen gepufferten Stream.                           F
	'new FileWriter(s)' wirft eine IOException wenn s schon existiert.              F
	Ausgaben über gepufferte Streams gehen direkt an das Betriebssystem.            F    
	Puffer können als Wrapper vor nichtgepufferte Streams gehängt werden.           T
	Viele Methoden von PrintStream werfen keine IOException.                        T
	Streams vom Typ Reader wandeln die Kodierung automatisch um.                    T
	Streams werden nach der Verwendung mittels close() geschlossen.                 T
	Gepufferte Streams sind meist effizienter als ungepufferte.                     T

Welche der folgenden Aussagen treffen auf Schleifen und Schleifeninvarianten zu?

	Die Abbruchbedingung kann nicht Teil einer Schleifeninvariante sein.            T
	Durch Schleifeninvarianten werden Schleifen im Debugger iterierbar.             F    
	Eine Schleifeninvariante beschreibt, was jede Iteration ändert.                 F
	Schleifeninvarianten garantieren den Fortschritt jeder Iteration.               F
	Schleifeninvarianten helfen dabei, Programme statisch zu verstehen.             T
	Schleifeninvarianten müssen auch vor und nach der Schleife gelten.              T
	Schleifeninvarianten müssen vor jedem Methodenaufruf erfüllt sein.              F
	Termination muss unabhängig von Schleifeninvarianten geprüft werden.            T

Welche der folgenden Aussagen treffen auf das Testen großer Programme zu?

	Anwender sind wegen möglicher Verfälschungen nicht einzubeziehen.               F
	Auch intensives Testen kann nicht alle Fehler aufdecken.                        T
	Eine Code-Review hilft beim Auffinden von Fehlerursachen.                       T
	Experten für Softwaresicherheit sollen einbezogen werden.                       T
	Debugger eignen sich zum Aufdecken fast aller Fehlerursachen.                   F
	Regressions-Tests müssen fast immer händisch durchgeführt werden.               F
	White-Box-Testen legt Testfälle vor der Implementierung fest.                   F
	White-Box-Testen leitet Testfälle aus der Implementierung ab.                   T
	Black-Box-Testen leitet Testfälle aus Anwendungsfällen ab.                      T
	Mit absichtlichen Fehlern ist die Qualität des Testens prüfbar.                 T

public int median(int[] a) { return a[a.length / 2]; }
Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen dieser Methode sinnvoll sein?

	Nachbedingung: Gibt einen Eintrag etwa in der Mitte von a zurück.               T
	Nachbedingung: Setzt voraus, dass a mindestens einen Eintrag hat.               F
	Nachbedingung: Wirft eine Exception wenn a.length == 0.                         T    
	Nachbedingung: Halbiert die Länge von a.                                        F
	Vorbedingung: a != null                                                         T
	Vorbedingung: a ist absteigend sortiert.                                        T
	Vorbedingung: a ist aufsteigend sortiert.                                       T
	Vorbedingung: Gibt den Median zurück wenn a sortiert ist.                       F
	Vorbedingung: Greift auf einen Eintrag von a zu.                                F
	Vorbedingung: Wirft eine Exception wenn a == null.                              F

Welche der folgenden Aussagen treffen auf Iteratoren in Java zu?

	Lineare Listen sind meist einfacher iterierbar als Binärbäume.                  T
	Mehrere Iteratoren auf dem gleichen Objekt stören sich gegenseitig.             F
	Iterator-Implementierungen sind eigene Klassen.                                 T
	Iterator-Implementierungen bestimmen die Reihenfolge der Iterationen.           T
	Iteratoren über Bäume sind häufig rekursiv implementiert.                       F
	
Welche der folgenden Aussagen treffen auf die notwendige Überprüfung von Eingabedaten zu?

	Alle Parameter einer Methode müssen in der Methode überprüft werden.            F
	Die Validierung soll erst möglichst knapp vor der Ausgabe erfolgen.             F
	Java-Objekte vom Typ Pattern lesen nur überprüfte Daten ein.                    F
	Plausibilitätsprüfungen sollen direkt nach der Eingabe erfolgen.                T
	Reparaturversuche nicht plausibler Daten können gefährlich sein.                T
	Unzureichende Prüfung kann z.B. zu einer SQL-Injection führen.                  T
	Nicht validierbare Daten reparieren wir direkt nach der Eingabe.                F
	Reguläre Ausdrücke können Prüfungen von Datenformaten vereinfachen.             T
	
Welche der folgenden Aussagen treffen auf Klassen und Interfaces im Java-Collections-Framework zu?

	Einträge in einem TreeSet<E> sind sortiert (über Iterator sichtbar).            T              
	Set<E> erweitert Collection<E>, verbietet aber mehrfache Einträge.              T
	Map<K,V> implementiert Set<K> als balancierten binären Suchbaum.                F
	ArrayDeque<E> erweitert ArrayList<E> um die Methoden von Deque<E>.              F
	In eine Queue<E> kann man neben add auch mittels offer einfügen.                T
	LinkedHashMap<K,V> ist sowohl Hash-Tabelle als auch lineare Liste.              T
	LinkedList<E> implementiert Deque<E> als doppeltverkettete Liste.               T
	LinkedList<E> implementiert Set<E> als einfachverkettete Liste.                 F
	
Welche der folgenden Aussagen treffen auf die Einhaltung von Zusicherungen entsprechend Design-by-Contract zu?

	Clients müssen für die Einhaltung von Invarianten sorgen.                       F
	Clients müssen für die Einhaltung von Nachbedingungen sorgen.                   F
	Clients können sich auf die Einhaltung von Nachbedingungen verlassen.           T
	Invarianten müssen zu ausnahmslos jedem Zeitpunkt erfüllt sein.                 F
	Server müssen für die Einhaltung ihrer Nachbedingungen sorgen.                  T
	Server müssen für die Einhaltung ihrer Vorbedingungen sorgen.                   F
	Server müssen für die Einhaltung ihrer Invarianten sorgen.                      T
	Server können sich auf die Einhaltung ihrer Vorbedingungen verlassen.           T
	Server können sich auf die Einhaltung ihrer Nachbedingungen verlassen.          F
	
Welche der folgenden Hoare-Tripel gelten (für Anweisungen in Java)?

	{true} x = y<z ? y : z; {x>=y}                                                  F
	{y>0} while (x>0) x--; {y>0}                                                    T
	{true} x=0; {x>=0}                                                              T                                                             
	{x>0} while (x>0) x--; {x>0}                                                    F
	{true} x++; {x>=0}                                                              F
	
________________________________________________________________________________________________________________________
Probetest 2:

    new MCQuestion(
            "Welche der folgenden Aussagen treffen auf Klassen und Interfaces im\n" +
            "Java-Collections-Framework zu?",
    
            new Choice(true, "LinkedHashMap<K,V> ist sowohl Hash-Tabelle als auch lineare Liste."),
            new Choice(true, "Set<E> erweitert Collection<E>, verbietet aber mehrfache Einträge."),
            new Choice(true, "LinkedList<E> implementiert Deque<E> als doppeltverkettete Liste."),
            new Choice(false, "LinkedList<E> implementiert Set<E> als einfachverkettete Liste."),
            new Choice(true, "Einträge in einem TreeSet<E> sind sortiert (über Iterator sichtbar).")
    ),
    
    new MCQuestion(
            "Welche der folgenden Aussagen treffen auf die Ein- und Ausgabe über Streams in Java zu?",
    
            new Choice(true, "Puffer können als Wrapper vor nichtgepufferte Streams gehängt werden."),
            new Choice(false, "Ausgaben über gepufferte Streams gehen direkt an das Betriebssystem."),
            new Choice(true, "Streams vom Typ Reader wandeln die Kodierung automatisch um."),
            new Choice(true, "Gepufferte Streams sind meist effizienter als ungepufferte."),
            new Choice(true, "Streams werden nach der Verwendung mittels close() geschlossen.")
    ),
    
    new MCQuestion(
            "Welche der folgenden Aussagen treffen auf die Einhaltung von Zusicherungen\n" +
            "entsprechend Design-by-Contract zu?",
    
            new Choice(true, "Server können sich auf die Einhaltung ihrer Vorbedingungen verlassen."),
            new Choice(false, "Server müssen für die Einhaltung ihrer Vorbedingungen sorgen."),
            new Choice(false, "Clients müssen für die Einhaltung von Invarianten sorgen."),
            new Choice(false, "Server können sich auf die Einhaltung ihrer Nachbedingungen verlassen."),
            new Choice(false, "Clients müssen für die Einhaltung von Nachbedingungen sorgen.")
    ),
    
    new MCQuestion(
            "public int median(int[] a) { return a[a.length / 2]; } \n" +
            "Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
            "dieser Methode sinnvoll sein?",
    
            new Choice(false, "Vorbedingung: Gibt den Median zurück wenn a sortiert ist."),
            new Choice(true, "Vorbedingung: a ist aufsteigend sortiert."),
            new Choice(false, "Vorbedingung: Greift auf einen Eintrag von a zu."),
            new Choice(true, "Nachbedingung: Gibt einen Eintrag etwa in der Mitte von a zurück."),
            new Choice(false, "Nachbedingung: Halbiert die Länge von a.")
    ),
    
    new MCQuestion(
            "Welche der folgenden Aussagen treffen auf das Testen großer Programme zu?",
    
            new Choice(false, "Debugger eignen sich zum Aufdecken fast aller Fehlerursachen."),
            new Choice(true, "Experten für Softwaresicherheit sollen einbezogen werden."),
            new Choice(true, "Eine Code-Review hilft beim Auffinden von Fehlerursachen."),
            new Choice(true, "Black-Box-Testen leitet Testfälle aus Anwendungsfällen ab."),
            new Choice(true, "Mit absichtlichen Fehlern ist die Qualität des Testens prüfbar.")
    )	
    
     new MCQuestion(
            "Welche der folgenden Aussagen treffen auf Ausnahmen und Ausnahmebehandlungen in Java zu?",
            
            new Choice(true, "Ausnahmen vom Typ Error werden in der Regel nicht abgefangen."),
            new Choice(true, "Das Java-Laufzeitsystem wirft nur überprüfte Ausnahmen."),
            new Choice(false, "Überprüfte Ausnahmen sind vom Typ RuntimeException oder Error."),
            new Choice(false, "'Propagieren einer Ausnahme' bedeutet: 'Ausnahme wird abgefangen'."),
            new Choice(false, "Nur nach Programmabbruch kann ein Stack-Trace ausgegeben werden.")
    ),
	
	
	
	
	

