package sistemasoperacionais.arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import static java.lang.System.out;

public class ExemploArquivos {

    private String raiz = "c:/tmp/";//ajustar o diretorio raiz
    private File diretorio;
    private String nomeArquivo;

    public ExemploArquivos() {
        diretorio = new File(raiz);
        //garantir que o diretorio exista
        if (diretorio.exists() == false) {
            diretorio.mkdir();
        }
    }

    public void escreverArquivo() {
        try {
            nomeArquivo = Texto.leia("Digite o nome do arquivo");
            FileWriter fw = new FileWriter(raiz + nomeArquivo); //criar o file
            // existe a opção TRUE ou FALSE para sobrescrever o arquivo existente
            BufferedWriter escrita = new BufferedWriter(fw); //criar o buffer
            String linha;
            do {
                linha = Texto.leia("Digite o país: (CANCEL para terminar)");
                if (linha != null && linha.length() > 0) {
                    escrita.write(linha + "\n"); //escrever no arquivo
                    out.println("Gravando..." + linha);
                }
            } while (linha != null);
            escrita.close(); //fechar o arquivo    
            fw.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void lerArquivo() {
        try {
            //criar file e buffer
            FileReader fr = new FileReader(raiz + nomeArquivo);
            BufferedReader leitura= new BufferedReader(fr);     
            String linha="";
            do {
                linha= leitura.readLine();  //ler linha a linha
                out.println("Lendo..." + linha); //imprimir na tela
            }while(linha!=null);
            leitura.close();
            fr.close();    //fechar o arquivo            
        } catch (Exception e) {
            e.getMessage();
        }

    }

    public static void main(String args[]) {
        ExemploArquivos e = new ExemploArquivos();
        e.escreverArquivo();
        e.lerArquivo();

        //criar um arquivo para escrita - dar o nome
        //escrever no arquivo
        //abrir o arquivo para leitura
        //exibir o conteudo na tela
        //String tmp= Texto.leia("Digite alguma, tio");
        //Texto.escreva(tmp, "O tio digitou: ");
    }

}
