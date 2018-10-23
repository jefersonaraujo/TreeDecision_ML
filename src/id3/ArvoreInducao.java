package id3;

import java.util.List;

public class ArvoreInducao {

    String[] arvore_inducao;
    int id_no= 1;
    int id_pai= 0;

    public List induzir_arvore() {
    	return null;
    }

	public static void main(String[] args) {
		
		Conexao bancoDeDados = new Conexao();
		bancoDeDados.conectar();
		if(bancoDeDados.estaConectado()) {
			System.out.println("Here");
			bancoDeDados.listarDados();
			
		}else {
			System.out.println("eroor");
		}
	}

}
