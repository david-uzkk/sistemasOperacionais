package primos;
public class Cronometro {
    public long inicio;
    public long fim;
    public long tempo;
    
    public void iniciar(){
        inicio= System.currentTimeMillis();
    }
    
    public void parar(){
        fim= System.currentTimeMillis();
        tempo= fim - inicio;
    }
    
    public String exibir(){
        return String.valueOf(tempo);
    }    
}