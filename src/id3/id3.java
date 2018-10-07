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
		List<String> PR = new ArrayList<String>(); PR.add("HC");PR.add("GA"); PR.add("RE");	PR.add("DI");	
		System.out.println("Lista de PR inicial " + PR.toString());
/***************************************************************************************************/		

		///tree servirá para adicionar as arvores.
		List<Tree> tree = new ArrayList<Tree>();

		
		

		
	
		induzir_arvore(listaDados, PR);	
	}

	private static void induzir_arvore(List<Dados> ces, List pR) {
/***************************************************************************************************/				
		//chamar função comparar
		Util u = new Util();
		List<String> pr_aux = pR;
		Boolean res=  u.CompararClasses(ces);
		
/***************************************************************************************************/	
		if(res) {
			System.out.println("Todos Elementos de Classes iguais !\n Retornar um no folha rotulado com essa classe !!");

		}else {
			System.out.println("Existem elementos diferentes !");
			if(pr_aux.isEmpty()) {
				System.out.println("Propriedades vazias !\n retornar no folha rotulado com a disjuncao de todas as classes no conjuto exemplo");
			}else {
				
			
				
				System.out.println("selecione uma propriedade P e a faca a raiz da arvore atual");
				String P = (String) pr_aux.get(0);
				System.out.println("Selecionado a Propriedade. = " + P);
				
				System.out.println();
				pR.remove(0);
				System.out.println("Propriedade Restantes da Lista  = " + pr_aux.toString());
							
				
				
				if(P.equals("HC")) {
					System.out.println( "PROPRIEDADA DA RODADA " +P);
					//listas temporarias
					List<String> v_aux = new ArrayList<String>();
					List<Dados> particao_aux = new ArrayList<Dados>();
					
		
					//para cada valor V de P
					for(int i=0; i < ces.size(); i++) {	
						//se não tiver ramos iguais adiciona no aux
						if(!v_aux.contains(ces.get(i).getHc())) {
							v_aux.add(ces.get(i).getHc());
						}
						
						System.out.println(v_aux.toString());
						
				}// fim "for"
					
					System.out.println("Ramos de  "+ P +"  -> " +v_aux.toString());
					//System.out.println(pR.toString());
					
					System.out.println("Crie um ramo da arvore rotulado com V");
					String V = v_aux.get(0);
					System.out.println("Pego o primeiro = " + V );
					System.out.println(P + "-->" + v_aux.get(0));
					v_aux.remove(0);//remover da list
					
					
					//System.out.println(v_aux.toString()); //lista de
					//contrua particao com os elementos de contunto exempo com valores V para propriedade P
					for(int i=0;i < ces.size(); i++) {
						if(ces.get(i).getHc().equals(V)) {
							//particoes
							System.out.println(ces.get(i).getN()); 
							particao_aux.add(ces.get(i));
							
						}
						
						
					
						
					}//exibindo particoes montadas.
					for(int i=0; i < particao_aux.size(); i++) {	
						System.out.println(particao_aux.get(i).getRisco());
											
					}// fim "for"
					
					induzir_arvore(particao_aux, pr_aux);

					}
				
				if(P.equals("GA")) {
					System.out.println( "PROPRIEDADA DA RODADA " +P);
					//listas temporarias
					List<String> v_aux = new ArrayList<String>();
					List<Dados> particao_aux = new ArrayList<Dados>();
					
		
					//para cada valor V de P
					for(int i=0; i < ces.size(); i++) {	
						//se não tiver ramos iguais adiciona no aux
						if(!v_aux.contains(ces.get(i).getHc())) {
							v_aux.add(ces.get(i).getHc());
						}
						
				}// fim "for"
					
					System.out.println("Ramos de  "+ P +"  -> " +v_aux.toString());
					//System.out.println(pR.toString());
					
					System.out.println("Crie um ramo da arvore rotulado com V");
					String V = v_aux.get(0);
					System.out.println("Pego o primeiro = " + V );
					System.out.println(P + "-->" + v_aux.get(0));
					v_aux.remove(0);//remover da list
					
					
					//System.out.println(v_aux.toString()); //lista de
					//contrua particao com os elementos de contunto exempo com valores V para propriedade P
					for(int i=0;i < ces.size(); i++) {
						if(ces.get(i).getHc().equals(V)) {
							//particoes
							System.out.println("Particoes " +ces.get(i).getN()); 
							particao_aux.add(ces.get(i));
							
						}
						
						
					
						
					}//exibindo particoes montadas.
					for(int i=0; i < particao_aux.size(); i++) {	
						System.out.println(particao_aux.get(i).getN() + "     | " + particao_aux.get(i).getRisco() + "     |" + particao_aux.get(i).getHc() + "    | "  + particao_aux.get(i).getDivida()  + "    | " + particao_aux.get(i).getGarantia() + " | "  );
											
					}// fim "for"
					
					induzir_arvore(particao_aux, pR);

					}
				
				if(P.equals("RE")) {
					System.out.println( "PROPRIEDADA DA RODADA " +P);
					//listas temporarias
					List<String> v_aux = new ArrayList<String>();
					List<Dados> particao_aux = new ArrayList<Dados>();
					
		
					//para cada valor V de P
					for(int i=0; i < ces.size(); i++) {	
						//se não tiver ramos iguais adiciona no aux
						if(!v_aux.contains(ces.get(i).getHc())) {
							v_aux.add(ces.get(i).getHc());
						}
						
				}// fim "for"
					
					System.out.println("Ramos de  "+ P +"  -> " +v_aux.toString());
					//System.out.println(pR.toString());
					
					System.out.println("Crie um ramo da arvore rotulado com V");
					String V = v_aux.get(0);
					System.out.println("Pego o primeiro = " + V );
					System.out.println(P + "-->" + v_aux.get(0));
					v_aux.remove(0);//remover da list
					
					
					//System.out.println(v_aux.toString()); //lista de
					//contrua particao com os elementos de contunto exempo com valores V para propriedade P
					for(int i=0;i < ces.size(); i++) {
						if(ces.get(i).getHc().equals(V)) {
							//particoes
							System.out.println(ces.get(i).getN()); 
							particao_aux.add(ces.get(i));
							
						}
						
						
					
						
					}//exibindo particoes montadas.
					for(int i=0; i < particao_aux.size(); i++) {	
						System.out.println(particao_aux.get(i).getRisco());
											
					}// fim "for"
					
					induzir_arvore(particao_aux, pR);

					}
				
				if(P.equals("DI")) {
					System.out.println( "PROPRIEDADA DA RODADA " +P);
					//listas temporarias
					List<String> v_aux = new ArrayList<String>();
					List<Dados> particao_aux = new ArrayList<Dados>();
					
		
					//para cada valor V de P
					for(int i=0; i < ces.size(); i++) {	
						//se não tiver ramos iguais adiciona no aux
						if(!v_aux.contains(ces.get(i).getHc())) {
							v_aux.add(ces.get(i).getHc());
						}
						
				}// fim "for"
					
					System.out.println("Ramos de  "+ P +"  -> " +v_aux.toString());
					//System.out.println(pR.toString());
					
					System.out.println("Crie um ramo da arvore rotulado com V");
					String V = v_aux.get(0);
					System.out.println("Pego o primeiro = " + V );
					System.out.println(P + "-->" + v_aux.get(0));
					v_aux.remove(0);//remover da list
					
					
					//System.out.println(v_aux.toString()); //lista de
					//contrua particao com os elementos de contunto exempo com valores V para propriedade P
					for(int i=0;i < ces.size(); i++) {
						if(ces.get(i).getHc().equals(V)) {
							//particoes
							System.out.println(ces.get(i).getN()); 
							particao_aux.add(ces.get(i));
							
						}
						
						
					
						
					}//exibindo particoes montadas.
					for(int i=0; i < particao_aux.size(); i++) {	
						System.out.println(particao_aux.get(i).getRisco());
											
					}// fim "for"
					
					induzir_arvore(particao_aux, pR);

					}
				
				
//				if(P.equals("HC")) {
//					List<String> v_aux = new ArrayList<String>();
//					List<Dados> particao_aux = new ArrayList<Dados>();
//					System.out.println(v_aux.toString());
//					//para cada valor V de P
//					for(int i=0; i < ces.size(); i++) {	
//						//se não tiver ramos iguais adiciona no aux
//						if(!v_aux.contains(ces.get(i).getHc())) {
//							v_aux.add(ces.get(i).getHc());
//							
//						}
////						if(!v_aux.contains(ces.get(i).getDivida())) {
////							v_aux.add(ces.get(i).getDivida());
////						}
////						if(!v_aux.contains(ces.get(i).getGarantia())) {
////							v_aux.add(ces.get(i).getGarantia());
////						}
////						if(!v_aux.contains(ces.get(i).getRisco())) {
////							v_aux.add(ces.get(i).getRisco());
////						}
//						
//					}// fim "for"
//					
//					System.out.println("Ramos " +v_aux.toString());
//					//System.out.println(pR.toString());
//					
//					System.out.println("Crie um ramo da arvore rotulado com V");
//					String V = v_aux.get(0);
//					System.out.println("Pego o primeiro = " + V );
//					System.out.println(P + "-->" + v_aux.get(0));
//					v_aux.remove(0);//remover da list
//					//System.out.println(v_aux.toString()); //lista de
//					//contrua particao com os elementos de contunto exempo com valores V para propriedade P
//					for(int i=0;i < ces.size(); i++) {
//						if(ces.get(i).getHc().equals(V)) {
//							//particoes
//							System.out.println(ces.get(i).getN()); 
//							particao_aux.add(ces.get(i));
//							
//						}
//						
//						
//					
//						
//					}//exibindo particoes montadas.
//					for(int i=0; i < particao_aux.size(); i++) {	
//						System.out.println(particao_aux.get(i).getRisco());
//											
//					}// fim "for"
//					
//					induzir_arvore(particao_aux, v_aux);
//					
////					System.out.println("Teste estrutura manual");
////					
////					
////					List<Tree> tt = new ArrayList<Tree>();
////					
////					Tree t = new Tree();
////					
////					t.setId(1);
////					t.setNome("HC");
////					t.setRotulo("RUIM");
////					String ramos[][] ={ {"NENHUM"}, {"ALTO RISCO"} };
////					System.out.println(ramos[0][0] +" ---> " + ramos[1][0] );
////					
////					t.setNo(ramos);
////					
////					Tree t1 = new Tree();
////					t1.setId_raiz(1);
////					t1.setId(2);
////					t1.setRotulo("NENHUM");
////					t1.setNome("GA");
////					t.ramos.add(t1);
////					tt.add(t);
////					
////					for(int i=0; i < tt.size();i++ ) {
////						System.out.println(tt.get(i).getId_raiz() + " --> " +tt.get(i).getNome() + " --> " + tt.get(i).getRotulo() );
////						for(int j=0; j < tt.get(i).ramos.size();j++) {
////							System.out.println(tt.get(i).ramos.get(j).getNome() + " --> " + tt.get(i).ramos.get(j).getRotulo());
////							
////							
////							
////						}
////					}
////					List<Ramo> v_aux2 = new ArrayList<Ramo>();
////					Ramo r = new Ramo();
////					r.setId(1);
////					r.setNome("HC");
////					r.setRotulo("RUIM");
////					Ramo r2 = new Ramo();
////					r2.setId(2);
////					r2.setId_pai(1);
////					r2.setNome("GA");
////					r2.setRotulo("NENHUM");
////					r.ramo.add(r2);
////					v_aux2.add(r);
////					
////					
////					List<String> v_aux3 = new ArrayList<String>();
////					String ai ;
////					for(int i=0; i < v_aux2.size();i++ ) {
////						System.out.println(v_aux2.get(i).getId_pai() + " --> " + v_aux2.get(i).getId()  + " --> " + v_aux2.get(i).getNome() + " --> " + v_aux2.get(i).getRotulo() );
////						ai= v_aux2.get(i).getId_pai() + " --> " + v_aux2.get(i).getId()  + " --> " + v_aux2.get(i).getNome() + " --> " + v_aux2.get(i).getRotulo();
////						v_aux3.add(ai);				
////						//System.out.println(ai);						
////							
////						}
////					String listString = "";
////
////					for (String s : v_aux3)
////					{
////					    listString += s + "\t";
////					}
////					
////					System.out.println(listString);
//					}
				
				
				
					
				}
				
			}
		}
	
		
		
		
		
		
	}
	
	
