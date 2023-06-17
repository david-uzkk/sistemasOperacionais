package atividade5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import static java.lang.System.out;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;


public class ativd5 extends Thread {
    public long inicio = 1000000000000000l; // guardar o valor inicial da contagem
    public long[] todosPrimos = new long[30];
    public static String USER_DIR = System.getProperty("user.dir") + "\\src\\atividade5";
	public static String SEPARATOR = System.getProperty("file.separator");
    File file;
    FTPClient ftp = new FTPClient();
    public String usuario = "David";
    public String senha = "aluno";
    public String servidor = "127.0.0.1";
    public int porta = 21;
    


    public void primos() {
        int i = 0;
        int cont = 0;
        while (cont < 30) {
            if (isPrimoModificada(inicio + i)) { // testa os valores
                todosPrimos[cont] = inicio + i; // armazena os primos
                i++;
                cont++;
            }
            i++;
        }
    }

    public boolean isPrimoModificada(long n) {
        if (n % 2 == 0) {
            return n == 2;
        }
        long raiz = ((long) Math.sqrt(n)) + 1;
        long i = 3;
        while (i < raiz) {
            if (n % i == 0) {
                return false;
            }
            i += 2;
        }
        return true;
    }

    public void criarArquivo() {
        try {
            File file = new File(USER_DIR + SEPARATOR + "David.txt");
            file.createNewFile();
        } catch (Exception e) {
            out.println(e.getMessage());
        }
    }

    public void escreverNumeros(){
        try{
            FileWriter escrever = new FileWriter(USER_DIR + "\\David.txt");
            BufferedWriter bfw = new BufferedWriter(escrever);
            String tmp = "";
            for (int i = 0; i < 30; i++) {
                tmp += todosPrimos [i] + "\r\n";
            }
            bfw.write(tmp);
            bfw.close();
            escrever.close();
        }catch(Exception e){
           e.getMessage();
        } 
    } 

    public void lerArquivo(){
        try{
            FileReader leitor = new FileReader(USER_DIR + "\\David.txt");
            try (BufferedReader bfr = new BufferedReader(leitor)) {
                String tmp="";
                long maior = 0;
                long menor = Long.parseLong(bfr.readLine());
                while((tmp= bfr.readLine())!= null){
                    if(Long.parseLong(tmp) < menor){
                        menor = Long.parseLong(tmp);
                    }
                    if(Long.parseLong(tmp) > maior){
                        maior = Long.parseLong(tmp);
                    }
                }
                out.println("\nMenor: " + menor + "\nMaior: " + maior );
            }            
        }catch(Exception e){
           e.getMessage();
        }        
    }

    public void conectar() {
        try {
            ftp.connect(servidor, porta);
            ftp.login(usuario, senha);
            ftp.enterLocalPassiveMode();
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            out.println("Conectou no servidor!");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void desconectar() {
        try {
            if (ftp.isConnected()) {
                ftp.logout();
                ftp.disconnect();
            }
        } catch (Exception e) {

        }
    }

    public boolean enviarArquivo(String local, String remoto) {
        try {
            if (ftp.isConnected()) {
                File arquivoLocal = new File(local);
                InputStream inputStream = new FileInputStream(arquivoLocal);
                String arquivoRemoto = remoto;
                System.out.println("Enviando o arquivo...");
                boolean done = ftp.storeFile(arquivoRemoto, inputStream);
                inputStream.close();
                if (done) {
                    System.out.println("Arquivo enviado!");
                }
            }else {
                out.println("Conta desconectada!");
            }
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String args[]) {
        ativd5 ex = new ativd5();
        ex.primos();
        ex.criarArquivo();
        ex.escreverNumeros();
        ex.lerArquivo();
        ex.conectar();
        ex.enviarArquivo(USER_DIR + SEPARATOR + "David.txt", "/David.txt");
        ex.desconectar();
    }

}