package sistemasoperacionais.arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import static java.lang.System.out;

public class ExemploArquivo {

    private BufferedReader leitura;
    private BufferedWriter escrita;
    private String caminho = "d:/tmp/teste/";
    private String nomeArquivo;
    File raiz = new File(caminho);

    public ExemploArquivo() {
        try {
            if (raiz.exists() == false) {
                raiz.mkdir();
            }
            nomeArquivo = Texto.leia("Digite nome do Arquivo");                     
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void lerArquivo() {
        try {     
            leitura = new BufferedReader(new FileReader(caminho + nomeArquivo));  
            String linha;
            do {
                linha = leitura.readLine();
                if (linha != null) {
                    out.println("Mostrando... " + linha);
                }
            } while (linha != null);
            leitura.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void escreverArquivo() {
        try {
            escrita = new BufferedWriter(new FileWriter(caminho + nomeArquivo));
            String linha;
            do {
                linha = Texto.leia("Digite um país:");
                if (linha != null) {
                    escrita.write(linha + "\r");
                    out.println("Gravando... " + linha);
                }
            } while (linha != null);
            escrita.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static void main(String args[]) {
        ExemploArquivo ex = new ExemploArquivo();
        ex.escreverArquivo();
        out.println("------ CONTEUDO DO ARQUIVO -----------");
        ex.lerArquivo();
    }

}
