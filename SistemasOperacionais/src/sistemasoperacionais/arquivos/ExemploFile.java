
package sistemasoperacionais.arquivos;

import java.io.File;


public class ExemploFile {
    File raiz= new File( "d:/tmp/teste/");
    
    
    public ExemploFile(){
        if(raiz.exists()== false){
            raiz.mkdir();
        }
    }
    
    public void criarDiretorio(String nome){        
        File diretorio= new File(raiz.getAbsolutePath()+ "/" + nome);
        if(diretorio.exists()== false){
            diretorio.mkdir();
        }
    }   
    
    
    public static void main(String args[]){
        ExemploFile ex = new ExemploFile();
        String nome= Texto.leia("Diz o nome do diretorio, tio");        
        ex.criarDiretorio(nome);        
    }
    
}
