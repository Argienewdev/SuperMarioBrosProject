package generadores;
import fabricas.FabricaEntidades;
import juego.Nivel;
import juego.Silueta;
import elementos.*;
import java.util.*;
import java.io.*;

public class GeneradorDeNiveles {
	
	protected FabricaEntidades fabricaEntidades;
	
	protected FabricaEntidades fabricaSilueta;
	
	public GeneradorDeNiveles(FabricaEntidades fabricaEntidades){
		this.fabricaEntidades=fabricaEntidades;
	}
	public Nivel generarNivel(int numeroModo, String rutaTxtNivel ){
		
		Silueta silueta = fabricaEntidades.getSilueta(numeroModo);
		
		File nivelAGenerar = new File(rutaTxtNivel);
		try {
			Scanner scannerNivel= new Scanner(nivelAGenerar);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
