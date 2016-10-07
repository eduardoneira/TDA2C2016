package grafos;

import java.util.HashMap;
import java.util.Map;

//TODO : Refactor a constructor y limitar como agregar aristas. Además revisar si esta bien
public class Grilla extends Digrafo{

	private Map<Integer,Punto> grilla;
	
	public Grilla(int n) {
		super(n);
		this.grilla = new HashMap<>();
		
		boolean encontreN2 = false;
		int n2 = 0;
		
		while (encontreN2){
			n2++;
			if (Math.pow(n2, 2) > n){
				encontreN2=true;
			}
		}
		
		int x = 0;
		int y = 0;
		for (int i = 0; i < n; i++){
			this.grilla.put(i, new Punto(x, y));
			x++;
			if (x % n2 == 0){
				x = 0;
				y++;
			}
		}
	}


}
