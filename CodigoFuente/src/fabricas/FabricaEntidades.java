package fabricas;
import java.util.Vector;

import elementos.*;
import juego.Silueta;
import visitors.Visitante;

public class FabricaEntidades {
	
	protected FabricaSprites fabricaSprites;
	
	public FabricaEntidades(FabricaSprites fabricaSprites) {
		this.fabricaSprites=fabricaSprites;
	}
	
	public ContextoMario getMario(Vector<Integer> posicion,Visitante visitor, int vida){
		Sprite spriteMario = fabricaSprites.getMario();
		Vector<Integer> direccion= new Vector<Integer>(0,0);
		int velocidad=0;
		EstadoMario estadoInicial=new MarioDefault();
		ContextoMario mario= new ContextoMario(spriteMario,posicion, visitor, direccion, velocidad, vida,estadoInicial);
		return mario;
	}
	
}
