package estadisticoDeOrdenK;

import java.util.Arrays;

public class OrderAndSelect implements BuscadorEstadisticoDeOrdenK {

	@Override
	public Integer buscarEstadisticoDeOrdenK(Integer[] list, int k) {
		if (k < 0 || list.length == 0 || k >= list.length)
			return null;
		
		Arrays.sort(list); // Quicksort doble pivot	
		
		return list[k];
	}
}
