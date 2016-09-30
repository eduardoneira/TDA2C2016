package estadisticoDeOrdenK;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

//TODO Podriamos generalizar los tests para todos los algoritmos.
public class FuerzaBrutaTest {
	
	private static final int N = 1000;
	private static final int MAXINT = 10000;
	
	private BuscadorEstadisticoDeOrdenK fuerzaBruta;
	
	@Before
	public void setup(){
		fuerzaBruta = new FuerzaBruta();
	}
	
	private Integer[] setUpConjunto(){
		Random random = new Random();
		Integer[] conjunto = new Integer[N];
		for (int i = 0; i < N ; i++){
			conjunto[i] = random.nextInt(MAXINT);
		}
		return conjunto;
	}
	
	private Map<Integer,List<Integer>> getKPosibles(Integer[] conjunto){
		Arrays.sort(conjunto);
		Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
		for (int i = 0; i < conjunto.length; i++){
			Integer actual = conjunto[i];
			List<Integer> listActual;
			
			if (map.containsKey(actual)){
				listActual = map.get(actual);
			}else {
				listActual = new ArrayList<Integer>();
			}
			
			listActual.add(i);
			map.put(actual,listActual);
		}
		return map;
	}
	
	@Test
	//TODO Actualizar este test.
	public void test() {
		Integer[] conjunto = this.setUpConjunto();
		//Mapa para los posibles valores de k por numero del conjunto
		Map<Integer,List<Integer>> kPosibles = getKPosibles(conjunto.clone());
		BuscadorEstadisticoDeOrdenK fuerzaBruta = new FuerzaBruta();
		for(int k = 0; k < conjunto.length; k++){
			for (int c = 0; c < conjunto.length; c++){
				if (kPosibles.get(conjunto[c]).contains(k)){
					assertEquals(fuerzaBruta.buscarEstadisticoDeOrdenK(conjunto, k), conjunto[c]);
				}else {
					assertNotEquals(fuerzaBruta.buscarEstadisticoDeOrdenK(conjunto, k), conjunto[c]);
				}
			}
		}
	}
	
	@Test
	public void buscarEnArrayVacioDevuelveNull(){
		Integer[] conjunto = new Integer[0];
		assertNull(fuerzaBruta.buscarEstadisticoDeOrdenK(conjunto, 1));
	}
	
	@Test
	public void buscarConKMayorALongitudDevuelveNull(){
		int longitud = 3;
		Integer[] conjunto = new Integer[longitud];
		conjunto[0] = 3;
		conjunto[1] = 5;
		conjunto[2] = 2;
		
		int k = longitud;
		assertNull(fuerzaBruta.buscarEstadisticoDeOrdenK(conjunto, 3));
	}
	

	@Test
	public void buscarConKNegativoDevuelveNull(){
		int longitud = 3;
		Integer[] conjunto = new Integer[longitud];
		conjunto[0] = 3;
		conjunto[1] = 5;
		conjunto[2] = 2;
		int k = -1;
		assertNull(fuerzaBruta.buscarEstadisticoDeOrdenK(conjunto, k));
	}
	
	@Test
	public void buscarConKEntreCeroYUltimaPosicionDevuelveEstadisticoDeOrdenK(){
		Integer[] conjunto = new Integer[3];
		conjunto[0] = 3;
		conjunto[1] = 5;
		conjunto[2] = 2;
		int k = 1;
		assertEquals(fuerzaBruta.buscarEstadisticoDeOrdenK(conjunto, k), new Integer(3));
	}
	
	@Test
	public void buscarConKIgualCeroDevuelveElMenor(){
		Integer[] conjunto = new Integer[3];
		conjunto[0] = 3;
		conjunto[1] = 5;
		conjunto[2] = 2;
		int k = 0;
		assertEquals(fuerzaBruta.buscarEstadisticoDeOrdenK(conjunto, k), new Integer(2));
	}
	
	
	@Test
	public void buscarConKIgualUltimaPosicionDevuelveElMayor(){
		int longitud = 3;
		Integer[] conjunto = new Integer[longitud];
		conjunto[0] = 3;
		conjunto[1] = 5;
		conjunto[2] = 2;
		int k = longitud - 1;
		assertEquals(fuerzaBruta.buscarEstadisticoDeOrdenK(conjunto, k), new Integer(5));
	}
	
	
}
