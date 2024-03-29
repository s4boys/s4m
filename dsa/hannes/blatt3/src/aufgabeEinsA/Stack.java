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

package aufgabeEinsA;

import java.util.Arrays;

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
    private static final int ARRAY_SIZE = 150;

    Object storage[];
    int counter;

    public Stack() {
        storage = new Object[ARRAY_SIZE];
        counter = 0;
    }

    // Implementierung der Methoden hier ...

    public String version() {
        return "Aufgabe 1.a - Stack; Implementierung als Array mit Exception-Handling";
    }

    public void empty() { // leert den Stack
        counter = 0;
    }

    public void push(Object element) throws StackFullException { // legt ein Element auf den Stack
        if (!this.isFull()) {
            storage[counter] = element;
            counter++;
        } else
            throw new StackFullException();
    }

    public Object pop() throws StackEmptyException { // nimmt ein Element vom Stack
        if (!this.isEmpty()) {
            counter--;
            Object temp = storage[counter];
            return temp;
        } else
            throw new StackEmptyException();
    }

    public int size() { // aktuelle Anzahl Elemente in Stack
        return counter; // Dummy-Wert
    }

    public boolean isEmpty() { // ist der Stack leer?
        return (counter == 0);
    }

    public boolean isFull() { // ist der Stack voll?
        return (counter == storage.length);
    }

    public Object peek() throws StackEmptyException{ // liest oberstes Element vom Stack,
        // ohne es zu vom Stack zu entfernen
        if(!isEmpty()) {
            return storage[counter-1];
        } else {
            throw new StackEmptyException();
        }
    }

    // Gibt einen String aus, der den Stack repr�sentiert;
    // Format: Wert1 Wert2 Wert3 [Top-Wert]
//	also z.B. 5 8 1 10 [9]
    public String toString() {
        String result = "";
        if (!this.isEmpty()) {

            for (int i = 0; i < counter - 1; i++) {
                result += storage[i] + " ";
            }
            result += "[" + storage[counter - 1] + "]";
        } else {
            result = "[]";
        }
        return result; // Dummy-Wert
    }
}
