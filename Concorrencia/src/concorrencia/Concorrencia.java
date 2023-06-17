
package concorrencia;

import static java.lang.System.out;


public class Concorrencia {

    public static void main(String[] args) {
        long numero= (long)(Math.random()* Long.MAX_VALUE);
        if(numero %2==0){
            numero++;
        }
        out.println(numero);
    }    
    

}
