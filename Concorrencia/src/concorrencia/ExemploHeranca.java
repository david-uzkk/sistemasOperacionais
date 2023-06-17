package concorrencia;

import static java.lang.System.out;

public class ExemploHeranca extends Thread {

    public String nome = "";
    public int tempo = 0;

    public ExemploHeranca(String nome) {
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
        ExemploHeranca ex= new ExemploHeranca("Bolinho de arroz");
        ex.start();//caso use start = PARALELO. Se usar run = SÉRIE
        ExemploHeranca ex2= new ExemploHeranca("Pudim Morrison");
        ex2.start();
    }

}
