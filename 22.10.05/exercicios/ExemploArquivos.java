package exercicios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class ExemploArquivos {
    private String raiz = "C:/tmp/";
    private File diretorio;



    public ExemploArquivos(){
        diretorio = new File(raiz);
        if(diretorio.exists()==false){
            diretorio.mkdir();
        }
    }

    public void escreverArquivo(){
        try{
            String nomeArquivo = Texto.leia("Digite o nome do arquivo");
            FileWriter fw = new FileWriter(raiz + nomeArquivo + ".txt");
            try (BufferedWriter escrita = new BufferedWriter(fw)) {
                String linha;
                do{
                    linha =  Texto.leia("Digite o pais: (CANCEL para terminar)");
                    if(linha != null && linha.length()>0){
                        escrita.write(linha + "\n");
                        System.out.println("Gravando... " + linha);
                    }
                }while(linha != null);
                escrita.close();
                fw.close();
            }
        }catch(Exception e){
            e.getMessage();
        }
    }

    public void lerArquivo() {
        try {
            String nomeArquivo = Texto.leia("Digite o nome do arquivo: ");
            FileWriter fw = new FileWriter(raiz + nomeArquivo, true);
            BufferedWriter leitura = new BufferedWriter(fw);
            String linha = "";
            do {
                linha = Texto.leia("");
                linha = leitura.readLine();
                System.out.println("Lendo..." + linha);
            }while(linha != null);
            leitura.close();
            fw.close();
        }catch(Exception e ){

        }
    }

    public void main(){

    }
    public static void main(String[] args) {
        ExemploArquivos e =  new ExemploArquivos();
        e.escreverArquivo();
    }
}
