package actionsControllers;

import java.util.HashMap;
import java.util.Map;

public class FactoryActioner {

	private Map<Object, MyActioner> actions = new HashMap<>();
	
	public FactoryActioner() // deberia recibir un set de buttons / radioButtons  
	{
		actions = new HashMap<>();
		actions.put(null, new PlayActioner()); // aca en el null tiene que tener el boton play
		actions.put(null, new ConfigurationActioner());
		
		// aca cargar todos los botones asociados con sus actioners
	}
	
	public MyActioner getActioner(Object button) 
	{
		return actions.get(button);
	}
	
}
