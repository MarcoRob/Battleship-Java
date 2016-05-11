import javax.swing.*;

import java.util.Random;
import java.util.Scanner;


public class Tablero {

	private Coordenada tablero[][];
	private boolean jugador;
	public Barco barcos[];
	private String tirosHechos[];
	
	public Tablero(boolean jugador) {
		this.jugador = jugador;
		this.tablero = new Coordenada[10][10];
		this.barcos = new Barco[4];
		this.tirosHechos = new String[100];
		
		for(int i=0; i<10; i++){ //asigna valores al tablero
			for(int j=0;j<10; j++){
				this.tablero[i][j]=new Coordenada(jugador);
			}
		}	
	}
	
	public Coordenada[][] getCoordenadas() {
		return this.tablero;
	}
	
	public boolean ganado(String name){
		//System.out.println("checando ganados"+this.jugador);
		int barcosHundidos = 0;
		for(int i = 0; i < this.barcos.length; i++){
			if(this.barcos[i].isHundido() ){
				barcosHundidos++;
			}
		}
		if(this.jugador){
			System.out.println("\nBarcos hundidos de "+name+": "+ barcosHundidos);
			if(barcosHundidos == this.barcos.length){
				return true;
			}
			else{
				return false;	
			}
		}
		else{
			System.out.println("\nBarcos hundidos de la PC: " + barcosHundidos);
			System.out.println("*Te faltan por hundir: "+ (this.barcos.length - barcosHundidos) + " barcos");
			if(barcosHundidos == this.barcos.length){
				return true;
			}
			else{
				return false;	
			}
		}
		
	}
	
	public void barcosHundidos(int fila, int columna){
		
		for(int i = 0; i < this.barcos.length; i++){
			if (this.barcos[i].checarHundido(fila, columna)) {
				if(this.jugador){ // barco hundido en tablero de jugador
					JOptionPane.showMessageDialog(null, "La PC te hundio un barco", "GAME INFO", JOptionPane.INFORMATION_MESSAGE);
				}
				else{ // barco hundido en tablero de la PC
					JOptionPane.showMessageDialog(null, "Hundiste un barco de la PC", "GAME INFO", JOptionPane.INFORMATION_MESSAGE);
				}
						
			}
		}
		
	}
	
	public  int calcFila(String a){
		if(a.equals("A")){     
			return 0;
		}
		else if(a.equals("B")){ 
			return 1;
		}
		else if(a.equals("C")){
			return 2;
		}
		else if(a.equals("D")){
			return 3;
		}
		else if(a.equals("E")){
			return 4;
		}
		else if(a.equals("F")){
			return 5;
		}
		else if(a.equals("G")){
			return 6;
		}
		else if(a.equals("H")){
			return 7;
		}
		else if(a.equals("I")){
			return 8;
		}
		else if(a.equals("J")){
			return 9;
		}
		else{
			return -1;
		}	
	}
	
	public void imprimirArrClave(int fila){
		for(int i=0;i<10;i++){
			System.out.print(tablero[fila][i].clave());
			if(i == 9){
				System.out.print(" ║ ");
			}
			else{
				System.out.print(" ║ ");
			}
		}
		System.out.println();
	}
	
	public void imprimirArray(int fila){ //imprime el array de fila por fila 
		for(int i=0;i<10;i++){
			System.out.print(tablero[fila][i].toString());
			if(i == 9){
				System.out.print(" ║ ");
			}
			else{
				System.out.print(" ║ ");
			}
		}
		System.out.println();
	}
	public void printTablero(String name){
		String grid = "Tablero de: ";
		if(this.jugador){
			grid += name;
			System.out.println("\n" + grid);
		}
		else{
			grid += "PC (computadora)";
			System.out.println("\n" + grid);
		}
		if(name.equals("Salinas") || name.equals("Edgar") || name.equals("Gerardo")){
			String[] letras = {"A", "B" , "C", "D","E", "F","G","H","I","J"};
			System.out.println("    ╔═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╗ ");
			System.out.println("    ║ 1 ║ 2 ║ 3 ║ 4 ║ 5 ║ 6 ║ 7 ║ 8 ║ 9 ║ 10║	");
			System.out.println("╔═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
			
			
			for(int i = 0; i<9; i++){
				System.out.print("║ "+letras[i] + " ║ ");
				this.imprimirArrClave(i);
				System.out.println("╠═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
			}
			System.out.print("║ " + letras[9]+ " ║ ");
			this.imprimirArrClave(9);
			System.out.println("╚═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╝ ");
		}
		else{
			String[] letras = {"A", "B" , "C", "D","E", "F","G","H","I","J"};
			System.out.println("    ╔═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╗ ");
			System.out.println("    ║ 1 ║ 2 ║ 3 ║ 4 ║ 5 ║ 6 ║ 7 ║ 8 ║ 9 ║ 10║	");
			System.out.println("╔═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
			
			
			for(int i = 0; i<9; i++){
				System.out.print("║ "+letras[i] + " ║ ");
				this.imprimirArray(i);
				System.out.println("╠═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
			}
			System.out.print("║ " + letras[9]+ " ║ ");
			this.imprimirArray(9);
			System.out.println("╚═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╝ ");
		}
		
	}

	
	private void generarBarcos(){ //genera Barcos de PC con posicionarRandom() de Barco
		Barco a;
		for(int i=2; i <= 5;i++){
			 a = new Barco(i, this);
			 a.posicionarRandom();
			 this.barcos[i-2] = a;
		}
	}
	
	public boolean generarBarco(int longitud, int fila, int columna, boolean orientacion){ //genera nuestros barcos con las cordenadas que le demos
		Barco a = new Barco(longitud, this);
		boolean posicionado = a.posicionar(fila, columna, orientacion);
		if(posicionado){
			this.barcos[longitud-2] = a;
		}
		return posicionado; 
	}
	
	private void generarTiroComputadora() {
		Random random = new Random();
		int fila = random.nextInt(10);
		int columna = random.nextInt(10);
		String tiro = "" + fila + "" + columna;
		for(int i = 0; i < this.tirosHechos.length; i++){
			if(this.tirosHechos[i] != null){
				if(this.tirosHechos[i].equals(tiro)){
					fila = random.nextInt(10);
					columna = random.nextInt(10);
					tiro = ""+fila+""+columna;
					i = 0;
				}
			}
			else{ 
				break;
			}	
		}
		for(int i=0;i<this.tirosHechos.length;i++){
			if(this.tirosHechos[i] == null){
				this.tirosHechos[i] = tiro;
				break;
			}
		}
		this.disparar(fila, columna);
		
	}

	public int disparar(int fila, int columna){
		if(this.jugador){
			int a = this.tablero[fila][columna].disparo();
			if(a == 0){
				JOptionPane.showMessageDialog(null, "TIRO PC\n-Fallo la PC\n\nTU TURNO");
				//.out.println("No se habia disparado ahi y no hay barco");
			}
			else if(a == 1){
				JOptionPane.showMessageDialog(null, "TIRO PC\n-Te dieron\n\nTU TURNO");
				//System.out.println("No se habia disparado ahi y si hay barco");
		
				this.barcosHundidos(fila, columna);
			}
			else{
				JOptionPane.showMessageDialog(null, "TIRO PC\n-Ya habia disparado ahi la PC\n\nTU TURNO");
			}
			return a;
		}
		else{
			int a = this.tablero[fila][columna].disparo();
			if(a == 0){
				JOptionPane.showMessageDialog(null, "DISPARO JUGADOR\n-Fallaste\n\nTurno de la PC");
				//.out.println("No se habia disparado ahi y no hay barco");
			}
			else if(a == 1){
				JOptionPane.showMessageDialog(null, "DISPARO JUGADOR\n-Le diste\n\nTurno de la PC");
				//System.out.println("No se habia disparado ahi y si hay barco");
				this.barcosHundidos(fila, columna);
			}
			else{
				JOptionPane.showMessageDialog(null, "DISPARO JUGADOR\n-Ya habias disparado ahi\n\nTurno de la PC");
				//System.out.println("Ya se disparo ahi");
			}
			return a;
		}
	}
	
	public static void main(String[] args) {
		Tablero jugador1=new Tablero(true);
		Tablero computadora= new Tablero(false);

		
		JOptionPane.showMessageDialog(null, "Bienvenido a Batalla Naval","BATALLA NAVAL", JOptionPane.INFORMATION_MESSAGE);
		String name = JOptionPane.showInputDialog("Nombre del Jugador: ");	
		JOptionPane.showMessageDialog(null, "Instrucciones:\n 1. Jugaras 1 vs 1 contra la computadora\n 2. Escoge entre colocar tus barcos o ponerlos random\n 3. La PC tendra el primer turno, luego tu seguiras disparando hasta TENER UN VENCENDOR \n 4. OK para continuar","BATALLA NAVAL", JOptionPane.INFORMATION_MESSAGE);
		int askPoner = Integer.parseInt(JOptionPane.showInputDialog("Elige:\n1) Colocar mis barcos\n2) Generar mis barcos Random "));	
		
		//NOMBRE JUGADOR	
		String newName = "";
		char First = name.charAt(0);
		newName = (First+"").toUpperCase() + name.substring(1,name.length());
		
		
		//COLOCAR BARCOS PC RANDOM
		JOptionPane.showMessageDialog(null, "Colocando barcos de la PC ","BATALLA NAVAL", JOptionPane.INFORMATION_MESSAGE);
		computadora.generarBarcos();
		computadora.printTablero(newName);
		
		Scanner scan = new Scanner(System.in);
		String[] nombresBarco = {"Patrol", "Sub","Destroyer","Aircraft" };
		if(askPoner == 1){
			JOptionPane.showMessageDialog(null, "Vamos a colocar tus barcos\n*Recuerda: Tienes 4 barcos de long. diferentes (2,3,4,5) ","BATALLA NAVAL", JOptionPane.INFORMATION_MESSAGE);	
			for(int i=2; i<=5; i++){
				
				System.out.println("Dame las coordenadas de tu barco "+ nombresBarco[i-2]+ " (long. de "  + i + " unidades)" +"Formato: <fila(A-J)>, <columna(1-10)>, <orientacion(V/H)> ex. A,2,V");
				//do{
				String barcoNuevo = scan.nextLine();
				String barcoNuevoUp = barcoNuevo.toUpperCase();
				String barco[] = barcoNuevoUp.split(",");
					
				int fila = jugador1.calcFila(barco[0]);
				int columna = Integer.parseInt(barco[1])-1;
				
				boolean ori = false;
				if(barco[2].equals("H")){
					ori = true;
				}
				else{
					ori = false;
				}
				if(barco.length != 3 || (!barco[2].equals("H") && !barco[2].equals("V")) || fila == -1 || (columna < 0 || columna > 9)  ){
					JOptionPane.showMessageDialog(null, "Â¡Imposible situarlo ahi! \nVuelve a dar las coordenadas","GAME INFO", JOptionPane.INFORMATION_MESSAGE);
					//System.out.println("Imposible situarlo ahi vuelve a dar las coordenadas");
					i--;
				}
				else if(!jugador1.generarBarco(i, fila, columna, ori)){
					JOptionPane.showMessageDialog(null, "!Imposible situarlo ahi! \nVuelve a dar las coordenadas ya que coliciona con otro barco o se sale del tablero","GAME INFO", JOptionPane.INFORMATION_MESSAGE);
					//System.out.println("Imposible situarlo ahi vuelve a dar las coordenadas ya que coliciona con otro barco o se sale del tablero");
					i--;
				}
					
				jugador1.printTablero(newName);
					
				}
		}
		else{
			
			jugador1.generarBarcos();
			jugador1.printTablero(newName);
		}
		
		JOptionPane.showMessageDialog(null, " Listo "+ newName.toUpperCase()+", ¡empieza la batalla! \nLa computadora empieza disparando...","GAME INFO", JOptionPane.INFORMATION_MESSAGE);
		//System.out.println("Listo para empezar la batalla, la computadora empieza disparando...");
		boolean turno = true;
		while(!jugador1.ganado(newName) && !computadora.ganado(newName)){
			if(turno){ //tira la computadora
				jugador1.generarTiroComputadora();
				turno = false;
			}
			else{  //tira el jugador 
				
				System.out.println("\nDame las coordenadas de tu tiro ----> Formato: <fila(A-J)>, <columna(1-10)> ex. A,2");
				String tiro = scan.nextLine();
				String tiroUp = tiro.toUpperCase();
		        String tiroS[] = tiroUp.split(",");
				int fila = jugador1.calcFila(tiroS[0]);
				int columna = Integer.parseInt(tiroS[1])-1;
				if(tiroS.length != 2 || fila == -1 || (columna < 0 || columna >  9)){
					JOptionPane.showMessageDialog(null,"IMPOSIBLE TIRAR EN ESAS COORDENADAS","GAME INFO", JOptionPane.INFORMATION_MESSAGE); 
				}
				else{
					computadora.disparar(fila, columna);
					turno=true;
				}
			}
			jugador1.printTablero(newName);
			computadora.printTablero(newName);

		}
		
		if(jugador1.ganado(newName)){
			JOptionPane.showMessageDialog(null,"       PERDISTE\nNO LOGRASTE DERROTAR A LA COMPUTADORA","GAME INFO", JOptionPane.INFORMATION_MESSAGE); 
			System.out.println("PERDISTE, NO LOGRASTE DERROTAR A LA COMPUTADORA");
		} else{
			JOptionPane.showMessageDialog(null,"FELICIDADES LOGRASTE DERROTAR A LA COMPUTADORA","GAME INFO", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("FELICIDADES LOGRASTE DERROTAR A LA COMPUTADORA");
		}
		scan.close();
	}
	
}
