package id3;

import java.util.ArrayList;
import java.util.List;

public class Util {
	public static void ExibirEstado(ArrayList<String> estados) {
	}
	
	public Boolean  CompararClasses(List<Dados> ces) {		
		String primeiroElemento =ces.get(0).getRisco() ; // já pega o primeiro antes do for
		boolean tudoIgual = true;
		  
		    for (int i = 1; i < ces.size(); i++) { // já temos o elemento zero, então o for pode começar em 1
		        if (!ces.get(i).getRisco().equals(primeiroElemento)){
		            tudoIgual = false;
		           // System.out.println(ces.get(i).getRisco() + " !=  " + primeiroElemento );	
		            break; // sai do loop, já achamos um elemento diferente, não precisa continuar
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
