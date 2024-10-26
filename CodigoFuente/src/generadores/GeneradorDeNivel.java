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
import elementos.powerUps.Monedas;
import elementos.powerUps.PowerUp;
import observers.ObserverGrafico;
import ventanas.ControladorVistas;
import ventanas.DimensionesConstantes;
import ventanas.PantallaDeJuego;
import visitors.*;

import java.util.*;
import java.awt.Point;
import java.io.*;

public class GeneradorDeNivel {
	
	protected static final String RUTA_A_CARPETA = "src/niveles/nivel-";
	
	protected FabricaEntidades fabricaEntidades;
	
	protected FabricaSilueta fabricaSilueta;
	
	protected FabricaPlataformas fabricaPlataformas;
	
	protected PantallaDeJuego pantallaDeJuego;
	
	protected ControladorVistas controladorVistas;
	
	public GeneradorDeNivel(FabricaEntidades fabricaEntidades, FabricaSilueta fabricaSilueta, FabricaPlataformas fabricaPlataformas, PantallaDeJuego pantallaDeJuego, ControladorVistas controladorVistas) {
		this.fabricaEntidades = fabricaEntidades;
		this.fabricaSilueta = fabricaSilueta;
		this.fabricaPlataformas = fabricaPlataformas;
		this.pantallaDeJuego = pantallaDeJuego;
		this.controladorVistas = controladorVistas;
	}
	
	public Nivel generarNivel(int numeroNivel, Partida partida) {
		Silueta silueta = fabricaSilueta.getSilueta();
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
	                case 1: {
	                    Ladrillo ladrillo = this.fabricaPlataformas.getLadrillo(posicion);
	                    nivel.addPlataforma(ladrillo);
	                    nivel.addPlataformasAfectables(ladrillo);
	                    this.pantallaDeJuego.agregarLabel(ladrillo.getObserverGrafico());
	                    break;
	                }	             
	                case 2: {         
	                    int alturaTuberia = numeros[3];
	                    Tuberia tuberiaVacia = this.fabricaPlataformas.getTuberiaVacia(posicion, alturaTuberia);
	                    nivel.addPlataforma(tuberiaVacia);
	                    this.pantallaDeJuego.agregarLabel(tuberiaVacia.getObserverGrafico());
	                    break;
	                }
	                case 3: {
	                	int alturaTuberia = numeros[3];
	                    Tuberia tuberiaConPiranhaPlant = this.fabricaPlataformas.getTuberiaConPiranhaPlant(posicion, alturaTuberia);
	                    nivel.addPlataforma(tuberiaConPiranhaPlant);
	                    this.pantallaDeJuego.agregarLabel(tuberiaConPiranhaPlant.getObserverGrafico());
	                    break;
	                }
	                case 4: {
	                    BloqueDePregunta bloqueDePregunta = this.fabricaPlataformas.getBloqueDePregunta(posicion, nivel,pantallaDeJuego);
	                    nivel.addPlataforma(bloqueDePregunta);
	                    nivel.addPlataformasAfectables(bloqueDePregunta);
	                    this.pantallaDeJuego.agregarLabel(bloqueDePregunta.getObserverGrafico());
	                    break;
	                }
	                case 5: {
	                    Bandera bandera = this.fabricaPlataformas.getBandera(posicion,this.controladorVistas);
	                	nivel.addPlataforma(bandera);
	                    this.pantallaDeJuego.agregarLabel(bandera.getObserverGrafico());
	                    break;
	                }
	                case 6: {
	                    PrincesaPeach princesaPeach = this.fabricaPlataformas.getPrincesaPeach(posicion,this.controladorVistas);
	                    nivel.addPlataforma(princesaPeach);
	                    this.pantallaDeJuego.agregarLabel(princesaPeach.getObserverGrafico());
	                    break;
	                }
	                case 7: {
	                	BloqueSolido bloqueSolido = this.fabricaPlataformas.getBloqueSolido(posicion);
	                	nivel.addPlataforma(bloqueSolido);
	                	this.pantallaDeJuego.agregarLabel(bloqueSolido.getObserverGrafico());
	                	break;
	                } 
	                case 8: {
	                	Piso piso = this.fabricaPlataformas.getPiso(posicion);
	                	nivel.addPlataforma(piso);
	                	this.pantallaDeJuego.agregarLabel(piso.getObserverGrafico());
	                	System.out.println("El generador agrego el label de piso");
	                	break;
	                } 
	                case 20: {
	                	int cantidadMonedas = 1;
	                	Monedas monedas = this.fabricaEntidades.getMonedas(posicion,cantidadMonedas, false);
	                	nivel.addPowerUp(monedas);
	                	this.pantallaDeJuego.agregarLabel(monedas.getObserverGrafico());
	                	break;
	                }
	                case 40: {
	                    Lakitu lakitu = this.fabricaEntidades.getLakitu(posicion);
	                    nivel.addEnemigo(lakitu);
	                    this.pantallaDeJuego.agregarLabel(lakitu.getObserverGrafico());
	                    break;
	                } 
	                case 41: {
	                    ContextoKoopaTroopa contextoKoopaTroopa = this.fabricaEntidades.getContextoKoopaTroopa(posicion);
	                    nivel.addEnemigo(contextoKoopaTroopa);
	                    this.pantallaDeJuego.agregarLabel(contextoKoopaTroopa.getObserverGrafico());
	                    break;
	                } 
	                case 42: {
	                    Goomba goomba = fabricaEntidades.getGoomba(posicion);
	                    nivel.addEnemigo(goomba);
	                    this.pantallaDeJuego.agregarLabel(goomba.getObserverGrafico());
	                    break;
	                }
	                case 43: {
	                    Spiny spiny = fabricaEntidades.getSpiny(posicion);
	                    nivel.addEnemigo(spiny);
	                    this.pantallaDeJuego.agregarLabel(spiny.getObserverGrafico());
	                    break;
	                }
	                case 44: {
	                    BuzzyBeetle buzzyBeetle = fabricaEntidades.getBuzzyBeetle(posicion);
	                    nivel.addEnemigo(buzzyBeetle);
	                    this.pantallaDeJuego.agregarLabel(buzzyBeetle.getObserverGrafico());
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
		
		for(Plataforma plataforma : nivel.getPlataformas()) {
			plataforma.getObserverGrafico().actualizar();
		}
		for(PowerUp powerUp : nivel.getPowerUps()) {
			powerUp.getObserverGrafico().actualizar();
		}
		for(Enemigo enemigo : nivel.getEnemigos()) {
			enemigo.getObserverGrafico().actualizar();
		}
		
		return nivel;
	}
	
	@SuppressWarnings("exports")
	public void agregarMarioAlNivel(Nivel nivel, Point posicion) {
		Point posicionInicio = posicion;
		ContextoMario mario = fabricaEntidades.getContextoMario(posicionInicio, null, null, 3);
		ObserverGrafico observerGraficoMario = new ObserverGrafico(mario);
		mario.setObserverGrafico(observerGraficoMario);
		Visitante visitorContextoMario = new VisitorContextoMario(mario);
		mario.setVisitor(visitorContextoMario);
		nivel.setMario(mario);
	}
	
	private Point parsearPosicion(int x, int y) {
		return new Point(x * 50, DimensionesConstantes.PANEL_ALTO - (y * 50));
	}
	
}
