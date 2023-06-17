package concorrencia;

import static java.lang.System.out;

public class ExemploMisto implements Runnable {

    public String nome = "";
    public int tempo = 0;

    public ExemploMisto(String nome) {
        this.nome = nome;
        this.tempo = (int) (Math.random() * 6);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            out.println(nome);
            try {
                Thread.sleep(tempo * 1000);
            } catch (Exception e) {

            }
        }
    }

    public static void main(String args[]) {
        for (int i = 0; i < 20; i++) {
            ExemploMisto ex1 = new ExemploMisto("Palestrinha");
            Thread thread1 = new Thread(ex1);
            thread1.start();
        }
    }

}
