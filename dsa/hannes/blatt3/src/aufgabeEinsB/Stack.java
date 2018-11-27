/*---------------------------------------------------
 * Hochschule f�r Technik Stuttgart
 * Fachbereich Vermessung, Informatik und Mathematik
 * Schellingstr. 24
 * D-70174 Stuttgart
 *
 * Volker Coors, Markus Deininger
 * 17.10.2008
 *
 * Datenstrukturen und Algorithmen
 * SG Informatik und SG Informationslogistik
 *
 * Haus�bung 3: ADT Stack
 * 
 * ------------------------------------------------*/

package aufgabeEinsB;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/*
 * Aufgabe 1.a - Stack Implementierung als Array mit Exception-Handling
 * 
 * Vervollst�ndigen Sie zun�chst die Klasse Stack. Diese Klasse repr�sentiert
 * einen Stack der beliebige Objekte aufnimmt.
 * Erg�nzen Sie den Stack um eine Fehlerbehandlung f�r leere und volle Stacks. 
 * Nutzen Sie dazu die beiden Fehlerklassen StackEmptyException und
 * StackFullException. Die Fehler sollen ausgel�st werden, wenn eine Operation
 * einen Stack�berlauf oder �unterlauf verursachen w�rde.
 * Hinweis: dazu m�ssen Sie die Signatur einiger Stack-Methoden anpassen.
 * 
 *  Aufgabe 1.b - Stack Implementierung als verkettete Liste mit Exception-Handling
 *  
 *  Bauen Sie die Klasse Stack wie in der Vorlesung dargestellt um, so dass die
 *  Datenhaltung statt in einem Array nun als verkettete Liste erfolgt.
 *  Nutzen Sie dazu die Klasse Link. Realisieren Sie die Methode toString so,
 *  dass der Stack beginnend mit dem untersten Element ausgegeben wird.
 *  Optimieren Sie den Stack so, dass alle Methoden (au�er toString) nun die
 *  Komplexit�t O(1) besitzen. 
 *  Zusatzaufgabe: Wie k�nnten Sie die Methode toString ebenfalls mit O(1) realisieren? 
 */

public class Stack {
    String stringRepresentation = "[]";
    Link head;
    Link tail;
    int counter;

    public Stack() {
        tail = new Link();
        head = new Link();
        head.next = tail;
        counter = 0;
    }

    // Implementierung der Methoden hier ...

    public String version() { // gibt eine Versionsnummer zur�ck
        // diese Methode dient dazu, die verschiedenen Implementierungen zu
        // unterscheiden;
        // f�r jede neue Implementierung muss der Text angepasst werden.
        return "Aufgabe 1.b - Stack; Implementierung als verkettete Liste mit Exception-Handling";
        // return "Version 1.b - Stack; Implementierung als verkettete Liste mit
        // Exception-Handling";
    }

    public void empty() { // leert den Stack
        head = new Link();
        head.next = tail;
        counter = 0;
        stringRepresentation = "[]";
    }

    // keine Exception, "kann" nicht voll werden
    public void push(Object element) { // legt ein Element auf den Stack
        head.data = element;
        Link newHead = new Link();
        newHead.next = head;
        head = newHead;
        stringRepresentation = stringRepresentation.replace('[', ' ');
        stringRepresentation = stringRepresentation.replace(']', ' ');
        stringRepresentation += "[" + element + "]";
        counter++;
    }

    public Object pop() throws StackEmptyException { // nimmt ein Element vom Stack
        if (this.isEmpty()) {
            throw new StackEmptyException();
        }
        Link result = head.next;
        head = result;
        stringRepresentation = stringRepresentation.replaceAll("(\\S+)\\s+\\[\\S+\\]", "[$1]");
        counter--;
        if (isEmpty()) {
            stringRepresentation = "[]";
        }
        return result.data;
    }

    public int size() { // aktuelle Anzahl Elemente in Stack
        return counter; // Dummy-Wert
    }

    public boolean isEmpty() { // ist der Stack leer?
        if (head.next == tail) {
            return true;
        }
        return false;
    }

//    public boolean isFull() { // ist der Stack voll?
//        if (counter == 150) {
//            return true;
//        }
//        return false;
//    }

    public Object peek() { // liest oberstes Element vom Stack,
        if (isEmpty()) {
            throw new StackEmptyException();
        }
        return head.next.data;
    }

    // Gibt einen String aus, der den Stack repr�sentiert;
    // Format: Wert1 Wert2 Wert3 [Top-Wert]
//	also z.B. 5 8 1 10 [9]
    public String toString() {
        return stringRepresentation;
    }

}