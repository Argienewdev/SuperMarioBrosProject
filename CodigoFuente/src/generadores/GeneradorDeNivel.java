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
	                    Visitante visitor = new VisitorVacio();
	                    Vacio vacio = this.fabricaPlataformas.getVacio(posicion, visitor);
	                    ObserverGrafico observerGraficoVacio = new ObserverGrafico(vacio);
	                    vacio.setObserverGrafico(observerGraficoVacio);
	                    vacio.setNivel(nivel);
	                    nivel.addPlataforma(vacio);
	                    this.pantallaDeJuego.agregarLabel(observerGraficoVacio);
	                    break;
	                }
	                case 1: {
	                    Visitante visitor = new VisitorLadrillo();
	                    Ladrillo ladrillo = this.fabricaPlataformas.getLadrillo(posicion, visitor);
	                    ObserverGrafico observerGraficoLadrillo = new ObserverGrafico(ladrillo);
	                    ladrillo.setObserverGrafico(observerGraficoLadrillo);
	                    ladrillo.setNivel(nivel);
	                    nivel.addPlataforma(ladrillo);
	                    this.pantallaDeJuego.agregarLabel(observerGraficoLadrillo);
	                    break;
	                }	             
	                case 2: {
	                    Visitante visitor = new VisitorTuberia();
	                    int alturaTuberia = numeros[3];
	                    int anchoTuberia = 100;
	                    Tuberia tuberiaVacia = this.fabricaPlataformas.getTuberiaVacia(posicion, visitor, alturaTuberia, anchoTuberia);
	                    ObserverGrafico observerGraficoTuberia = new ObserverGrafico(tuberiaVacia);
	                    tuberiaVacia.setObserverGrafico(observerGraficoTuberia);
	                    tuberiaVacia.setNivel(nivel);
	                    nivel.addPlataforma(tuberiaVacia);
	                    this.pantallaDeJuego.agregarLabel(observerGraficoTuberia);
	                    break;
	                }
	                case 3: {
	                    Visitante visitor = new VisitorTuberia();                    
	                    int alturaTuberia = numeros[3];
	                    int anchoTuberia = 100;
	                    Tuberia tuberiaConPiranhaPlant = this.fabricaPlataformas.getTuberiaConPiranhaPlant(posicion, visitor, alturaTuberia, anchoTuberia);
	                    ObserverGrafico observerGraficoTuberia = new ObserverGrafico(tuberiaConPiranhaPlant);
	                    tuberiaConPiranhaPlant.setObserverGrafico(observerGraficoTuberia);
	                    tuberiaConPiranhaPlant.setNivel(nivel);
	                    nivel.addPlataforma(tuberiaConPiranhaPlant);
	                    this.pantallaDeJuego.agregarLabel(observerGraficoTuberia);
	                    break;
	                }
	                case 4: {
	                    Visitante visitor = new VisitorBloqueDePregunta();
	                    int identificadorPowerUp = numeros[3];
	                    BloqueDePregunta bloqueDePregunta = this.fabricaPlataformas.getBloqueDePreguntaSinMonedas(posicion, visitor, identificadorPowerUp);
	                    ObserverGrafico observerGraficoBloqueDePreguntaSinMonedas = new ObserverGrafico(bloqueDePregunta);
	                    bloqueDePregunta.setObserverGrafico(observerGraficoBloqueDePreguntaSinMonedas);
	                    bloqueDePregunta.setNivel(nivel);
	                    nivel.addPlataforma(bloqueDePregunta);
	                    this.pantallaDeJuego.agregarLabel(observerGraficoBloqueDePreguntaSinMonedas);
	                    break;
	                }
	                case 5: {
	                    Visitante visitor = new VisitorBloqueDePregunta();
	                    int cantidadMonedas = numeros[3];
	                    BloqueDePregunta bloqueDePregunta = this.fabricaPlataformas.getBloqueDePreguntaSinMonedas(posicion, visitor, cantidadMonedas);
	                    ObserverGrafico observerGraficoBloqueDePreguntaConMonedas = new ObserverGrafico(bloqueDePregunta);
	                    bloqueDePregunta.setObserverGrafico(observerGraficoBloqueDePreguntaConMonedas);
	                    bloqueDePregunta.setNivel(nivel);
	                    nivel.addPlataforma(bloqueDePregunta);
	                    this.pantallaDeJuego.agregarLabel(observerGraficoBloqueDePreguntaConMonedas);
	                    break;
	                }
	                case 6: {
	                    Visitante visitor = new VisitorBandera(this.controladorVistas);
	                    Meta bandera = this.fabricaPlataformas.getBandera(posicion, visitor);
	                    ObserverGrafico observerGraficoBandera = new ObserverGrafico(bandera);
	                    bandera.setObserverGrafico(observerGraficoBandera);
	                    bandera.setNivel(nivel);
	                    nivel.addPlataforma(bandera);
	                    this.pantallaDeJuego.agregarLabel(observerGraficoBandera);
	                    break;
	                }
	                case 7: {
	                    Visitante visitor = new VisitorPrincesa(this.controladorVistas);
	                    Meta princesaPeach = this.fabricaPlataformas.getPrincesaPeach(posicion, visitor);
	                    ObserverGrafico observerGraficoPrincesaPeach = new ObserverGrafico(princesaPeach);
	                    princesaPeach.setObserverGrafico(observerGraficoPrincesaPeach);
	                    princesaPeach.setNivel(nivel);
	                    nivel.addPlataforma(princesaPeach);
	                    this.pantallaDeJuego.agregarLabel(observerGraficoPrincesaPeach);
	                    break;
	                }
	                case 8: {
	                	Visitante visitor = new VisitorBloqueSolido();
	                	BloqueSolido bloqueSolido = this.fabricaPlataformas.getBloqueSolido();
	                	ObserverGrafico observerGraficoBloqueSolido = new ObserverGrafico(bloqueSolido);
	                	bloqueSolido.setObserverGrafico(observerGraficoBloqueSolido);
	                	bloqueSolido.setNivel(nivel);
	                	nivel.addPlataforma(bloqueSolido);
	                	this.pantallaDeJuego.agregarLabel(observerGraficoBloqueSolido);
	                	break;
	                }
	                case 20: {
	                	int cantidadMonedas = 1;
	                	Monedas monedas = this.fabricaEntidades.getMonedas(posicion, null, cantidadMonedas, null);
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
	                    Point velocidadDireccional= new Point(1,0);	 
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
	                    Point velocidadDireccional = new Point(1, 0);
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
	                    Point velocidadDireccional = new Point(1, 0);
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
	                    Point velocidadDireccional = new Point(1, 0);
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
	                    Point velocidadDireccional = new Point(1, 0);
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
	                }
                }
			}
		} catch (IOException exception) {
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
		return new Point(x * 50, DimensionesConstantes.NIVEL_PISO - (y * 50));
	}
}
