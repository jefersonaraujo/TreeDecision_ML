package id3;

import java.util.ArrayList;
import java.util.List;

public class Ramo {
	
	private String ramo;
	private String rotulo;
	private Ramo ramos;
	private List<String> classes = new ArrayList<String>();
	
	public Ramo getRamos(String ramo,String rotulo) {
		return ramos;
	}
	public void setRamos(Ramo ramos) {
		this.ramos = ramos;
	}
	
	
	public String getRamo() {
		return ramo;
	}
	public void setRamo(String ramo) {
		this.ramo = ramo;
	}
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
