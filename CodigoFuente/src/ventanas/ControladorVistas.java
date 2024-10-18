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

	
	public ControladorVistas(){
		pantallaInicial= new PantallaInicial();
		pantallaFinal= new PantallaFinal();
		pantallaDeJuego= new PantallaDeJuego();
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
		sensorDeTeclasMenu= new SensorDeTeclasMenu();
		ventana.addKeyListener(sensorDeTeclasMenu);
	}
	
	public void RegistrarOyenteJuego(){
		sensorDeTeclasJuego= new SensorDeTeclasJuego();
		ventana.removeKeyListener(sensorDeTeclasMenu);
		ventana.addKeyListener(sensorDeTeclasJuego);
	}

	
	public void accionarPantallaPuntajes() {
		// TODO Auto-generated method stub
		
	}

	
	public void accionarPantallaModoDeJuego() {
		// TODO Auto-generated method stub
		
	}


	public void cambiarModoDeJuego() {
		// TODO Auto-generated method stub
		
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
		pantallaDeJuego.correr();
		ventana.revalidate();
		ventana.repaint();
	}

	
	public Observer registrarEntidad(EntidadJugador entidadJugador) {
		return null;
	}
	
	//TODO implementar cambiarNivel()
	

	
}
