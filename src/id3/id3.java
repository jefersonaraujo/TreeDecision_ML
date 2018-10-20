package id3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



public class id3 {
	
	public Tree tt = new Tree();
	//public static List<String> PR = new ArrayList<String>(); 

	
	public static void main(String[] args) {
		int id;
		
		Util util = new Util();
		//System.out.println("hello world ! ");
		//objetivo  ler um arquivo .csv e "montar" uma arvore de decicao 
		
		String csvArquivo ="C:\\Users\\ghost\\dados.csv";
		//String csvArquivo ="/ARQUIVOS/DEVELOP/TreeDecision_ML/dados.csv";
		util.LerArquivo(csvArquivo);
/***************************************************************************************************/
		
		ArrayList<Dados> listaDados = new ArrayList<>();
		listaDados = (ArrayList<Dados>) util.LerArquivo(csvArquivo);
		
/***************************************************************************************************/		
		//Lista Inicial CE
//		List<Integer> CE = new ArrayList<Integer>();
//		for(int i=1; i< 15; i++) {CE.add(i);}		
//		System.out.println("Lista de CE inicial " + CE.toString());
/***************************************************************************************************/	
		// Array de propriedades a serem testadas.  Definidas estaticamente 
		//PR.add("HC");
		//PR.add("GA");
	//	PR.add("RE");
		//PR.add("DI");
		
		List PR;
		PR = util.Propriedades();
		System.out.println("Lista de PR inicial " + PR.toString());
/***************************************************************************************************/		

		///tree servirá para adicionar as arvores.
		List<Tree> tree = new ArrayList<Tree>();

		
		

		
	
		induzir_arvore(listaDados, PR, null);	
	}

	private static void induzir_arvore(List<Dados> ces, List pR, List valor) {
/***************************************************************************************************/				
		//chamar função comparar
		Util u = new Util();
		List<String> pr_aux = pR;
		Boolean res=  u.CompararClasses(ces);
		List PR;
		PR = u.Propriedades();
		
/***************************************************************************************************/	
		if(res) {
			System.out.println("Todos Elementos de Classes iguais !\n Retornar um no folha rotulado com essa classe !!");
			System.out.println(valor.get(0) + " --> " + valor.get(1) +  " --> " + ces.get(0).getRisco() );
//			for(int i =0; i < ces.size();i++) {
//				System.out.println(ces.get(i).getN() + "     | " + ces.get(i).getRisco() + "     |" + ces.get(i).getHc() + "    | "  + ces.get(i).getDivida()  + "    | " + ces.get(i).getGarantia() + " | "  );
//				
//			}
			

		}else if(pr_aux.isEmpty()) {
			System.out.println("Existem elementos diferentes !");
			///if(pr_aux.isEmpty()) {
				System.out.println("Propriedades vazias !\n retornar no folha rotulado com a disjuncao de todas as classes no conjuto exemplo");
//				for(int i =0; i < ces.size();i++) {
//					//System.out.println(valor.get(0) + " --> " + valor.get(1) +  " --> " + ces.get(0).getRisco() );
//				///System.out.println(ces.get(i).getN() + "     | " + ces.get(i).getRisco() + "     |" + ces.get(i).getHc() + "    | "  + ces.get(i).getDivida()  + "    | " + ces.get(i).getGarantia() + " | "  );
//				
//			}
				
			}
		else {		
			
				
				System.out.println("selecione uma propriedade P e a faca a raiz da arvore atual");
				String P = (String) pr_aux.get(0);
				System.out.println("Selecionado a Propriedade. = " + P);
				
				pr_aux.remove(0);
				
				System.out.println("Propriedade Restantes da Lista  = " + pr_aux.toString());
				List<String> v_aux = new ArrayList<String>();
				List<Dados> particao_aux = new ArrayList<Dados>();
				
				if(P.equals("HC")) {
					for(int i=0; i < ces.size(); i++) {	
						//se não tiver ramos iguais adiciona no aux
						if(!v_aux.contains(ces.get(i).getHc())) {
							v_aux.add(ces.get(i).getHc());
						}
					}
					
					
					System.out.println("LISTA : " + v_aux.toString());

					String V = v_aux.get(0);
					System.out.println("Pego o primeiro = " + V );
					System.out.println(P + "-->" + v_aux.get(0));
					
					////contrua particao com os elementos de contunto exempo com valores V para propriedade P
					for(int i =0; i < ces.size();i++) {
						//System.out.println("Ramos de  "+ P +"  -> " +v_aux.get(i) + "   | " + ces.get(i).getRisco());
						
						if(ces.get(i).getHc().equals(V)){
							//System.out.println(ces.get(i).getN());
							///System.out.println(ces.get(i).getN() + "     | " + ces.get(i).getRisco() + "     |" + ces.get(i).getHc() + "    | "  + ces.get(i).getDivida()  + "    | " + ces.get(i).getGarantia() + " | "  + ces.get(i) .getRenda());
							particao_aux.add(ces.get(i));
						}
						
					}//fim for
				//	System.out.println(P + "-->" + v_aux.get(0) + "---> " + ces.get(0).getRisco());
					//continuacao para cada valor V de P				
					for(int k=0; k < v_aux.size(); k++) {
						//System.out.println(P +" -> " + v_aux.get(k));
						List<String> nodo_aux = new ArrayList<String>();
						
						nodo_aux.add(P);
						nodo_aux.add(V);
						
						induzir_arvore(particao_aux, pr_aux,nodo_aux);
					}
					
					
					
				} // fim IF

				
				if(P.equals("GA")) {
					for(int i=0; i < ces.size(); i++) {	
						//se não tiver ramos iguais adiciona no aux
						if(!v_aux.contains(ces.get(i).getGarantia())) {
							v_aux.add(ces.get(i).getGarantia());
						}
					}
						System.out.println(v_aux.toString());

					String V = v_aux.get(0);
					System.out.println("Pego o primeiro = " + V );
					System.out.println(P + "-->" + v_aux.get(0));
					
					////contrua particao com os elementos de contunto exempo com valores V para propriedade P
					for(int i =0; i < ces.size();i++) {
						//System.out.println("Ramos de  "+ P +"  -> " +v_aux.get(i) + "   | " + ces.get(i).getRisco());
						
						if(ces.get(i).getGarantia().equals(V)){
							//System.out.println(ces.get(i).getN());
							System.out.println(ces.get(i).getN() + "     | " + ces.get(i).getRisco() + "     |" + ces.get(i).getHc() + "    | "  + ces.get(i).getDivida()  + "    | " + ces.get(i).getGarantia() + " | "   + ces.get(i).getRenda() );
							particao_aux.add(ces.get(i));
						}
						
					}//fim for	
					
					//continuacao para cada valor V de P				
					for(int k=0; k < v_aux.size(); k++) {
						//System.out.println(P +" -> " + v_aux.get(k));
						List<String> nodo_aux = new ArrayList<String>();
						nodo_aux.add(P);
						nodo_aux.add(V);
						
						induzir_arvore(particao_aux, pr_aux,nodo_aux);
					}
					
					
				} // fim IF
				
				if(P.equals("DI")) {
					for(int i=0; i < ces.size(); i++) {	
						//se não tiver ramos iguais adiciona no aux
						if(!v_aux.contains(ces.get(i).getDivida())) {
							v_aux.add(ces.get(i).getDivida());
						}
					}
						System.out.println(v_aux.toString());

					String V = v_aux.get(0);
					System.out.println("Pego o primeiro = " + V );
					System.out.println(P + "-->" + v_aux.get(0));
					
					////contrua particao com os elementos de contunto exempo com valores V para propriedade P
					for(int i =0; i < ces.size();i++) {
						//System.out.println("Ramos de  "+ P +"  -> " +v_aux.get(i) + "   | " + ces.get(i).getRisco());
						
						if(ces.get(i).getDivida().equals(V)){
							//System.out.println(ces.get(i).getN());
							System.out.println(ces.get(i).getN() + "     | " + ces.get(i).getRisco() + "     |" + ces.get(i).getHc() + "    | "  + ces.get(i).getDivida()  + "    | " + ces.get(i).getGarantia() + " | "  );
							particao_aux.add(ces.get(i));
						}
						
					}//fim for	
					
					//continuacao para cada valor V de P				
					for(int k=0; k < v_aux.size(); k++) {
						
						//System.out.println(P +" -> " + v_aux.get(k));
						List<String> nodo_aux = new ArrayList<String>();
						nodo_aux.add(P);
						nodo_aux.add(V);
						
						induzir_arvore(particao_aux, pr_aux,nodo_aux);
					}
					
					
				} 
				
				
				if(P.equals("RE")) {
					for(int i=0; i < ces.size(); i++) {	
						//se não tiver ramos iguais adiciona no aux
						if(!v_aux.contains(ces.get(i).getRenda())) {
							v_aux.add(ces.get(i).getRenda());
						}
					}
						System.out.println(v_aux.toString());

					String V = v_aux.get(0);
					System.out.println("Pego o primeiro = " + V );
					System.out.println(P + "-->" + v_aux.get(0));
					
					////contrua particao com os elementos de contunto exempo com valores V para propriedade P
					for(int i =0; i < ces.size();i++) {
						//System.out.println("Ramos de  "+ P +"  -> " +v_aux.get(i) + "   | " + ces.get(i).getRisco());
						
						if(ces.get(i).getRenda().equals(V)){
							//System.out.println(ces.get(i).getN());
							System.out.println(ces.get(i).getN() + "     | " + ces.get(i).getRisco() + "     |" + ces.get(i).getHc() + "    | "  + ces.get(i).getDivida()  + "    | " + ces.get(i).getGarantia() + " | "  );
							particao_aux.add(ces.get(i));
						}
						
					}//fim for	
					
					//continuacao para cada valor V de P				
					for(int k=0; k < v_aux.size(); k++) {
						//System.out.println(P +" -> " + v_aux.get(k));
						List<String> nodo_aux = new ArrayList<String>();
						nodo_aux.add(P);
						nodo_aux.add(V);
						
						induzir_arvore(particao_aux, pr_aux,nodo_aux);
					}
					
				} 
				
				
				
					
				}
				
			}
		}
	
		
		
		
		
		
	///}
	
	
