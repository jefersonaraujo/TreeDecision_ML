package id3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class id3 {

	public static void main(String[] args) {
		//System.out.println("hello world ! ");
		//objetivo é ler um arquivo .csv e "montar" uma arvore de decicao 
		
		String csvArquivo ="C:\\Users\\ghost\\dados.csv";
		BufferedReader conteudoCSV = null;
		String linha ="";
		String csvSeparadorCampo = ";";
		
	
	
	
		induzir();		
		
		
		try {
			conteudoCSV = new BufferedReader(new FileReader(csvArquivo));
			while ((linha = conteudoCSV.readLine()) !=null ) {
				String [] dados = linha.split(csvSeparadorCampo);
				System.out.println("[Data = " + dados[0]
						+ " , RISCO = " + dados[1]
					    + " , HCREDITO = " + dados[2]
					    + " , DIVIDA = " + dados[3]
					    + " , GARANTIA = " + dados[4]
					    + " , RENDA = " + dados[5]
					    + "]"
						
						);
				
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
				}catch (IOException e) {
					System.out.println("IO Erro : \n "+ e.getMessage());
				}
			}
		}
	}

	private static void induzir() {
		System.out.println("Teste");
		
	}
	public class Dados {
	    private String risco,hc,divida,garantia;

		public String getRisco() {
			return risco;
		}

		public void setRisco(String risco) {
			this.risco = risco;
		}

		public String getHc() {
			return hc;
		}

		public void setHc(String hc) {
			this.hc = hc;
		}

		public String getDivida() {
			return divida;
		}

		public void setDivida(String divida) {
			this.divida = divida;
		}

		public String getGarantia() {
			return garantia;
		}

		public void setGarantia(String garantia) {
			this.garantia = garantia;
		}

	}
}
