package juego;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import elementos.Sprite;
import elementos.personajes.ContextoMario;
import fabricas.FabricaSprites;
import fabricas.FabricaSpritesModoOriginal;
import generadores.GeneradorDeNivel;
import observers.ObserverLogicoJugable;
import ranking.Jugador;
import ranking.Ranking;
import sensoresDeTeclas.SensorDeTeclasJuego;
import ventanas.ControladorVistas;
import ventanas.PantallaDeJuego;

public class Juego {
			
	private ControladorVistas controladorVistas;
	
	private Partida partida;

	private FabricaSprites fabricaSprites;

	private GeneradorDeNivel generadorDeNivel;
		
	private PantallaDeJuego pantallaDeJuego;
	
	private Ranking ranking;
	
	private Jugador jugador;
	
	private BucleJuego bucleJuego;
	
	public Juego() {
		ranking = new Ranking();
		ranking.cargarEstado();
	}
	
	public void actualizar() {
		controladorVistas.refrescar();
	}
	
	public Sprite obtenerSpriteMario(){
		this.fabricaSprites = new FabricaSpritesModoOriginal("src/imagenes/sprites");
		return fabricaSprites.getMarioDefaultFrontalQuieto();
	}
	
	public Ranking obtenerRanking() {
		return this.ranking;
	}
	
	public void render() {
		//TICK
	}
	
	public ControladorVistas obtenerControladorVistas() {
		return this.controladorVistas;
	}

	public ContextoMario crearPartida(SensorDeTeclasJuego sensorDeTeclasJuego, String modo) {
		this.pantallaDeJuego = this.controladorVistas.obtenerPantallaDeJuego();
		this.generadorDeNivel = new GeneradorDeNivel(modo, pantallaDeJuego, controladorVistas);
		this.fabricaSprites=generadorDeNivel.getFabricaSprites();
		this.partida = new Partida(sensorDeTeclasJuego, generadorDeNivel, fabricaSprites,this);
		ContextoMario jugable = partida.obtenerJugable();
		jugable.establecerObserverLogico(new ObserverLogicoJugable(this));
		jugador = new Jugador();
		//jugador.establecerNombre(controladorVistas.obtenerPantallaIngresoNombre().obtenerNombreJugador());
		return jugable;
	}
	
	public Partida obtenerPartida() {
		return this.partida;
	}
	
	public void finalizarPartida () {
		jugador.actualizarPuntos(partida.obtenerJugable().getPuntos());
		ranking.agregarJugador(jugador);
		ranking.guardarEstado();
		controladorVistas.mostrarPantallaFinal();
		this.partida.finalizarPartida();
	}

	public void establecerControladorVistas(ControladorVistas controladorVistas) {
		this.controladorVistas=controladorVistas;
	}
	
	public void cierreDeJuego() {
		 ranking.guardarEstado();
	     //TODO liberarRecursos(); si fuera necesario
	     mostrarMensaje("Gracias por jugar!");
	     System.exit(0);
	}
	
	private void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null,mensaje);
	}

	public void setBucleJuego(BucleJuego bucleJuego) {
		this.bucleJuego = bucleJuego;
	}
	
	public BucleJuego obtenerBucleJuego() {
		return this.bucleJuego;
	}
	
}
