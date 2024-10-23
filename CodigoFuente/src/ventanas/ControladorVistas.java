package ventanas;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import elementos.entidades.Jugable;
import juego.*;
import sensoresDeTeclas.SensorDeTeclasJuego;
import sensoresDeTeclas.SensorDeTeclasMenu;

public class ControladorVistas {
	
	private JFrame ventana;
	
	private Interfaz hud;
	
	private Jugable marioJugable;
	
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
		sensorDeTeclasJuego = new SensorDeTeclasJuego();
		pantallaDeJuego= new PantallaDeJuego();
		hud= new Interfaz();
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
		ventana.pack();
	}
	
	public void accionarInicioJuego(String modo) {
		RegistrarOyenteJuego();
		ventana.remove(pantallaInicial);
		ventana.add(pantallaDeJuego);
		marioJugable = juego.crearPartida(sensorDeTeclasJuego, modo);
		pantallaDeJuego.registrarJugable(marioJugable);
		ventana.add(hud);
		ventana.setComponentZOrder(hud, 0); // Asegura que el HUD está al frente
	}
	
	public void RegistrarOyenteInicial(){
		ventana.addKeyListener(sensorDeTeclasMenu);
	}
	
	public void RegistrarOyenteJuego(){
		ventana.removeKeyListener(sensorDeTeclasMenu);
		ventana.addKeyListener(sensorDeTeclasJuego);
		ventana.requestFocusInWindow();
	}

	
	public void accionarPantallaPuntajes() {
		
	}

	
	public void accionarPantallaModoDeJuego() {
		
	}


	public void cambiarModoDeJuego() {
		
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
		ventana.setContentPane(hud);
		refrescar();
	}
	
	public void refrescar(){
		if(ventana.getKeyListeners()[0] == sensorDeTeclasMenu) {
			pantallaInicial.actualizarFoco();
		}else {
			pantallaDeJuego.refrescar();
		}
		ventana.revalidate();
		ventana.repaint();
	}
	
	public PantallaDeJuego obtenerPantallaDeJuego() {
		return this.pantallaDeJuego;
	}
	
	public void cambiarNivel() {
		//TODO
	}

}
