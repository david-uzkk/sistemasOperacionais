package arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import static java.lang.System.out;

public class Arquivos {
     File file;
     
     public Arquivos(){
         file = new File("C:\\Users\\cg090438\\Documents\\Arquivos");
     }
    
    //lidando com informações do FILE
    public void info(){
        if (file.exists() == false) {
            file.mkdir();
        }
        if(file.isDirectory()){
            out.println(file.getName());
        }
        out.println("File =" + file.getAbsoluteFile());
        out.println("Tamanho " +file.length());
        out.println("Espaço livre " + file.getFreeSpace());        
    }
    
    public void criandoArquivos(){
        try{
            for (int i=0; i<10;i++){
                File arquivo= new File(file.getAbsoluteFile()+ "\\nota"+ String.valueOf(i)+ ".txt");
                arquivo.createNewFile();
                arquivo.setWritable(true);
                arquivo.setReadable(true);
                //File tmp= new File(file.getAbsoluteFile()+ "\\texto"+ String.valueOf(i)+ ".doc");
                //arquivo.renameTo(tmp);
            } 
        }catch(Exception e){
            out.println(e.getMessage());
        }       
    }
    
    public void lerArquivo(){
        try{
            FileReader leitor = new FileReader(file + "\\texto0.txt");
            BufferedReader bfr = new BufferedReader(leitor);
            String tmp="";
            while((tmp= bfr.readLine())!= null){
                out.println(tmp);
            }            
        }catch(Exception e){
           e.getMessage();
        }        
    }
    
    public void escreverArquivo(){
        try{
            FileWriter escritor = new FileWriter(file + "\\texto11.txt");
            BufferedWriter bfw = new BufferedWriter(escritor);
            String tmp="Teste" +"\r\n" + "Teste 2";
            bfw.write(tmp);
            //fechando
            bfw.close();
            escritor.close();
        }catch(Exception e){
           e.getMessage();
        } 
        
    }   
    

    
    public void listandoArquivos(){
        File file = new File("C:\\Users\\cg090438\\Documents\\Arquivos");
        if(file.isDirectory()){
            String[] arquivos=file.list();
            for(int i=0; i< arquivos.length;i++){
                out.println(arquivos[i]);                
            }
        }        
    }
    
    

    public static void main(String[] args) {
        Arquivos a= new Arquivos();
        //a.info();
        //a.criandoArquivos();
        //a.listandoArquivos();
        //a.lerArquivo();
        a.escreverArquivo();
        
  

    }

}
