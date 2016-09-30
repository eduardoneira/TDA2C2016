package estadisticoDeOrdenK;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Test;

public class FuerzaBrutaTest {
	
	private static final int N = 1000;
	private static final int MAXINT = 10000;
	
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
	public void test() {
		Integer[] conjunto = this.setUpConjunto();
		//Mapa para los posibles valores de k por numero del conjunto
		Map<Integer,List<Integer>> kPosibles = getKPosibles(conjunto.clone());
			
		for(int k = 0; k < conjunto.length; k++){
			for (int c = 0; c < conjunto.length; c++){
				if (kPosibles.get(conjunto[c]).contains(k)){
					assertTrue(FuerzaBruta.solve(conjunto, k, conjunto[c]));
				}else {
					assertFalse(FuerzaBruta.solve(conjunto, k, conjunto[c]));
				}
			}
		}
	}

}
