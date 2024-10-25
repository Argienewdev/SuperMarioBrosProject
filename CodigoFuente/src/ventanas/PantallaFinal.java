package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PantallaFinal extends JPanel{

	private ControladorVistas controladorVistas;
	
	protected Dimension size = new Dimension(DimensionesConstantes.PANEL_ANCHO, DimensionesConstantes.PANEL_ALTO);
	
	public PantallaFinal (ControladorVistas controladorVistas) {
		this.controladorVistas = controladorVistas;
		setLayout(new BorderLayout()); 
        setPreferredSize(new Dimension(size));

        
        JLabel mensajeFinal = new JLabel("¡Fin de la Partida!", SwingConstants.CENTER);
        mensajeFinal.setFont(new Font("Arial", Font.BOLD, 24));
        add(mensajeFinal, BorderLayout.CENTER);
	}

}
