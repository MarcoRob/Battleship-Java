//import javax.swing.*;

public class Coordenada {

	public boolean contieneBarco,
					disparado,
					jugador;
	
	//private String clave;
	
	public Coordenada(boolean jugador) {
		this.contieneBarco = false;
		this.disparado = false;
		this.jugador = jugador;
		
	}
	
	public void setContieneBarco(boolean contieneBarco) {
		this.contieneBarco = contieneBarco;
	}

	public void setJugador(boolean jugador) {
		this.jugador = jugador;
	}

	public boolean isContieneBarco(){
		return this.contieneBarco;
	}
			
	public boolean isDisparado(){
		return this.disparado;
	}
	
	public int disparo(){
		
		if(!this.disparado && !this.contieneBarco){
			this.disparado = true;
			return 0;
		}
		else if(!this.disparado && this.contieneBarco){
				this.disparado = true;
				return 1;
		}
		else{
			// this.disparado == true 
			return 3;
		}
	}

	
	public String toString(){
		if(this.jugador){
			if(this.disparado && this.contieneBarco){
				return "*";
			}
			else if(!this.disparado && this.contieneBarco){
				return "b";
			}
			else if(this.disparado && !this.contieneBarco){
				return "#";
			}
			else{
				return " ";
			}
			
		}
		else{
			if(this.disparado && this.contieneBarco){
				return "*";
			}
			else if(!this.disparado && this.contieneBarco){
				return " ";
			}
			else if(this.disparado && !this.contieneBarco){
				return "#";
			}else{
				//disparado=false and contieneBarco= false
				return " ";
			}
		}
		
	}
	
	public String clave(){
		if(this.jugador){
			if(this.disparado && this.contieneBarco){
				return "*";
			}
			else if(!this.disparado && this.contieneBarco){
				return "b";
			}
			else if(this.disparado && !this.contieneBarco){
				return "#";
			}
			else{
				return " ";
			}
			
		}
		else{
			if(this.disparado && this.contieneBarco){
				return "*";
			}
			else if(!this.disparado && this.contieneBarco){
				return "s";
			}
			else if(this.disparado && !this.contieneBarco){
				return "#";
			}else{
				//disparado=false and contieneBarco= false
				return " ";
			}
		}
	}
}
