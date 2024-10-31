package ventanas;

import javax.swing.JPanel;

public abstract class Pantalla extends JPanel {

	private static final long serialVersionUID = 195505428546220334L;
	
	private boolean refrescable;
	
	public abstract void refrescar();
	
	public boolean esRefrescable() {
		return true;
	}
	

}
