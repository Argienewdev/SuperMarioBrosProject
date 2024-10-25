package ventanas;

import javax.swing.*;

import launcher.Jugador;

import java.awt.*;
import java.util.List;

public class PantallaRanking extends JPanel {
	
	public PantallaRanking (List<Jugador> topJugadores) {
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		JLabel titulo = new JLabel ("Ranking mejores 5 jugadores");
		titulo.setFont(new Font("Arial", Font.BOLD, 24));
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(titulo);
		agregarJugadores(topJugadores);
	}
	
	private void agregarJugadores (List<Jugador> topJugadores) {
		for (Jugador jugador : topJugadores) {
			JLabel jugadorLabel = new JLabel (jugador.obtenerNombre() + " " + jugador.obtenerPuntaje());
			jugadorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			add(jugadorLabel);
		}
	}

}
