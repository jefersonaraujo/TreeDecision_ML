package id3;

import java.util.ArrayList;
import java.util.List;

public class Ramo {
	
	
	private String nome;
	private String rotulo;
	private List<String> classes = new ArrayList<String>();
	List <Ramo> ramo = new ArrayList<Ramo>();
	
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
