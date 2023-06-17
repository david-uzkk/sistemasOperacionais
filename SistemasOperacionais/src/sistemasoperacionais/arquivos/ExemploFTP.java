package sistemasoperacionais.arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.System.out;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class ExemploFTP {

    FTPClient ftp = new FTPClient();
    public String usuario = "David";
    public String senha = "aluno";
    public String servidor = "127.0.0.1";
    public int porta = 21;

    public ExemploFTP() {
        ftp = new FTPClient();
        usuario = "aluno";
        senha = "aluno";
        servidor = "127.0.0.1";
        porta = 21;
    }

    public void conectar() {
        try {
            ftp.connect(servidor, porta);
            ftp.login(usuario, senha);
            ftp.enterLocalPassiveMode();
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            out.println("Conetado ao servidor");
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
                System.out.println("Enviando arquivo...");
                boolean done = ftp.storeFile(arquivoRemoto, inputStream);
                inputStream.close();
                if (done) {
                    System.out.println("Arquivo enviado");
                }
            }else {
                out.println("Conta está desconectada");
            }
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    //-----------------------------------------------------------------------------

    public static void main(String[] args) {
        ExemploFTP f = new ExemploFTP();
        f.conectar();
        f.enviarArquivo("c:/tmp/paises.txt", "/paises.txt");
        f.desconectar();

    }

}
