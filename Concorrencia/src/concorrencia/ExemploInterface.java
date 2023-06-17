package concorrencia;

import static java.lang.System.out;


public class ExemploInterface implements Runnable{
    public String nome = "";
    public int tempo = 0;
    
    public ExemploInterface(String nome) {
        this.nome = nome;
        this.tempo = (int)(Math.random()*6);
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            out.println(nome);
            try{
                Thread.sleep(tempo*1000);
            }catch(Exception e){                
            }
        }
    }
    
    public static void main(String args[]){
        ExemploInterface ex= new ExemploInterface("Bolinho de arroz");
        ex.run(); //não aceita start (PARALELO)
        ExemploInterface ex2= new ExemploInterface("Pudim Morrison");
        ex2.run();
    }

}
