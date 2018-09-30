package id3;

import java.io.BufferedReader;
import java.io.FileReader;

public class id3 {

	public static void main(String[] args) {
		//System.out.println("hello world ! ");
		//objetivo é ler um arquivo .csv e "montar" uma arvore de decicao 
		
		String csvArquivo ="C:\\Users\\ghost\\dados.csv";
		BufferedReader conteudoCSV = null;
		String linha ="";
		String csvSeparadorCampo = ";";
		
		try {
			conteudoCSV = new BufferedReader(new FileReader(csvArquivo));
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
