package id3;

public class No {
	 String palavra;    //dado  
     No filhoEsquerda; //cria filho  a esquerda  
     No filhoDireita;  // cria filho a direita  

    public No(String palavra){  
        this.palavra = palavra;  
    }  

     public void mostraNo(){     
       {     

             System.out.print(palavra);     
             System.out.print(", ");     

        }     
     }     
}
