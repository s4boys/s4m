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

package stack;
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

public class Stack{
	
	Object[] stack = new Object[100];
	int stackPointer = 0;
	
	// Implementierung der Methoden hier ...
	
	
	
	
	public String version(){		// gibt eine Versionsnummer zur�ck
		// diese Methode dient dazu, die verschiedenen Implementierungen zu unterscheiden;
		// f�r jede neue Implementierung muss der Text angepasst werden.
			return "Aufgabe 1.a - Stack; Implementierung als Array mit Exception-Handling";
			// return "Version 1.b - Stack; Implementierung als verkettete Liste mit Exception-Handling";
		}
	
	public Stack() {
		super();
	}

	public void empty(){			// leert den Stack
	this.stackPointer = 0;	
	}
	
	public void push(Object element) throws StackFullException{	// legt ein Element auf den Stack
		//Methoden ...
		this.stack[this.stackPointer] = element;
		this.stackPointer += 1;
	}

	public Object pop() throws StackEmptyException{				// nimmt ein Element vom Stack
		//Methoden ...
		this.stackPointer -= 1;
		Object element = this.stack[this.stackPointer];
		return element; 
	}
	
	public int size(){				// aktuelle Anzahl Elemente in Stack
		//Methoden ...
		return this.stackPointer; 
	}
	
	public boolean isEmpty(){		// ist der Stack leer?
		//Methoden ...
		if(this.stackPointer == 0)
			return true; // Dummy-Wert
		else
			return false;
	}
	
	public boolean isFull(){		// ist der Stack voll?
		//Methoden ...
		
		return true; // Dummy-Wert
	}
	
	public Object peek() throws StackEmptyException{			// liest oberstes Element vom Stack, 
									// ohne es zu vom Stack zu entfernen
		//Methoden ...
		return this.stack[this.stackPointer-1];
	}

	
	public String toString(){		// Gibt einen String aus, der den Stack repr�sentiert;
									// Format: Wert1 Wert2 Wert3 [Top-Wert]
									//	also z.B. 5 8 1 10 [9]
		//Methoden ...
		
		String result = new String();
		if(this.isEmpty()){
			result = "[]";
			
		} else {
			for(int i = 0; i < this.stackPointer-1; i++)
				result += this.stack[i] + " ";
			
			result += "[" + this.peek() + "]";
			
			
		}
		return result; // Dummy-Wert
	}
	
}
