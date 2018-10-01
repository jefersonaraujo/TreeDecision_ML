package id3;

import java.util.ArrayList;
import java.util.List;

public class Util {
	public static void ExibirEstado(ArrayList<String> estados) {
	}
	
	public static void CompararClasses(List<Dados> ces) {
		boolean iguais=false;
		List<String> classe = new ArrayList<String>();
		for(int i=0; i < ces.size(); i++) {
			for (int j = 0 ;j < ces.size(); j++) {
				if(ces.get(i).getRisco().equals(ces.get(j).getRisco())) {
					iguais=true;
					System.out.println("ok" + iguais);
					System.out.println(ces.get(i).getRisco() + " =  " + ces.get(j).getRisco()  );
					
				}else {
					iguais=false;
					System.out.println("falso" + iguais);
					System.out.println(ces.get(i).getRisco() + " !=  " + ces.get(j).getRisco()  );
					break;
				}
				
			}
			
			//classe.add(classes.get(i).getRisco());
			
		}
		
	}
}
