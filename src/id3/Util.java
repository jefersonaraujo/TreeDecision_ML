package id3;

import java.util.ArrayList;
import java.util.List;

public class Util {
	public static void ExibirEstado(ArrayList<String> estados) {
	}
	
	public Boolean  CompararClasses(List<Dados> ces) {		
		String primeiroElemento =ces.get(0).getRisco() ; // j� pega o primeiro antes do for
		boolean tudoIgual = true;
		  
		    for (int i = 1; i < ces.size(); i++) { // j� temos o elemento zero, ent�o o for pode come�ar em 1
		        if (!ces.get(i).getRisco().equals(primeiroElemento)){
		            tudoIgual = false;
		           // System.out.println(ces.get(i).getRisco() + " !=  " + primeiroElemento );	
		            break; // sai do loop, j� achamos um elemento diferente, n�o precisa continuar
		        }
		    }

	
//		for(int i=0; i < ces.size(); i++) {
//			for (int j = 0 ;j < ces.size(); j++) {
//				if(!ces.get(i).getRisco().equals(ces.get(j).getRisco())) {
//					iguais=false;
//					System.out.println("falso" + iguais);
//					System.out.println(ces.get(i).getRisco() + " !=  " + ces.get(j).getRisco()  );	
//					break;
//					
//					
//				}else {
//					iguais=true;
//					System.out.println("ok" + iguais);
//					System.out.println(ces.get(i).getRisco() + " =  " + ces.get(j).getRisco()  );
//				}
//				
//			}
//			
//			
//			//classe.add(classes.get(i).getRisco());
//			
//		}
		return tudoIgual;
		
	}
}
