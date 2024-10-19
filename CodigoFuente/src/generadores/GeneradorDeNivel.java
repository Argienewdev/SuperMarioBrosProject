package generadores;
import fabricas.*;
import juego.Nivel;
import elementos.Silueta;
import elementos.personajes.ContextoMario;
import elementos.personajes.MarioDefault;
import observers.ObserverGrafico;
import visitors.Visitante;

import java.util.*;
import java.awt.Point;
import java.io.*;

public class GeneradorDeNivel {
	
	protected FabricaEntidades fabricaEntidades;
	
	protected FabricaSilueta fabricaSilueta;
	
	protected FabricaPlataformas fabricaPlataformas;
	
	public GeneradorDeNivel(FabricaEntidades fabricaEntidades) {
		this.fabricaEntidades = fabricaEntidades;
		//TODO forzando modo 1
		this.fabricaSilueta = new FabricaSiluetaModoOriginal("../imagenes/siluetas/siluetaModoOriginal.png");
	}
	
	public Nivel generarNivel(String rutaTxtNivel){
		
		Silueta silueta = fabricaSilueta.getSilueta();
		Nivel nivel = new Nivel(silueta);
		FileReader archivoDeNivel = null;
		BufferedReader lectorBuffer = null;
		//Creo a mario al comienzo del nivel
		Point posicionInicio=new Point(0,0);
		int vidas=3;
		ContextoMario mario = fabricaEntidades.getContextoMario(posicionInicio, null, null, vidas);
		nivel.setMario(mario);
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
                Point posicion = new Point(numeros[1],numeros[2]);
                
                switch(identificadorElemento) {
	                case 0: {
	                    Visitante visitor = null;
	                    nivel.addPlataforma(fabricaPlataformas.getVacio(posicion, visitor));
	                    break;
	                }
	                case 1: {
	                    Visitante visitor = null;
	                    nivel.addPlataforma(fabricaPlataformas.getLadrillo(posicion, visitor));
	                    break;
	                }	             
	                case 3: {
	                    Visitante visitor = null;
	                    int alturaTuberia = numeros[3];
	                    int anchoTuberia = 0;
	                    nivel.addPlataforma(fabricaPlataformas.getTuberiaVacia(posicion, visitor, alturaTuberia));
	                    break;
	                }
	                case 4: {
	                    Visitante visitor = null;
	                    int alturaTuberia = numeros[3];
	                    nivel.addPlataforma(fabricaPlataformas.getTuberiaConPiranhaPlant(posicion, visitor, alturaTuberia));
	                    break;
	                }
	                case 5: {
	                    Visitante visitor = null;
	                    int identificadorPowerUp = numeros[3];
	                    nivel.addPlataforma(fabricaPlataformas.getBloqueDePreguntaSinMonedas(posicion, visitor, identificadorPowerUp));
	                    break;
	                }
	                case 6: {
	                    Visitante visitor = null;
	                    int cantidadMonedas = numeros[3];
	                    nivel.addPlataforma(fabricaPlataformas.getBloqueDePreguntaConMonedas(posicion, visitor, cantidadMonedas));
	                    break;
	                }
	                case 7: {
	                    Visitante visitor = null;
	                    nivel.addPlataforma(fabricaPlataformas.getBandera(posicion, visitor));
	                    break;
	                }
	                case 8: {
	                    Visitante visitor = null;
	                    nivel.addPlataforma(fabricaPlataformas.getPrincesaPeach(posicion, visitor));
	                    break;
	                }
	                case 20: {
	                    Visitante visitor = null;
	                    int cantidadMonedas = 1;
	                    ObserverGrafico observer = null;
	                    nivel.addPowerUps(fabricaEntidades.getMonedas(posicion, visitor, cantidadMonedas, observer));
	                    break;
	                }
	                case 40: {
	                    Visitante visitor = null;
	                    Point velocidadDireccional= new Point(1,0);	                    
	                    ObserverGrafico observer = null;
	                    nivel.addEnemigo(fabricaEntidades.getLakitu(posicion, visitor, velocidadDireccional, observer));
	                    break;
	                }
	                case 41: {
	                    Visitante visitor = null;
	                    Point velocidadDireccional= new Point(1,0);	                    
	                    ObserverGrafico observer = null;
	                    nivel.addEnemigo(fabricaEntidades.getContextoKoopaTroopa(posicion, visitor, velocidadDireccional, observer));
	                    break;
	                }
	                case 42: {
	                    Visitante visitor = null;
	                    Point velocidadDireccional= new Point(1,0);	                    
	                    ObserverGrafico observer = null;
	                    nivel.addEnemigo(fabricaEntidades.getGoomba(posicion, visitor, velocidadDireccional, observer));
	                    break;
	                }
	                case 43: {
	                    Visitante visitor = null;
	                    Point velocidadDireccional= new Point(1,0);	                    
	                    ObserverGrafico observer = null;
	                    nivel.addEnemigo(fabricaEntidades.getSpiny(posicion, visitor, velocidadDireccional, observer));
	                    break;
	                }
	                case 44: {
	                    Visitante visitor = null;
	                    Point velocidadDireccional= new Point(1,0);	                  
	                    ObserverGrafico observer = null;
	                    nivel.addEnemigo(fabricaEntidades.getBuzzyBeetle(posicion, visitor, velocidadDireccional, observer));
	                    break;
	                }
	                default: {
	                    System.err.println("Identificador desconocido: " + identificadorElemento);
	                    break;
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
		return nivel;
	}
	
}
