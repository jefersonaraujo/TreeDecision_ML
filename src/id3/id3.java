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
			}
		}
		ArrayList uniqueList = (ArrayList) classe.stream().distinct().collect(Collectors.toList());
		String collectAll = classe.stream().collect(Collectors.joining(", "));
		System.out.println(collectAll); //=> CO2, CH4, SO2, CO2, CH4 etc..
		String collectDistinct = classe.stream().collect(Collectors.joining(", "));
		System.out.println(collectDistinct); //=> CO2, CH4, SO2
		for(int i=0; i < pR.size(); i++) {
			//System.out.println(pR.get(i));
		}
		
		
		
		
		
	}
	
	
}
