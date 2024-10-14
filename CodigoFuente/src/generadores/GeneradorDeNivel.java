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
                /*Manejo los numeros de la siguiente manera, en el txt, hay 3 o mas numeros,
                 * el primero es un mapeo al elemento del nivel, el segundo y tercer componente
                 * corresponeden a las coordenadas, x e y.
                 * 	En esta version simplificada solo coloco ladrillos, los cuales estan mapeados 
                 * al numero 1
                */
                Vector<Integer> posicion= new Vector<Integer>(numeros[1],numeros[2]);
                switch(numeros[0]) {
                	case 1:{
                		nivel.addPlataforma(fabricaPlataformas.getLadrillo(posicion, null));
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
