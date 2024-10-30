package generadores;

import fabricas.*;
import juego.Nivel;
import juego.Partida;
import elementos.Silueta;
import elementos.enemigos.BuzzyBeetle;
import elementos.enemigos.ContextoKoopaTroopa;
import elementos.enemigos.Enemigo;
import elementos.enemigos.Goomba;
import elementos.enemigos.Lakitu;
import elementos.enemigos.PiranhaPlant;
import elementos.enemigos.Spiny;
import elementos.personajes.ContextoMario;
import elementos.plataformas.Bandera;
import elementos.plataformas.BloqueDePregunta;
import elementos.plataformas.BloqueSolido;
import elementos.plataformas.Ladrillo;
import elementos.plataformas.Piso;
import elementos.plataformas.Plataforma;
import elementos.plataformas.PrincesaPeach;
import elementos.plataformas.Tuberia;
import elementos.plataformas.Vacio;
import elementos.powerUps.Moneda;
import elementos.powerUps.PowerUp;
import ventanas.ControladorVistas;
import ventanas.ConstantesGlobales;
import ventanas.PantallaDeJuego;

import java.awt.Point;
import java.io.*;

public class GeneradorDeNivel {
	
	protected static final String RUTA_A_CARPETA = "src/niveles/nivel-";
	
	protected FabricaSprites fabricaSprites;

	protected FabricaEntidades fabricaEntidades;
	
	protected FabricaSilueta fabricaSilueta;
		
	protected FabricaPlataformas fabricaPlataformas;
	
	protected FabricaSonidos fabricaSonidos;
	
	protected PantallaDeJuego pantallaDeJuego;
	
	protected ControladorVistas controladorVistas;
	
	public GeneradorDeNivel(String modoJuego,  PantallaDeJuego pantallaDeJuego, ControladorVistas controladorVistas) {
		if (modoJuego.equals("Modo original")) {
			this.fabricaSilueta = new FabricaSiluetaModoOriginal("src/imagenes/siluetas");
			this.fabricaSprites = new FabricaSpritesModoOriginal("src/imagenes/sprites");
			this.fabricaSonidos = new FabricaSonidosModoOriginal("src/sonido/sonidoModoOriginal");
		} else if (modoJuego.equals("Modo alternativo")) {
			this.fabricaSilueta = new FabricaSiluetaModoAlternativo("src/imagenes/siluetas");
			this.fabricaSprites = new FabricaSpritesModoAlternativo("src/imagenes/sprites");
			this.fabricaSonidos = new FabricaSonidosModoAlternativo("src/sonido/sonidoModoAlternativo");
		}
		this.fabricaEntidades = new FabricaEntidades(fabricaSprites,pantallaDeJuego, fabricaSonidos);
		this.fabricaPlataformas = new FabricaPlataformas(fabricaSprites, fabricaEntidades,pantallaDeJuego);
		this.pantallaDeJuego = pantallaDeJuego;
		this.controladorVistas = controladorVistas;		
	}
	
	public Nivel generarNivel(int numeroNivel, Partida partida) {
		Silueta silueta = fabricaSilueta.obtenerSilueta();
		Nivel nivel = new Nivel(silueta, partida);
		FileReader archivoDeNivel = null;
		BufferedReader lectorBuffer = null;
		
		try {
			archivoDeNivel = new FileReader(RUTA_A_CARPETA + numeroNivel + ".txt");
			lectorBuffer = new BufferedReader(archivoDeNivel);
			String linea;
			while((linea = lectorBuffer.readLine()) != null) {
				String[] partes = linea.split("\\s+");
				int[] numeros = new int[partes.length];
				
                for (int i = 0; i < partes.length; i++) {
                	numeros[i] = Integer.parseInt(partes[i]);
                }
                
                int identificadorElemento = numeros[0];
                Point posicion = parsearPosicion(numeros[1],numeros[2]);
                
                switch(identificadorElemento) {
	                case 0: {
	                	Vacio vacio = this.fabricaPlataformas.obtenerVacio(posicion);
	                	nivel.agregarPlataforma(vacio);
	                	nivel.agregarPlataformasAfectables(vacio);
	                	break;
	                }	             
	                case 1: {
	                    Ladrillo ladrillo = this.fabricaPlataformas.obtenerLadrillo(posicion);
	                    nivel.agregarPlataforma(ladrillo);
	                    nivel.agregarPlataformasAfectables(ladrillo);
	                    break;
	                }	             
	                case 2: {         
	                    int alturaTuberia = numeros[3];
	                    Tuberia tuberiaVacia = this.fabricaPlataformas.obtenerTuberiaVacia(posicion, alturaTuberia);
	                    nivel.agregarPlataforma(tuberiaVacia);
	                    break;
	                }
	                case 3: {
	                	int alturaTuberia = numeros[3];
	                    Tuberia tuberiaConPiranhaPlant = this.fabricaPlataformas.obtenerTuberiaConPiranhaPlant(posicion,nivel, alturaTuberia);
	                    nivel.agregarPlataforma(tuberiaConPiranhaPlant);
	                    break;
	                }
	                case 4: {
	                    BloqueDePregunta bloqueDePregunta = this.fabricaPlataformas.obtenerBloqueDePregunta(posicion, nivel,pantallaDeJuego);
	                    nivel.agregarPlataforma(bloqueDePregunta);
	                    nivel.agregarPlataformasAfectables(bloqueDePregunta);
	                    break;
	                }
	                case 5: {
	                    Bandera bandera = this.fabricaPlataformas.obtenerBandera(posicion,this.controladorVistas);
	                	nivel.agregarPlataforma(bandera);
	                    break;
	                }
	                case 6: {
	                    PrincesaPeach princesaPeach = this.fabricaPlataformas.obtenerPrincesaPeach(posicion,this.controladorVistas);
	                    nivel.agregarPlataforma(princesaPeach);
	                    break;
	                }
	                case 7: {
	                	BloqueSolido bloqueSolido = this.fabricaPlataformas.obtenerBloqueSolido(posicion);
	                	nivel.agregarPlataforma(bloqueSolido);
	                	break;
	                } 
	                case 8: {
	                	Piso piso = this.fabricaPlataformas.obtenerPiso(posicion);
	                	nivel.agregarPlataforma(piso);
	                	break;
	                } 
	                case 20: {
	                	Moneda moneda = this.fabricaEntidades.obtenerMonedas(posicion, false);
	                	nivel.agregarPowerUp(moneda);
	                	break;
	                }
	                case 40: {
	                    Lakitu lakitu = this.fabricaEntidades.obtenerLakitu(posicion, this.fabricaEntidades);
	                    nivel.agregarEnemigo(lakitu);
	                    break;
	                } 
	                case 41: {
	                    ContextoKoopaTroopa contextoKoopaTroopa = this.fabricaEntidades.obtenerContextoKoopaTroopa(posicion);
	                    nivel.agregarEnemigo(contextoKoopaTroopa);
	                    break;
	                } 
	                case 42: {
	                    Goomba goomba = fabricaEntidades.obtenerGoomba(posicion);
	                    nivel.agregarEnemigo(goomba);
	                    break;
	                }
	                case 43: {
	                    Spiny spiny = fabricaEntidades.obtenerSpiny(posicion);
	                    nivel.agregarEnemigo(spiny);
	                    break;
	                }
	                case 44: {
	                    BuzzyBeetle buzzyBeetle = fabricaEntidades.obtenerBuzzyBeetle(posicion);
	                    nivel.agregarEnemigo(buzzyBeetle);
	                    break;
	                }
	                case 45:{
	                	agregarMarioAlNivel(nivel, posicion);
	                	break;
	                }
                }
			}
		} catch (IOException | ArrayIndexOutOfBoundsException | NullPointerException exception) {
			exception.printStackTrace();
		} finally {
			try {
				if(lectorBuffer != null) {
					lectorBuffer.close();
				}
			} catch (IOException error) {
				error.printStackTrace();
			}
		}
		
		for(Plataforma plataforma : nivel.obtenerPlataformas()) {
			plataforma.obtenerObserverGrafico().actualizar();
		}
		for(PowerUp powerUp : nivel.obtenerPowerUps()) {
			powerUp.obtenerObserverGrafico().actualizar();
		}
		for(Enemigo enemigo : nivel.obtenerEnemigos()) {
			enemigo.obtenerObserverGrafico().actualizar();
		}
		return nivel;
	}
	
	@SuppressWarnings("exports")
	public void agregarMarioAlNivel(Nivel nivel, Point posicion) {
		Point posicionInicio = posicion;
		ContextoMario mario = fabricaEntidades.obtenerContextoMario(posicionInicio);
		nivel.establecerMario(mario);
	}
	
	private Point parsearPosicion(int x, int y) {
		return new Point(x * 50, ConstantesGlobales.PANEL_ALTO - (y * 50));
	}
	
	public FabricaSprites obtenerFabricaSprites() {
		return fabricaSprites;
	}
	
	public FabricaSilueta obtenerFabricaSilueta() {
		return fabricaSilueta;
	}
	
}
