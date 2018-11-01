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
/*
 * Die Exception soll ausgel�st werden, falls aus einem leeren Stack
 * das oberste Element gelesen oder geholt werden soll.
 */

public class StackEmptyException extends RuntimeException {
	
	public StackEmptyException(){
		super();
	}

}
