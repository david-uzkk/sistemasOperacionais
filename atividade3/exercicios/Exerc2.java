import static java.lang.System.out;

public class Exerc2 implements Runnable {

    private String nome;
    private int valor = 100; // atribuir o valor de 100 inicial
    private int rodadas = 10;// fazer dez rodadas

    public Exerc2(String nome) { // receber o nome do jogador
        this.nome = nome;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < rodadas; i++) {
                int banca = (int) (Math.random() * 21);// gerar um numero menor que 21
                if (banca % 2 == 0) {
                    valor += banca; // se for par = soma.
                } else {
                    valor -= banca; // Se for impar = diminui
                }
                Thread.sleep(1000); // a cada rodada esperar um segundo
                out.println("A jogadora " + nome + " tem " + valor + " reais");

            }
        } catch (Exception e) {

        }
        // imprime valor final
    }

    public static void main(String args[]) {
        // jogador 1
        Exerc2 ex1 = new Exerc2("Ana");
        Thread th1 = new Thread(ex1);
        th1.start();

        // jogador 2
        Exerc2 ex2 = new Exerc2("Bianca");
        Thread th2 = new Thread(ex2);
        th2.start();

        // jogador 3
        Exerc2 ex3 = new Exerc2("Carla");
        Thread th3 = new Thread(ex3);
        th3.start();

        // jogador 4
        Exerc2 ex4 = new Exerc2("Denise");
        Thread th4 = new Thread(ex4);
        th4.start();

        // jogador 5
        Exerc2 ex5 = new Exerc2("Elaine");
        Thread th5 = new Thread(ex5);
        th5.start();
        out.println("\n");
    }
}
