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
	
	
	// Implementierung der Methoden hier ...
	
	
	public String version(){		// gibt eine Versionsnummer zur�ck
		// diese Methode dient dazu, die verschiedenen Implementierungen zu unterscheiden;
		// f�r jede neue Implementierung muss der Text angepasst werden.
			return "Aufgabe 1.a - Stack; Implementierung als Array mit Exception-Handling";
			// return "Version 1.b - Stack; Implementierung als verkettete Liste mit Exception-Handling";
		}
	
	public void empty(){			// leert den Stack
		//Methoden ...
	}
	
	public void push(Object element){	// legt ein Element auf den Stack
		//Methoden ...
	}

	public Object pop(){				// nimmt ein Element vom Stack
		//Methoden ...
		return null; // Dummy-Wert
	}
	
	public int size(){				// aktuelle Anzahl Elemente in Stack
		//Methoden ...
		return 0; // Dummy-Wert
	}
	
	public boolean isEmpty(){		// ist der Stack leer?
		//Methoden ...
		return true; // Dummy-Wert
	}
	
	public boolean isFull(){		// ist der Stack voll?
		//Methoden ...
		return true; // Dummy-Wert
	}
	
	public Object peek(){			// liest oberstes Element vom Stack, 
									// ohne es zu vom Stack zu entfernen
		//Methoden ...
		return null; // Dummy-Wert
	}

	
	public String toString(){		// Gibt einen String aus, der den Stack repr�sentiert;
									// Format: Wert1 Wert2 Wert3 [Top-Wert]
									//	also z.B. 5 8 1 10 [9]
		//Methoden ...
		return "[x]"; // Dummy-Wert
	}
	
}
