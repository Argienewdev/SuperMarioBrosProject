package juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import elementos.Sprite;
import elementos.personajes.ContextoMario;
import ranking.Ranking;
import sensoresDeTeclas.SensorDeTeclasJuego;
import ventanas.ControladorVistas;
import ventanas.PantallaDeJuego;

public class Juego {
			
	private ControladorVistas controladorVistas;
	
	private Partida partida;
		
	private PantallaDeJuego pantallaDeJuego;
	
	private Ranking ranking;
	
	private String modoDeJuegoSeleccionado;
	
	public Juego() {
		ranking = cargarEstadoRanking();
		//TODO Esto se deja?
		//Utilizar solo cuando se quiere establecer un nuevo ranking
		//Unicamente en el primer juego creado, despues volver a comentar
		
		//ranking.reiniciarRanking();
	}
	
	public Sprite obtenerSpriteMario(){
		return this.partida.obtenerSpriteMario();
	}
	
	@SuppressWarnings("exports")
	public Ranking obtenerRanking() {
		return this.ranking;
	}
	
	public ControladorVistas obtenerControladorVistas() {
		return this.controladorVistas;
	}
	
	public PantallaDeJuego obtenerPantallaDeJuego() {
		return this.pantallaDeJuego;
	}
	
	public String obtenerModoDeJuegoSeleccionado() {
		return this.modoDeJuegoSeleccionado;
	}

	@SuppressWarnings("exports")
	public ContextoMario crearPartida(SensorDeTeclasJuego sensorDeTeclasJuego, String modo) {
		this.modoDeJuegoSeleccionado = modo;
		this.pantallaDeJuego = this.controladorVistas.obtenerPantallaDeJuego();
		this.partida = new Partida(sensorDeTeclasJuego, this);
		ContextoMario jugable = partida.obtenerJugable();
		return jugable;
	}
	
	public Partida obtenerPartida() {
		return this.partida;
	}
	
	public void finalizarJuego (){
		Timer timer = new Timer(2000, new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	            partida.obtenerGeneradorDeSonidos().pierdeJuego();
	        }
	    });
	    timer.setRepeats(false);
	    timer.start();
        controladorVistas.accionarPantallaIngresoNombre();

        BucleJugador bucle = partida.obtenerBucleJugador();
        bucle.detenerBucleJugador();
    }

	public void establecerControladorVistas(ControladorVistas controladorVistas) {
		this.controladorVistas = controladorVistas;
	}
	
	public void cierreDeJuego() {
		 ranking.guardarEstado();
	     mostrarMensaje("Gracias por jugar!");
	     System.exit(0);
	}
	
	@SuppressWarnings("exports")
	public Ranking cargarEstadoRanking() {
    	Ranking rankingARetornar = null;
    	try {
    		FileInputStream fileInputStream = new FileInputStream ("./src/puntos");
    		ObjectInputStream objectInputStream = new ObjectInputStream (fileInputStream);
    		rankingARetornar = (Ranking) objectInputStream.readObject();
    		objectInputStream.close();
    	} catch (FileNotFoundException e) {
    		//No hacer nada
    	} catch (IOException | ClassNotFoundException e) {
    		e.printStackTrace();
    	} 
    	return rankingARetornar;
    }
	
	private void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null,mensaje);
	}

}
