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

	public static void main(String[] args) {
		//System.out.println("hello world ! ");
		//objetivo � ler um arquivo .csv e "montar" uma arvore de decicao 
		
		//String csvArquivo ="C:\\Users\\ghost\\dados.csv";
		String csvArquivo ="/ARQUIVOS/DEVELOP/TreeDecision_ML/dados.csv";
		BufferedReader conteudoCSV = null;
		String linha ="";
		String csvSeparadorCampo = ";";
		ArrayList<Dados> listaDados = new ArrayList<>();
		
		//Lista Inicial CE
		List<Integer> CE = new ArrayList<Integer>();
		for(int i=0; i< 14; i++) {CE.add(i);}		
		
		// Array de propriedades a serem testadas.  Definidas estaticamente 
		List<String> PR = new ArrayList<String>();
		PR.add("HC");
		PR.add("GA");
		PR.add("RE");
		PR.add("DI");		
		
		
		try {
			conteudoCSV = new BufferedReader(new FileReader(csvArquivo));
			int i=1;
			while ((linha = conteudoCSV.readLine()) !=null ) {
				
				String [] dados = linha.split(csvSeparadorCampo);
				Dados dt1 =  new Dados();
				dt1.setN(i);
				dt1.setRisco(dados[1]);
				dt1.setHc(dados[2]);
				dt1.setDivida(dados[3]);
				dt1.setGarantia(dados[4]);
				listaDados.add(dt1);
				//CE[i] = i;
				
				System.out.println("[Data = " + dados[0]
						+ " , RISCO = " + dados[1]
					    + " , HCREDITO = " + dados[2]
					    + " , DIVIDA = " + dados[3]
					    + " , GARANTIA = " + dados[4]
					    + " , RENDA = " + dados[5]
					    + "]"
						
						);
				i++;
				
			}
		}catch (FileNotFoundException e) {
			System.out.println("Arquivo nao encontrado : \n" + e.getMessage());
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("IndexOitOfBounds : \n " + e.getMessage());
		}catch (IOException e) {
			System.out.println(" IO Eroo :\n " + e.getMessage());
			// TODO: handle exception
		}finally {
			if(conteudoCSV != null) {
				try {
					conteudoCSV.close();
//					for(int i=0; i< listaDados.size(); i++) {
//						System.out.println(listaDados.get(i).getN());
//						System.out.println(listaDados.get(i).getDivida());					
//						  
//					}
					
				}catch (IOException e) {
					System.out.println("IO Erro : \n "+ e.getMessage());
				}
			}
		}
		induzir_arvore(listaDados, PR);	
	}

	private static void induzir_arvore(List<Dados> ces, List pR) {
		//classe		
		List<String> classe = new ArrayList<String>();
		for(int i=0; i < ces.size(); i++) {
			//System.out.println(ces.get(i).getRisco());
			//classe.add(ces.get(i).getRisco());
			
		}
		Util u = new Util();
		Boolean res=  u.CompararClasses(ces);
		if(res) {
			System.out.println("Todos Elementos de Classes iguais !\n Retornar um no folha rotulado com essa classe !!");
		}else {
			System.out.println("Existem elementos diferentes !");
			if(pR.isEmpty()) {
				System.out.println("Propriedades vazias !\n retornar no folha rotulado com a disjuncao de todas as classes no conjuto exemplo");
			}else {
				System.out.println("selecione uma propriedade P e a faca a raiz da arvore atual");
				String P = (String) pR.get(0);
				System.out.println("Selecionado prop. = " + P);
				pR.remove(0);
				System.out.println("Removido propriedade = " + pR.toString());
				List<String> v_aux = new ArrayList<String>();
				List<Dados> particao_aux = new ArrayList<Dados>();
				if(P.equals("HC")) {
					//para cada valor V de P
					for(int i=0; i < ces.size(); i++) {						
						if(!v_aux.contains(ces.get(i).getHc())) {
							v_aux.add(ces.get(i).getHc());
						}						
					}// fim "for"
					
					System.out.println(v_aux.toString());
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
					
					induzir_arvore(particao_aux, v_aux);
					
					System.out.println("Teste estrutura manual");
					
					
					List<Tree> tt = new ArrayList<Tree>();
					
					Tree t = new Tree();
					
					t.setId(1);
					t.setNome("HC");
					t.setRotulo("RUIM");
					Tree t1 = new Tree();
					t1.setId_raiz(1);
					t1.setId(2);
					t1.setRotulo("NENHUM");
					t1.setNome("GA");
					t.ramos.add(t1);
					tt.add(t);
					
					for(int i=0; i < tt.size();i++ ) {
						System.out.println(tt.get(i).getId_raiz() + " --> " +tt.get(i).getNome() + " --> " + tt.get(i).getRotulo() );
						for(int j=0; j < tt.get(i).ramos.size();j++) {
							System.out.println(tt.get(i).ramos.get(j).getNome() + " --> " + tt.get(i).ramos.get(j).getRotulo());
							
							
							
						}
					}
				
					
				}
				
			}
		}
	
		
		
		
		
		
	}
	
	
}
