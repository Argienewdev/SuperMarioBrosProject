package ventanas;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import juego.*;
import sensoresDeTeclas.SensorDeTeclasJuego;
import sensoresDeTeclas.SensorDeTeclasMenu;

public class ControladorVistas implements ControladorDeVistas, ControladorEntreJuegoVista {
	
	private JFrame ventana;
	
	private HUD HUD;
	
	
	private PantallaDeJuego pantallaDeJuego;
	
	private PantallaFinal pantallaFinal;
	
	private PantallaInicial pantallaInicial;
	
	private SensorDeTeclasMenu sensorDeTeclasMenu;
	
	private SensorDeTeclasJuego sensorDeTeclasJuego;
	
	protected Juego juego;	

	
	public ControladorVistas(Juego juego){
		sensorDeTeclasMenu = new SensorDeTeclasMenu();
		pantallaInicial= new PantallaInicial(sensorDeTeclasMenu, this);
		pantallaFinal= new PantallaFinal();
		pantallaDeJuego= new PantallaDeJuego();
		sensorDeTeclasJuego = new SensorDeTeclasJuego();
		this.juego = juego;
		configurarVentana();
		ventana.setVisible(true);
		RegistrarOyenteInicial();
	}
	
	public void configurarVentana(){
		ventana = new JFrame("Super Mario Bros");
		ventana.setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage());
		ventana.setVisible(true);
		ventana.add(pantallaInicial);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setSize(DimensionesConstantes.VENTANA_ANCHO, DimensionesConstantes.VENTANA_ALTO);
		ventana.setLocationRelativeTo(null);
	}
	
	public void accionarInicioJuego() {
		RegistrarOyenteJuego();
		ventana.remove(pantallaInicial);
		ventana.add(pantallaDeJuego);
	}
	
	public void RegistrarOyenteInicial(){
		ventana.addKeyListener(sensorDeTeclasMenu);
	}
	
	public void RegistrarOyenteJuego(){
		ventana.removeKeyListener(sensorDeTeclasMenu);
		ventana.addKeyListener(sensorDeTeclasJuego);
	}

	
	public void accionarPantallaPuntajes() {
		
	}

	
	public void accionarPantallaModoDeJuego() {
		
	}


	public void cambiarModoDeJuego() {
		
	}

	public Observer registrarEntidad(EntidadLogica entidadLogica) {
		
		return null;
	}

	
	public Observer registrarSilueta(EntidadLogica silueta) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void mostrarPantallaDeJuego() {
		// TODO Auto-generated method stub
		
	}

	
	public void mostrarPantallaFinal() {
		ventana.setContentPane(pantallaFinal);
		
	}


	public void mostrarPantallaInicial() {
		ventana.setContentPane(pantallaInicial);
		refrescar();
	}

	
	public void mostrarHUD() {
		ventana.setContentPane(HUD);
		refrescar();
	}
	
	public void refrescar(){
		pantallaInicial.actualizarFoco();
		ventana.revalidate();
		ventana.repaint();
	}

	
	public Observer registrarEntidad(EntidadJugador entidadJugador) {
		return null;
	}

	
}
