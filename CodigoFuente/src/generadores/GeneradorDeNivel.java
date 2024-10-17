package generadores;
import fabricas.*;
import juego.Nivel;
import elementos.Silueta;
import observers.ObserverGrafico;
import visitors.Visitante;

import java.util.*;


import java.io.*;

public class GeneradorDeNivel {
	
	protected FabricaEntidades fabricaEntidades;
	
	protected FabricaSilueta fabricaSilueta;
	
	protected FabricaPlataformas fabricaPlataformas;
	
	public GeneradorDeNivel(FabricaEntidades fabricaEntidades){
		this.fabricaEntidades = fabricaEntidades;
	}
	
	public Nivel generarNivel(int numeroModo, String rutaTxtNivel){
		
		Silueta silueta = fabricaSilueta.getSilueta();
		Nivel nivel = new Nivel(silueta);
		FileReader archivoDeNivel = null;
		BufferedReader lectorBuffer = null;
		try {
			
			archivoDeNivel = new FileReader(rutaTxtNivel);
			lectorBuffer= new BufferedReader(archivoDeNivel);
			String linea;
			//Leo linea por linea hasta terminar el txt
			while((linea = lectorBuffer.readLine()) != null){
				//Separo en un arreglo todas las cadenas separadas por uno o mas espacios
				String[] partes = linea.split("\\s+");
				//Convieto las cadenas a numeros
				int[] numeros = new int[partes.length];
                for (int i = 0; i < partes.length; i++) {
                    numeros[i] = Integer.parseInt(partes[i]);
                }
                int identificadorElemento=numeros[0];
                Vector<Integer> posicion= new Vector<Integer>(numeros[1],numeros[2]);
                switch(identificadorElemento) {
                	case 0:{
                		Visitante visitor=null;
            			nivel.addPlataforma(fabricaPlataformas.getVacio(posicion, visitor));
            		}
                	case 1:{
                		Visitante visitor=null;
                		nivel.addPlataforma(fabricaPlataformas.getLadrillo(posicion, visitor,0));
                	}
                	case 2:{
                		Visitante visitor=null;
                		int cantidadDeMonedasDentroDelLadrillo=numeros[3];
                		nivel.addPlataforma(fabricaPlataformas.getLadrillo(posicion, visitor,cantidadDeMonedasDentroDelLadrillo));
                	}
                	case 3:{
                		Visitante visitor=null;
                		int alturaTuberia=numeros[3];
                		nivel.addPlataforma(fabricaPlataformas.getTuberiaVacia(posicion, visitor, alturaTuberia));
                	}
                	case 4:{
                		Visitante visitor=null;
                		int alturaTuberia=numeros[3];
                		nivel.addPlataforma(fabricaPlataformas.getTuberiaConPiranhaPlant(posicion, visitor, alturaTuberia));
                	}
                	case 5:{
                		Visitante visitor=null;
                		int identificadorPowerUp=numeros[3];            
                		nivel.addPlataforma(fabricaPlataformas.getBloqueDePreguntaSinMonedas(posicion, visitor,identificadorPowerUp));
                	}
                	case 6:{
                		Visitante visitor=null;
                		int cantidadMonedas=numeros[3];
                		nivel.addPlataforma(fabricaPlataformas.getBloqueDePreguntaConMonedas(posicion, visitor,cantidadMonedas));
                		//Bloque de pregunta
                	}
                	case 7:{
                		Visitante visitor=null;
                		nivel.addPlataforma(fabricaPlataformas.getBandera(posicion, visitor));
                	}
                	case 8:{
                		Visitante visitor=null;
                		nivel.addPlataforma(fabricaPlataformas.getPrincesaPeach(posicion, visitor));
                	}
                	case 20:{
                		Visitante visitor=null;
                		int cantidadMonedas=1;
                		//Las monedas dentro del mundo aparecen de forma individual
                		ObserverGrafico observer=null;
                		nivel.addPowerUps(fabricaEntidades.getMonedas(posicion, visitor, cantidadMonedas,observer));
                	}
                	case 40:{
                		Visitante visitor=null;
                		Vector<Integer> direccion= new Vector<Integer>(1,0);
                		int velocidad =1;
                		ObserverGrafico observer=null;
                		nivel.addEnemigo(fabricaEntidades.getLakitu(posicion, visitor, direccion, velocidad,observer));
                    }
                	case 41:{
                		Visitante visitor=null;
                		Vector<Integer> direccion= new Vector<Integer>(1,0);
                		int velocidad =1;
                		ObserverGrafico observer=null;
                		nivel.addEnemigo(fabricaEntidades.getContextoKoopaTroopa(posicion, visitor, velocidad, direccion, observer));
                		
                	}
                	case 42:{
                		Visitante visitor=null;
                		Vector<Integer> direccion= new Vector<Integer>(1,0);
                		int velocidad =1;
                		ObserverGrafico observer=null;
                		nivel.addEnemigo(fabricaEntidades.getGoomba(posicion, visitor, direccion, velocidad, observer));
                	}
                	case 43:{
                		Visitante visitor=null;
                		Vector<Integer> direccion= new Vector<Integer>(1,0);
                		int velocidad =1;
                		ObserverGrafico observer=null;
                		nivel.addEnemigo(fabricaEntidades.getSpiny(posicion, visitor, direccion, velocidad, observer));
                		//Añadir Spiny
                	}
                	case 44:{
                		Visitante visitor=null;
                		Vector<Integer> direccion= new Vector<Integer>(1,0);
                		int velocidad =1;
                		ObserverGrafico observer=null;
                		nivel.addEnemigo(fabricaEntidades.getBuzzyBeetle(posicion, visitor, direccion, velocidad, observer));
                	}               
                }
			}
		} catch (IOException  e) {
			e.printStackTrace();
		} finally {
			//Limpio el lector del buffer, se lanze o no la excepción
			try {
				if(lectorBuffer!=null) {
					lectorBuffer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return nivel;
	}
	
}
