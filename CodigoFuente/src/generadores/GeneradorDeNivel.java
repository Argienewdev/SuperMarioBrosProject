package generadores;
import fabricas.*;
import juego.Nivel;
import juego.Silueta;
import java.util.*;
import java.io.*;

public class GeneradorDeNivel {
	
	protected FabricaEntidades fabricaEntidades;
	protected FabricaSilueta fabricaSilueta;
	protected FabricaPlataformas fabricaPlataformas;
	
	public GeneradorDeNivel(FabricaEntidades fabricaEntidades){
		this.fabricaEntidades=fabricaEntidades;
	}
	public Nivel generarNivel(int numeroModo, String rutaTxtNivel ){
		
		Silueta silueta = fabricaSilueta.getSilueta(numeroModo);
		Nivel nivel= new Nivel(silueta);
		FileReader archivoDeNivel=null;
		BufferedReader lectorBuffer=null;
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
               
                Vector<Integer> posicion= new Vector<Integer>(numeros[1],numeros[2]);
                switch(numeros[0]) {
                	case 0:{
            			nivel.addPlataforma(fabricaPlataformas.getVacio(posicion, null));
            		}
                	case 1:{
                		nivel.addPlataforma(fabricaPlataformas.getLadrillo(posicion, null,0));
                	}
                	case 2:{
                		nivel.addPlataforma(fabricaPlataformas.getLadrillo(posicion, null,numeros[3]));
                	}
                	case 3:{
                		//Añadir tuberia vacia
                	}
                	case 4:{
                		//Añadir tuberia con piranha
                	}
                	case 6:{
                		nivel.addPlataforma(fabricaPlataformas.getBandera(posicion, null));
                	}
                	case 7:{
                		nivel.addPlataforma(fabricaPlataformas.getPrincesaPeach(posicion, null));
                	}
                	case 20:{
                		//Analizar constructor moneda
                	}
                	case 21:{
                		//Añadir Estrella
                	}
                	case 22:{
                		//Añadir ChampinionVerde                		           
                	}
                	case 23:{
                		//Añadir flor de fuego
                	}
                	case 24:{
                		//Añadir Super champinion
                	}
                	case 40:{
                		//Añadir Lakitu
                	}
                	case 41:{
                		//Añadir  Koopa Troopa
                	}
                	case 42:{
                		//Añadir Goomba
                	}
                	case 43:{
                		//Añadir Spiny
                	}
                	case 44:{
                		//Añadir Buzzy Beetle
                	}
                	case 45:{
                		//Añadir Bowser
                	}
                }
                //Falta terminar, y hay que pasar el visitor a cada elemento que se le añade al nivel
			}
		
		} catch (IOException  e) {
			e.printStackTrace();
		} finally {
			//Limpio el lector del buffer, se lanze o no la exepcion
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
