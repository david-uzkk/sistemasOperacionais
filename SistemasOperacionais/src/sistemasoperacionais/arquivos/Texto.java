
package sistemasoperacionais.arquivos;

import javax.swing.JOptionPane;


public class Texto {
    
    public static String  leia(String mensagem){
        String tmp= JOptionPane.showInputDialog(mensagem);
        return tmp; 
    }
    
    public static void escreva(String mensagem, String aviso){
        JOptionPane.showMessageDialog(null, mensagem, aviso, JOptionPane.PLAIN_MESSAGE);
    }
   
}
