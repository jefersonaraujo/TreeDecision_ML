package id3;

import java.util.ArrayList;
import java.util.List;

public class Tree {
	
	private String raiz;
	private String nome;
	private ArrayList<Tree> ramos = new ArrayList<>();

	
	public String getRaiz() {
		return raiz;
	}
	public void setRaiz(String raiz) {
		this.raiz = raiz;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Tree> getRamos() {
		return ramos;
	}
	public void setRamos(ArrayList<Tree> tt) {
		this.ramos = tt;
	}


	
	

}
