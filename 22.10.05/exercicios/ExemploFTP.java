
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ExemploFTP {
    private FTPClientExample cliente;
    private String usuario;
    private String senha;
    private String host;
    private int porta;

    public ExemploFTP() {
        cliente = new FTPClient();
        usuario = "aluno";
        senha = "aluno";
        porta = 21;
        host = "10.10.202.50";
    }

    public void conectar() {
        try {
            cliente.connect(host, porta);
            cliente.login(usuario, senha);
            cliente.enterLocalPassiveMode();
            cliente.setFileType(FTP.BYNARY_FILE_TYPE);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void desconectar() {
        try {
            if (cliente.isConnected()) {
                cliente.logout();
                cliente.disconect();
            }
        } catch (Exception e) {

        }
    }

    public boolean enviar(String local, String remoto) {
        try {
            if (cliente.isConnected()) {
                File arquivoLocal = new File(local);
                InputStream inputStream = new FileInputStream(arquivoLocal);
                String arquivoRemoto = remoto;
                System.out.println("Enviando arquivo...");
                boolean done = cliente.storeFile(arquivoRemoto, inputStream);
                inputStream.close();
                if (done) {
                    System.out.println("Arquivo enviado");
                }
            } else {
                out.println("Conta está desconectada");
            }
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String args[]){
        ExemploFTP f = new ExemploFTP();
        //conectar ao host
        f.conectar();
        //enviar o arquivo
        f.enviar("c:/tmp/david.txt", "/david.txt");
        //desconectar do host
        f.desconectar();
    }

}
