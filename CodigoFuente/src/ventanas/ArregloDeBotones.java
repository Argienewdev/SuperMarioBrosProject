package ventanas;

import javax.swing.JLabel;

public class ArregloDeBotones {
	
	private int siguiente;
	
	private JLabel[] arreglo;
	
	private int cantidad;
	
	public ArregloDeBotones(int tamanio){
		this.siguiente = 0;
		this.cantidad = 0;
		this.arreglo = new JLabel[tamanio];
	}
	
	@SuppressWarnings("exports")
	public void agregar(JLabel nuevo) {
		this.arreglo[cantidad] = nuevo;
		this.cantidad++;
	}
	
	@SuppressWarnings("exports")
	public JLabel siguiente() {
		JLabel aRetornar = null;
		if (this.siguiente >=  this.arreglo.length) {
			this.siguiente = 0;
			aRetornar = this.arreglo[siguiente];
			this.siguiente++;
		} else {
			aRetornar = this.arreglo[siguiente];
			this.siguiente++;
		}
		return aRetornar;
	}
	
	@SuppressWarnings("exports")
	public JLabel previo() {
		JLabel aRetornar = null;
		siguiente -=  2;
		if (siguiente < 0) {
			siguiente +=  arreglo.length;
			aRetornar = arreglo[siguiente];
			siguiente++;
		} else {
			aRetornar = arreglo[siguiente];
			siguiente++;
		}
		return aRetornar;
	}
	
}
