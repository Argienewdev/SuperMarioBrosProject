package generadores;
import fabricas.*;
import juego.Nivel;
import elementos.Silueta;
import elementos.enemigos.BuzzyBeetle;
import elementos.enemigos.ContextoKoopaTroopa;
import elementos.enemigos.Enemigo;
import elementos.enemigos.Goomba;
import elementos.enemigos.Lakitu;
import elementos.enemigos.Spiny;
import elementos.personajes.ContextoMario;
import elementos.personajes.MarioDefault;
import elementos.plataformas.Bandera;
import elementos.plataformas.BloqueDePregunta;
import elementos.plataformas.BloqueSolido;
import elementos.plataformas.Ladrillo;
import elementos.plataformas.Meta;
import elementos.plataformas.Piso;
import elementos.plataformas.Plataforma;
import elementos.plataformas.PrincesaPeach;
import elementos.plataformas.Tuberia;
import elementos.plataformas.Vacio;
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
	
	protected static final int VELOCIDAD_HORIZONTAL_ENEMIGOS = -2;
	
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
	
	public Nivel generarNivel(String rutaTxtNivel) {
		Silueta silueta = fabricaSilueta.getSilueta();
		Nivel nivel = new Nivel(silueta);
		FileReader archivoDeNivel = null;
		BufferedReader lectorBuffer = null;
		
		try {
			archivoDeNivel = new FileReader(rutaTxtNivel);
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
	                    Vacio vacio = this.fabricaPlataformas.getVacio(posicion, null);
	                    ObserverGrafico observerGraficoVacio = new ObserverGrafico(vacio);
	                    Visitante visitor = new VisitorVacio(vacio);
	                    vacio.setVisitor(visitor);	  
	                    vacio.setObserverGrafico(observerGraficoVacio);
	                    vacio.setNivel(nivel);
	                    nivel.addPlataforma(vacio);
	                    this.pantallaDeJuego.agregarLabel(observerGraficoVacio);
	                    break;
	                }
	                case 1: {
	                    Ladrillo ladrillo = this.fabricaPlataformas.getLadrillo(posicion, null);
	                    Visitante visitor = new VisitorLadrillo(ladrillo);
	                    ladrillo.setVisitor(visitor);
	                    ObserverGrafico observerGraficoLadrillo = new ObserverGrafico(ladrillo);	   
	                    ladrillo.setObserverGrafico(observerGraficoLadrillo);
	                    ladrillo.setNivel(nivel);
	                    nivel.addPlataforma(ladrillo);
	                    this.pantallaDeJuego.agregarLabel(observerGraficoLadrillo);
	                    break;
	                }	             
	                case 2: {	                   
	                    int alturaTuberia = numeros[3];
	                    int anchoTuberia = 100;
	                    Tuberia tuberiaVacia = this.fabricaPlataformas.getTuberiaVacia(posicion, null, alturaTuberia, anchoTuberia);
	                    ObserverGrafico observerGraficoTuberia = new ObserverGrafico(tuberiaVacia);
	                    Visitante visitor = new VisitorTuberia(tuberiaVacia);
	                    tuberiaVacia.setObserverGrafico(observerGraficoTuberia);
	                    tuberiaVacia.setNivel(nivel);
	                    nivel.addPlataforma(tuberiaVacia);
	                    this.pantallaDeJuego.agregarLabel(observerGraficoTuberia);
	                    break;
	                }
	                case 3: {
	                    int alturaTuberia = numeros[3];
	                    int anchoTuberia = 100;
	                    Tuberia tuberiaConPiranhaPlant = this.fabricaPlataformas.getTuberiaConPiranhaPlant(posicion, null, alturaTuberia, anchoTuberia);
	                    Visitante visitor = new VisitorTuberia(tuberiaConPiranhaPlant);
	                    ObserverGrafico observerGraficoTuberia = new ObserverGrafico(tuberiaConPiranhaPlant);
	                    tuberiaConPiranhaPlant.setObserverGrafico(observerGraficoTuberia);
	                    tuberiaConPiranhaPlant.setNivel(nivel);
	                    nivel.addPlataforma(tuberiaConPiranhaPlant);
	                    this.pantallaDeJuego.agregarLabel(observerGraficoTuberia);
	                    break;
	                }
	                case 4: {
	                    BloqueDePregunta bloqueDePregunta = this.fabricaPlataformas.getBloqueDePregunta(posicion, null, nivel,pantallaDeJuego);
	                    Visitante visitor = new VisitorBloqueDePregunta(bloqueDePregunta);
	                    ObserverGrafico observerGraficoBloqueDePregunta = new ObserverGrafico(bloqueDePregunta);	                  
	                    bloqueDePregunta.setObserverGrafico(observerGraficoBloqueDePregunta);
	                    bloqueDePregunta.setNivel(nivel);
	                    nivel.addPlataforma(bloqueDePregunta);
	                    this.pantallaDeJuego.agregarLabel(observerGraficoBloqueDePregunta);
	                    break;
	                }
	                case 5: {
	                    Bandera bandera = this.fabricaPlataformas.getBandera(posicion, null);
	                    Visitante visitor = new VisitorBandera(this.controladorVistas,bandera);
	                    ObserverGrafico observerGraficoBandera = new ObserverGrafico(bandera);
	                    bandera.setObserverGrafico(observerGraficoBandera);
	                    bandera.setNivel(nivel);
	                    nivel.addPlataforma(bandera);
	                    this.pantallaDeJuego.agregarLabel(observerGraficoBandera);
	                    break;
	                }
	                case 6: {
	                    PrincesaPeach princesaPeach = this.fabricaPlataformas.getPrincesaPeach(posicion, null);
	                    Visitante visitor = new VisitorPrincesa(this.controladorVistas,princesaPeach);
	                    ObserverGrafico observerGraficoPrincesaPeach = new ObserverGrafico(princesaPeach);
	                    princesaPeach.setObserverGrafico(observerGraficoPrincesaPeach);
	                    princesaPeach.setNivel(nivel);
	                    nivel.addPlataforma(princesaPeach);
	                    this.pantallaDeJuego.agregarLabel(observerGraficoPrincesaPeach);
	                    break;
	                }
	                case 7: {
	                	BloqueSolido bloqueSolido = this.fabricaPlataformas.getBloqueSolido(posicion, null);
	                	Visitante visitorBloqueSolido = new VisitorBloqueSolido(bloqueSolido);
	                	ObserverGrafico observerGraficoBloqueSolido = new ObserverGrafico(bloqueSolido);
	                	bloqueSolido.setVisitor(visitorBloqueSolido);
	                	bloqueSolido.setObserverGrafico(observerGraficoBloqueSolido);
	                	bloqueSolido.setNivel(nivel);
	                	nivel.addPlataforma(bloqueSolido);
	                	this.pantallaDeJuego.agregarLabel(observerGraficoBloqueSolido);
	                	break;
	                } 
	                case 8: {
	                	Piso piso = this.fabricaPlataformas.getPiso(posicion, null);
	                	Visitante visitorPiso = new VisitorPiso(piso);
	                	ObserverGrafico observerGraficoBloqueSolido = new ObserverGrafico(piso);
	                	piso.setVisitor(visitorPiso);
	                	piso.setObserverGrafico(observerGraficoBloqueSolido);
	                	piso.setNivel(nivel);
	                	nivel.addPlataforma(piso);
	                	this.pantallaDeJuego.agregarLabel(observerGraficoBloqueSolido);
	                	break;
	                } 
	                case 20: {
	                	Random random = new Random();
	            		int cantidadMonedas = random.nextInt(8) + 1; // Genera un numero entre 1 y 8, ambos inclusive
	                	Point velocidadDireccional = new Point(0,0);
	                	Monedas monedas = this.fabricaEntidades.getMonedas(posicion, null, velocidadDireccional, null, cantidadMonedas, false);
	                	Visitante visitorMonedas = new VisitorMonedas(monedas);
	                	monedas.setVisitor(visitorMonedas);
	                	ObserverGrafico observerGraficoMonedas = new ObserverGrafico(monedas);
	                	monedas.setObserverGrafico(observerGraficoMonedas);
	                	monedas.setNivel(nivel);
	                	nivel.addPowerUp(monedas);
	                	this.pantallaDeJuego.agregarLabel(observerGraficoMonedas);
	                	break;
	                }
	                case 40: {
	                    Point velocidadDireccional= new Point(VELOCIDAD_HORIZONTAL_ENEMIGOS,0);	 
	                    Lakitu lakitu = this.fabricaEntidades.getLakitu(posicion, null, velocidadDireccional, null);
	                    Visitante visitorLakitu = new VisitorLakitu(lakitu);
	                    lakitu.setVisitor(visitorLakitu);
	                    ObserverGrafico observerGraficoLakitu = new ObserverGrafico(lakitu);
	                    lakitu.setObserverGrafico(observerGraficoLakitu);
	                    lakitu.setNivel(nivel);
	                    nivel.addEnemigo(lakitu);
	                    this.pantallaDeJuego.agregarLabel(observerGraficoLakitu);
	                    break;
	                } 
	                case 41: {
	                    Point velocidadDireccional = new Point(VELOCIDAD_HORIZONTAL_ENEMIGOS, 0);
	                    ContextoKoopaTroopa contextoKoopaTroopa = this.fabricaEntidades.getContextoKoopaTroopa(posicion, null, velocidadDireccional, null);
	                    Visitante visitorContextoKoopaTroopa = new VisitorContextoKoopaTroopa(contextoKoopaTroopa);
	                    contextoKoopaTroopa.setVisitor(visitorContextoKoopaTroopa);
	                    ObserverGrafico observerGraficoKoopa = new ObserverGrafico(contextoKoopaTroopa);
	                    contextoKoopaTroopa.setObserverGrafico(observerGraficoKoopa);
	                    contextoKoopaTroopa.setNivel(nivel);
	                    nivel.addEnemigo(contextoKoopaTroopa);
	                    this.pantallaDeJuego.agregarLabel(observerGraficoKoopa);
	                    break;
	                } 
	                case 42: {
	                    Point velocidadDireccional = new Point(VELOCIDAD_HORIZONTAL_ENEMIGOS, 0);
	                    Goomba goomba = fabricaEntidades.getGoomba(posicion, null, velocidadDireccional, null);
	                    Visitante visitorGoomba = new VisitorGoomba(goomba);
	                    goomba.setVisitor(visitorGoomba);
	                    ObserverGrafico observerGraficoGoomba = new ObserverGrafico(goomba);
	                    goomba.setObserverGrafico(observerGraficoGoomba);
	                    goomba.setNivel(nivel);
	                    nivel.addEnemigo(goomba);
	                    this.pantallaDeJuego.agregarLabel(observerGraficoGoomba);
	                    break;
	                }
	                case 43: {
	                    Point velocidadDireccional = new Point(VELOCIDAD_HORIZONTAL_ENEMIGOS, 0);
	                    Spiny spiny = fabricaEntidades.getSpiny(posicion, null, velocidadDireccional, null);
	                    Visitante visitorSpiny = new VisitorSpiny(spiny);
	                    spiny.setVisitor(visitorSpiny);
	                    ObserverGrafico observerGraficoSpiny = new ObserverGrafico(spiny);
	                    spiny.setObserverGrafico(observerGraficoSpiny);
	                    spiny.setNivel(nivel);
	                    nivel.addEnemigo(spiny);
	                    this.pantallaDeJuego.agregarLabel(observerGraficoSpiny);
	                    break;
	                }
	                case 44: {
	                    Point velocidadDireccional = new Point(VELOCIDAD_HORIZONTAL_ENEMIGOS, 0);
	                    BuzzyBeetle buzzyBeetle = fabricaEntidades.getBuzzyBeetle(posicion, null, velocidadDireccional, null);
	                    Visitante visitorBuzzy = new VisitorBuzzyBeetle(buzzyBeetle);
	                    buzzyBeetle.setVisitor(visitorBuzzy);
	                    ObserverGrafico observerGraficoBuzzy = new ObserverGrafico(buzzyBeetle);
	                    buzzyBeetle.setObserverGrafico(observerGraficoBuzzy);
	                    buzzyBeetle.setNivel(nivel);
	                    nivel.addEnemigo(buzzyBeetle);
	                    this.pantallaDeJuego.agregarLabel(observerGraficoBuzzy);
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
