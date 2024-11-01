package ventanas;


import javax.swing.JLabel;

public class ArregloDeBotones {
	private int siguiente;
	private JLabel[] arreglo;
	private int cantidad;
	
	public ArregloDeBotones(int tamanho){
		siguiente = 0;
		cantidad = 0;
		arreglo = new JLabel[tamanho];
	}
	
	@SuppressWarnings("exports")
	public void agregar(JLabel nuevo) {
		arreglo[cantidad] = nuevo;
		cantidad++;
	}
	
	@SuppressWarnings("exports")
	public JLabel siguiente() {
		JLabel aRetornar = null;
		if (siguiente >= arreglo.length) {
			siguiente = 0;
			aRetornar = arreglo[siguiente];
			siguiente++;
		} else {
			aRetornar = arreglo[siguiente];
			siguiente++;
		}
		return aRetornar;
	}
	
	@SuppressWarnings("exports")
	public JLabel previo() {
		JLabel aRetornar = null;
		siguiente -= 2;
		if (siguiente < 0) {
			siguiente += arreglo.length;
			aRetornar = arreglo[siguiente];
			siguiente++;
		} else {
			aRetornar = arreglo[siguiente];
			siguiente++;
		}
		return aRetornar;
	}
}
