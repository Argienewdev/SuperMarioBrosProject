package generadores;
import fabricas.FabricaEntidades;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class GeneradorDeNiveles {
	protected FabricaEntidades fabrica_entidades;
	public GeneradorDeNiveles(FabricaEntidades fabricaEntidades){
		this.fabrica_entidades=fabricaEntidades;
	}
	public void generarNivel(String rutaTxtNivel){
		File nivelAGenerar = new File(rutaTxtNivel);
		try {
			Scanner scannerNivel= new Scanner(nivelAGenerar);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
