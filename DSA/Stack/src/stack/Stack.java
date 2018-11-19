/*---------------------------------------------------
 * Hochschule fï¿½r Technik Stuttgart
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
 * Hausï¿½bung 3: ADT Stack
 * 
 * ------------------------------------------------*/

package stack;
/*
 * Aufgabe 1.a - Stack Implementierung als Array mit Exception-Handling
 * 
 * Vervollstï¿½ndigen Sie zunï¿½chst die Klasse Stack. Diese Klasse reprï¿½sentiert
 * einen Stack der beliebige Objekte aufnimmt.
 * Ergï¿½nzen Sie den Stack um eine Fehlerbehandlung fï¿½r leere und volle Stacks. 
 * Nutzen Sie dazu die beiden Fehlerklassen StackEmptyException und
 * StackFullException. Die Fehler sollen ausgelï¿½st werden, wenn eine Operation
 * einen Stackï¿½berlauf oder ï¿½unterlauf verursachen wï¿½rde.
 * Hinweis: dazu mï¿½ssen Sie die Signatur einiger Stack-Methoden anpassen.
 * 
 *  Aufgabe 1.b - Stack Implementierung als verkettete Liste mit Exception-Handling
 *  
 *  Bauen Sie die Klasse Stack wie in der Vorlesung dargestellt um, so dass die
 *  Datenhaltung statt in einem Array nun als verkettete Liste erfolgt.
 *  Nutzen Sie dazu die Klasse Link. Realisieren Sie die Methode toString so,
 *  dass der Stack beginnend mit dem untersten Element ausgegeben wird.
 *  Optimieren Sie den Stack so, dass alle Methoden (auï¿½er toString) nun die
 *  Komplexitï¿½t O(1) besitzen. 
 *  Zusatzaufgabe: Wie kï¿½nnten Sie die Methode toString ebenfalls mit O(1) realisieren? 
 */

public class Stack {

	Object[] stack = new Object[100];
	int stackPointer = 0;

	// Implementierung der Methoden hier ...

	public String version() { // gibt eine Versionsnummer zurï¿½ck
		// diese Methode dient dazu, die verschiedenen Implementierungen zu
		// unterscheiden;
		// fï¿½r jede neue Implementierung muss der Text angepasst werden.
		return "Aufgabe 1.a - Stack; Implementierung als Array mit Exception-Handling";
		// return "Version 1.b - Stack; Implementierung als verkettete Liste mit
		// Exception-Handling";
	}

	public Stack() {
		super();
	}

	public void empty() { // leert den Stack
		this.stackPointer = 0;		// setzt Stackpointer auf Index 0 zurück
	}

	public void push(Object element) throws StackFullException { // legt ein Element auf den Stack
		// Methoden ...
		if (!this.isFull()) {									// testet ob Stack voll ist 
			this.stack[this.stackPointer] = element;			// wenn nein -> element einfügen
			this.stackPointer += 1;								// und Stackpointer erhöhen
		} else
			throw new StackFullException();						// wenn ja -> Exception
	}

	public Object pop() throws StackEmptyException { // nimmt ein Element vom Stack
		// Methoden ...
		if (!this.isEmpty()) {								// testet ob der Stack leer ist
			this.stackPointer -= 1;							// wenn nein -> Stackpointer zurücksetzten 
			Object element = this.stack[this.stackPointer];
			return element;					
		} else									
			throw new StackEmptyException();				// wenn ja -> Exception
	}

	public int size() { // aktuelle Anzahl Elemente in Stack
		// Methoden ...
		return this.stackPointer;
	}

	public boolean isEmpty() { // ist der Stack leer?
		// Methoden ...
		if (this.stackPointer == 0)
			return true; // Dummy-Wert
		else
			return false;
	}

	public boolean isFull() { // ist der Stack voll?
		// Methoden ...
		if(this.stackPointer == this.stack.length)
			return true;
		else
			return false;
	}

	public Object peek() throws StackEmptyException { // liest oberstes Element vom Stack,
		// ohne es zu vom Stack zu entfernen
		// Methoden ...
		if(!this.isEmpty())
			return this.stack[this.stackPointer - 1];
		else throw new StackEmptyException();
	}

	public String toString() { // Gibt einen String aus, der den Stack reprï¿½sentiert;
								// Format: Wert1 Wert2 Wert3 [Top-Wert]
								// also z.B. 5 8 1 10 [9]
		// Methoden ...

		String result = new String();
		if (this.isEmpty()) {
			result = "[]";

		} else {
			for (int i = 0; i < this.stackPointer - 1; i++)
				result += this.stack[i] + " ";

			result += "[" + this.peek() + "]";

		}
		return result; // Dummy-Wert
	}

}
