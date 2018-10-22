package id3;

import java.util.ArrayList;
import java.util.List;

public class Ramo {
	
	private int id;
	private int id_pai;	
	private String nome;
	private String rotulo;
	private List<String> classes = new ArrayList<String>();
	List <Ramo> ramo = new ArrayList<Ramo>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_pai() {
		return id_pai;
	}
	public void setId_pai(int id_pai) {
		this.id_pai = id_pai;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Ramo> getRamo() {
		return ramo;
	}
	public void setRamo(List<Ramo> ramo) {
		this.ramo = ramo;
	}
	public Ramo getRamos() {
		return ramos;
	}
	public void setRamos(Ramo ramos) {
		this.ramos = ramos;
	}
	private Ramo ramos;
	
	

	public String getRotulo() {
		return rotulo;
	}
	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}
	public List<String> getClasses() {
		return classes;
	}
	public void setClasses(List<String> classes) {
		this.classes = classes;
	}
	
}
