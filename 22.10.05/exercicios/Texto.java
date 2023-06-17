package exercicios;
import javax.swing.JOptionPane;

public class Texto {

    public static String leia(String mensagem){
        String tmp = JOptionPane.showInputDialog(mensagem);
        return tmp;
    }

    public static void escreva(String mensagem, String aviso){
        JOptionPane.showInputDialog(null, mensagem, aviso, JOptionPane.PLAIN_MESSAGE);
    }
}
