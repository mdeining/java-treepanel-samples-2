package main;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

//Sie erhalten eine HTML-Dokumentation diser Klasse, 
//wenn Sie den Befehl "javadoc Input.java" in dem Verzeichnis 
//dieser Klasse ausf�hren. �ffnen Sie die damit erzeugte 
//Datei "index.html" in Ihrem Browser

/** Klassenmethoden zur einfachen Eingabe und Erzeugung von Daten in java.
 * Die Daten k�nnen entweder �ber die Tastatur eingegeben oder
 * zuf�llig generiert werden. <p>
 * Bisher werden die folgenden, primitiven Datentypen unterst�tzt:
 * String, int, float, double, char, boolean;<p>
  * <p>
 * @author Marcus Deininger
 *  * abge�ndert duch:
 * @author Kevin Brandner
 * @version 2.2.1 / 08.10.2009
 */

public class Input {
	
	private static Random Generator = new Random();
	
	private Input(){
		//keine explizite Erzeugung der Klasse
	}

	/**
	 * Liest eine Zeile als String von der Tastatur ein;
	 * Die Eingabe wird durch &lt;return&gt; beendet.
	 * @return Die eingegebene Zeile
	 */
	public static String readString(){
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader buffer = new BufferedReader(in);
		String input = "";
		try {
			input = buffer.readLine();
		} catch ( IOException e) {
			e.printStackTrace();
		}
		return input;
	}
	
	/**
	 * Liest eine Zeile von der Tastatur ein und zerlegt die Eingabe 
	 * an den Leerr�umen in Teilstrings. Die Eingabe wird durch &lt;return&gt; beendet.
	 * @return Ein Feld mit den eigegebenen Strings
	 */
	public static String[] readStringVector(){
		String input = readString();
		String[] tokens = input.split(" +");
		return tokens;
	}
	
	
	/**
	 * Wandelt einen <tt>String</tt> in einen <tt>int</tt>-Wert um.
	 */
	private static int toInt(String input){
		int value = Integer.parseInt(input);
		return value;		
	}

	/**
	 * Liest einen <tt>int</tt>-Wert von der Tastatur ein.
	 * Die Eingabe wird durch &lt;return&gt; beendet.
	 * @return Der eingelesene Wert
	 */
	public static int readInt(){
		String input = readString();
		int value = toInt(input);
		return value;
	}

	
	
	/**
	 * Wandelt einen <tt>String</tt> in einen <tt>Long</tt>-Wert um.
	 */
	private static Long toLong(String input){
		Long value = Long.parseLong(input);
		return value;		
	}

	/**
	 * Liest einen <tt>Long</tt>-Wert von der Tastatur ein.
	 * Die Eingabe wird durch &lt;return&gt; beendet.
	 * @return Der eingelesene Wert
	 */
	public static Long readLong(){
		String input = readString();
		Long value = toLong(input);
		return value;
	}

	/**
	 * Liest einen <tt>int</tt>-Vektor von der Tastatur ein. 
	 * Die einzelnen Werte werden durch Leerzeichen getrennt. 
	 * Die Eingabe wird durch &lt;return&gt; beendet.
	 * @return Der eingelesene Vektor
	 */
	public static int[] readIntVector(){
		String[] tokens = readStringVector();
		int[] vector = new int[tokens.length];
		for(int i = 0; i < vector.length;i++)
			vector[i] = toInt(tokens[i]);
		return vector;
	}

	/**
	 * Erzeugt einen zuf�lligen <tt>int</tt>-Wert.
	 * @param von untere Grenze
	 * @param bis obere Grenze
	 * @return Der erzeugte Wert
	 */
	public static int randomInt(int von, int bis){
		int bereich = bis - von + 1;			// normierter Bereich
		int zahl = Generator.nextInt(bereich);	// Zufallszahl zwischen 0 und bereich - 1
		int ergebnis = bis - zahl;				// zur�ck transformieren
		return ergebnis;
	}

	/**
	 * Erzeugt einen zuf�llig besetzen <tt>int</tt>-Vektor mit der vorgegebenen L�nge.
	 * @param laenge die L�nge des zu erzeugenden Vektors
	 * @param von untere Grenze der Zufallszahlen
	 * @param bis obere Grenze der Zufallszahlen
	 * @return Der erzeugte Vektor
	 */
	public static int[] randomIntVector(int laenge, int von, int bis){
		int[] result = new int[laenge];
		for (int i = 0; i < laenge; i++)
			result[i] = randomInt(von, bis);
		return result;
	}

	/**
	 * Wandelt einen <tt>String</tt> in einen <tt>float</tt>-Wert um.
	 */
	private static float toFloat(String input){
		float value = Float.parseFloat(input);
		return value;
	}

	/**
	 * Liest einen <tt>float</tt>-Wert von der Tastatur ein.
	 * Die Eingabe wird durch &lt;return&gt; beendet.
	 * @return Der eingelesene Wert
	 */
	public static float readFloat(){
		String input = readString();
		float value = toFloat(input);
		return value;
	}

	/**
	 * Liest einen <tt>float</tt>-Vektor von der Tastatur ein. 
	 * Die einzelnen Werte werden durch Leerzeichen getrennt. 
	 * Die Eingabe wird durch &lt;return&gt; beendet.
	 * @return Der eingelesene Vektor
	 */
	public static float[] readFloatVector(){
		String[] tokens = readStringVector();
		float[] vector = new float[tokens.length];
		for(int i = 0; i < vector.length;i++)
			vector[i] = toFloat(tokens[i]);
		return vector;
	}

	/**
	 * Erzeugt einen zuf�lligen <tt>float</tt>-Wert.
	 * @param von untere Grenze
	 * @param bis obere Grenze
	 * @return Der erzeugte Wert
	 */
	public static float randomFloat(float von, float bis){
		float zahl = Generator.nextFloat(); 		// Zufallszahl zwischen 0.0 und 1.0
		float ergebnis = zahl * (bis - von) + von;	// auf Bereich transformieren
		return ergebnis;
	}

	/**
	 * Erzeugt einen zuf�llig besetzen <tt>float</tt>-Vektor mit der vorgegebenen L�nge.
	 * @param laenge die L�nge des zu erzeugenden Vektors
	 * @param von untere Grenze der Zufallszahlen
	 * @param bis obere Grenze der Zufallszahlen
	 * @return Der erzeugte Vektor
	 */
	public static float[] randomFloatVector(int laenge, float von, float bis){
		float[] result = new float[laenge];
		for (int i = 0; i < laenge; i++)
			result[i] = randomFloat(von, bis);
		return result;
	}

	/**
	 * Wandelt einen <tt>String</tt> in einen <tt>double</tt>-Wert um.
	 */
	private static double toDouble(String input){
		double value = Double.parseDouble(input);
		return value;
	}

	/**
	 * Liest einen <tt>double</tt>-Wert von der Tastatur ein.
	 * Die Eingabe wird durch &lt;return&gt; beendet.
	 * @return Der eingelesene Wert
	 */
	public static double readDouble(){
		String input = readString();
		double value = toDouble(input);
		return value;
	}

	/**
	 * Liest einen <tt>double</tt>-Vektor von der Tastatur ein. 
	 * Die einzelnen Werte werden durch Leerzeichen getrennt. 
	 * Die Eingabe wird durch &lt;return&gt; beendet.
	 * @return Der eingelesene Vektor
	 */
	public static double[] readDoubleVector(){
		String[] tokens = readStringVector();
		double[] vector = new double[tokens.length];
		for(int i = 0; i < vector.length;i++)
			vector[i] = toDouble(tokens[i]);
		return vector;
	}

	/**
	 * Erzeugt einen zuf�lligen <tt>double</tt>-Wert.
	 * @param von untere Grenze
	 * @param bis obere Grenze
	 * @return Der erzeugte Wert
	 */
	public static double randomDouble(double von, double bis){
		double zahl = Generator.nextDouble(); 		// Zufallszahl zwischen 0.0 und 1.0
		double ergebnis = zahl * (bis - von) + von;	// auf Bereich transformieren
		return ergebnis;
	}

	/**
	 * Erzeugt einen zuf�llig besetzen <tt>double</tt>-Vektor mit der vorgegebenen L�nge.
	 * @param laenge die L�nge des zu erzeugenden Vektors
	 * @param von untere Grenze der Zufallszahlen
	 * @param bis obere Grenze der Zufallszahlen
	 * @return Der erzeugte Vektor
	 */
	public static double[] randomDoubleVector(int laenge, double von, double bis){
		double[] result = new double[laenge];
		for (int i = 0; i < laenge; i++)
			result[i] = randomDouble(von, bis);
		return result;
	}


	
	/**
	 * Wandelt einen <tt>String</tt> in einen <tt>char</tt>-Wert um.
	 * Dabei wird das erste Zeichen des Strings genommen. Ist der
	 * String l�nger als ein Zeichen, wird eine Exception ausgel�st.
	 */
	private static char toChar(String input){
		if (input.length() != 1) throw new RuntimeException();
		char value = input.charAt(0);
		return value;
	}

	/**
	 * Liest einen <tt>char</tt>-Wert von der Tastatur ein.
	 * Die Eingabe wird durch &lt;return&gt; beendet.
	 * @return Der eingelesene Wert
	 */
	public static char readChar(){
		String input = readString();
		char value = toChar(input);
		return value;
	}
	
	/**
	 * Liest einen <tt>char</tt>-Vektor von der Tastatur ein. 
	 * Die einzelnen Werte werden durch Leerzeichen getrennt. 
	 * Die Eingabe wird durch &lt;return&gt; beendet.
	 * @return Der eingelesene Vektor
	 */
	public static char[] readCharVector(){
		String[] tokens = readStringVector();
		char[] vector = new char[tokens.length];
		for(int i = 0; i < vector.length;i++)
			vector[i] = toChar(tokens[i]);
		return vector;
	}

	/**
	 * Erzeugt einen zuf�lligen <tt>char</tt>-Wert zwischen ASCII(33) und ASCII(127).
	 * Das sind die sichtbaren ASCII-Zeichen ohne Zeilenumbruch.
	 * @return Der erzeugte Wert
	 */
	public static char randomChar(){
		//Sichtbare Zeichen,ohne Zeilenumbruch
		return (char)randomInt(33, 126);
	}

	/**
	 * Erzeugt einen zuf�llig besetzen <tt>char</tt>-Vektor mit der vorgegebenen L�nge.
	 * Die Werte liegen zwischen ASCII(33) und ASCII(127).
	 * Das sind die sichtbaren ASCII-Zeichen ohne Zeilenumbruch.
	 * @param laenge die L�nge des zu erzeugenden Vektors
	 * @return Der erzeugte Vektor
	 */
	public static char[] randomCharVector(int laenge){
		char[] result = new char[laenge];
		for (int i = 0; i < laenge; i++)
			result[i] = randomChar();
		return result;
	}
	

	/**
	 * Wandelt einen <tt>String</tt> in einen <tt>boolean</tt>-Wert um.
	 * M�gliche Eingaben sind <tt>t</tt>, <tt>true</tt>, <tt>f</tt>, 
	 * oder <tt>false</tt> (unabh�ngig von Gro�- und Kleinschreibung).
	 */
	private static boolean toBoolean(String input){		
		if(input.equalsIgnoreCase("t")) return true;
		if(input.equalsIgnoreCase("true")) return true;
		if(input.equalsIgnoreCase("f")) return false;
		if(input.equalsIgnoreCase("false")) return false;

		throw new RuntimeException();
	}

	/**
	 * Liest einen <tt>boolean</tt>-Wert von der Tastatur ein.
	 * Boolsche Werte k�nnen durch <tt>t</tt>, <tt>true</tt>, <tt>f</tt>, 
	 * oder <tt>false</tt> (unabh�ngig
	 * von Gro�- und Kleinschreibung) eingegeben werden.
	 * Die Eingabe wird durch &lt;return&gt; beendet.
	 * @return Der eingelesene Wert
	 */
	public static boolean readBoolean(){
		String input = readString();
		boolean value = toBoolean(input);
		return value;
	}
	
	/**
	 * Liest einen <tt>boolean</tt>-Vektor von der Tastatur ein. 
	 * Boolsche Werte k�nnen durch <tt>t</tt>, <tt>true</tt>, <tt>f</tt>, 
	 * oder <tt>false</tt> (unabh�ngig
	 * von Gro�- und Kleinschreibung) eingegeben werden.
	 * Die einzelnen Werte werden durch Leerzeichen getrennt. 
	 * Die Eingabe wird durch &lt;return&gt; beendet.
	 * @return Der eingelesene Vektor
	 */
	public static boolean[] readBooleanVector(){
		String[] tokens = readStringVector();
		boolean[] vector = new boolean[tokens.length];
		for(int i = 0; i < vector.length;i++)
			vector[i] = toBoolean(tokens[i]);
		return vector;
	}

	
	/**
	 * Erzeugt einen zuf�lligen <tt>boolean</tt>-Wert.
	 * @return Der erzeugte Wert
	 */
	public static boolean randomBoolean(){
		return randomInt(0, 1) == 1;
	}

	/**
	 * Erzeugt einen zuf�llig besetzten <tt>booelan</tt>-Vektor mit der vorgegebenen L�nge.
	 * @param laenge die L�nge des zu erzeugenden Vektors
	 * @return Der erzeugte Vektor
	 */
	public static boolean[] randomBooleanVector(int laenge){
		boolean[] result = new boolean[laenge];
		for (int i = 0; i < laenge; i++)
			result[i] = randomBoolean();
		return result;
	}
	

	

}
