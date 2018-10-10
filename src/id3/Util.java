package id3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

		return tudoIgual;
		
	}
	
	public Dados CriarParticoes(Dados dados, String valor) {
	
		return null;
	}
	public Tree CriarArvore(String nome, String  rotulo) {
		
		return null;
	}
	
	
	public List Propriedades() {
		List<String> PR = new ArrayList<String>(); 
		PR.add("HC");
		PR.add("GA");		
		PR.add("DI");
		PR.add("RE");
		return PR;
		
	}
	
	public List LerArquivo(String caminho) {
		BufferedReader conteudoCSV = null;
		String linha ="";
		String csvSeparadorCampo = ";";
		ArrayList<Dados> listaDados = new ArrayList<>();
		
		
		try {
			conteudoCSV = new BufferedReader(new FileReader(caminho));
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
				
//				System.out.println("[Data = " + dados[0]
//						+ " , RISCO = " + dados[1]
//					    + " , HCREDITO = " + dados[2]
//					    + " , DIVIDA = " + dados[3]
//					    + " , GARANTIA = " + dados[4]
//					    + " , RENDA = " + dados[5]
//					    + "]"
//						
//						);
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
		
		return listaDados;
		
	}
}
