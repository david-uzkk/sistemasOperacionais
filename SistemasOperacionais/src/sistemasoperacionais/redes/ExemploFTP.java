
package sistemasoperacionais.redes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.System.out;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;


public class ExemploFTP {
    private FTPClient cliente;
    private String usuario;
    private String senha;
    private String host;
    private int porta;
    
    public ExemploFTP(){
        //configuração inicial
        cliente= new FTPClient();
        usuario= "aluno";
        senha= "aluno";
        porta = 21;
        host= "10.10.202.50";
    }
    
    public void conectar(){
        try{
            cliente.connect(host, porta);
            cliente.login(usuario, senha);
            cliente.enterLocalPassiveMode();
            cliente.setFileType(FTP.BINARY_FILE_TYPE);
            out.println("Conetado ao servidor");
        }catch(Exception e){
            e.getMessage();
        }
    }
    
    public void desconectar(){
        try {
            if (cliente.isConnected()) {
                cliente.logout();
                cliente.disconnect();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public boolean enviar(String local, String remoto){
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
    
    public static void main(String args[]){
        ExemploFTP f = new ExemploFTP();//conectar ao host        
        f.conectar();//enviar o arquivo        
        f.enviar("c:/tmp/paises.txt", "/paises.txt");        
        f.desconectar();     //desconectar do host     
    }
    
    
    
}
