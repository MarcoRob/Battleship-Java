import java.util.Random;


public class Barco {
	private Tablero tablero;
	private int fila,
				columna,
				longitud,
				HP;
	private boolean posicion,
					hundido;
	
	
	public Barco(int longitud, Tablero tablero){
		this.tablero = tablero;
		this.longitud = this.HP = longitud;
		this.hundido = false;
		//this.checkHits = 0;
		
	}
	
	public boolean isHundido() {
		return this.hundido;
	}

	public void setHundido() {
		this.hundido = true;
	}
	

	public boolean checarHundido(int fila, int columna){
		//int longCount = 0;
		if(tablero.getCoordenadas()[fila][columna].isContieneBarco()){
			if(this.posicion()){//horizontal
				for(int j = this.columna; j < this.columna+this.longitud; j++){
					if(j == columna && this.fila == fila){
						this.hit();
						if(this.HP == 0) {
							this.setHundido();
							return true;
						}
					}
				}
			}
			else{ //vertical
				for(int j = this.fila; j < this.fila+this.longitud; j++){
					if(this.columna == columna && j == fila){
						this.hit();
						if(this.HP == 0) {
							this.setHundido();
							return true;
						}
					}
				}
			}	
		}
		return false;
	}
	
	
	private boolean posicion(){
		//true/horizontal --------- false/vertical
		return this.posicion;
	}
	
	public void hit() {
		this.HP--;
	}
		
	public void posicionarRandom(){
		//orientacion
		Random random = new Random();
		this.posicion = random.nextInt(2) == 0;
		if(this.posicion){	
			this.posicion = true;
		}
		else{
			this.posicion = false;
			}
		
		boolean posicionado = false;
		while(!posicionado){
			this.fila = random.nextInt(10);
			this.columna = random.nextInt(10);
			if(this.posicion){ //es horizontal
				if((this.columna+this.longitud) < 10){
					boolean contieneBarco = false;
					for(int i = this.columna; i < this.columna+this.longitud; i++){
						if(tablero.getCoordenadas()[fila][i].isContieneBarco()){
							contieneBarco = true;
						}
					}
					if(!contieneBarco){
						for(int i = this.columna; i < this.columna+this.longitud; i++){
							tablero.getCoordenadas()[fila][i].setContieneBarco(true);
						}
						posicionado = true;
					}
						
				}
			}
			else{ //es vertical
				if((this.fila+this.longitud) < 10){
					boolean contieneBarco = false;
					for(int i = this.fila; i < this.fila+this.longitud; i++){
						if(tablero.getCoordenadas()[i][columna].isContieneBarco()){
							contieneBarco = true;
						}
					}
					if(!contieneBarco){
						for(int i = this.fila ; i < this.fila+this.longitud; i++){
							tablero.getCoordenadas()[i][columna].setContieneBarco(true);
						}
						posicionado = true;
					}
					
				}
			}
		}
	}
	
	
	public boolean posicionar(int fila, int columna, boolean orientacion){
		this.posicion = orientacion;
		boolean posicionado = false;
		this.fila = fila;
		this.columna = columna;
			if(this.posicion){ //es horizontal
				if((this.columna+this.longitud) <= 10){
					boolean contieneBarco = false;
					for(int i = this.columna; i < this.columna+this.longitud; i++){
						if(tablero.getCoordenadas()[fila][i].isContieneBarco()){
							contieneBarco = true;
						}
					}
					if(!contieneBarco){
						for(int i = this.columna; i < this.columna+this.longitud; i++){
							tablero.getCoordenadas()[fila][i].setContieneBarco(true);
						}
						posicionado = true;
					}	
				}
			}
			else{ //es vertical
				if((this.fila+this.longitud) <= 10){
					boolean contieneBarco = false;
					for(int i = this.fila; i < this.fila+this.longitud; i++){
						if(tablero.getCoordenadas()[i][columna].isContieneBarco()){
							contieneBarco = true;
						}
					}
					if(!contieneBarco){
						for(int i = this.fila; i < this.fila+this.longitud; i++){
							tablero.getCoordenadas()[i][columna].setContieneBarco(true);
						}
						posicionado = true;
					}
					
				}
			}
		return posicionado;
	}
}
