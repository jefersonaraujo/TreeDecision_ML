package id3;

import java.util.ArrayList;
import java.util.List;

public class Tree {
	
	private int id_raiz;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	private String no[][];
	public String[][] getNo() {
		return no;
	}
	public void setNo(String[][] no) {
		this.no = no;
	}

	private String rotulo;
	private String classe;
	private String nome;
	List <Tree> ramos = new ArrayList<Tree>();

	

	public int getId_raiz() {
		return id_raiz;
	}
	public void setId_raiz(int id_raiz) {
		this.id_raiz = id_raiz;
	}
	public String getRotulo() {
		return rotulo;
	}
	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}



	
	

}
