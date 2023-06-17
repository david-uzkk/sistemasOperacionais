import static java.lang.System.out;

import java.util.Random;

public class Exerc3 implements Runnable {

    @Override
    public void run() {
        boolean cond = true;
        long count;
        long padrao;
        long primo1;
        long primo2;

        
        Random gerador = new Random();
        count = gerador.nextInt(99);
        padrao = count;
        while (cond) {
            if (isPrimo(count)) {
                primo1 = count;
                out.printf("Teste de Primo: %d", primo1);
                cond = false;
            }
            count++;
        }

        primo1 = count;
        cond = true;
        count = padrao;

        while (cond) {
            primo2 = count;
            if (isPrimoModificada(count)) {
                out.printf("\nTeste de Primo modificado: %d", primo2);
                cond = false;
            }
            count++;
        }

        primo2 = count;
        if (primo1 == primo2){
            out.printf("\nO teste modificado esta correto!");
        }
        else {
            out.printf("\nO teste modificado esta errado!");
        }
    }

    // -------------------- DETERMINA SE É PRIMO --------------------------------
    public boolean isPrimo(long n) {
        if (n % 2 == 0 || n % 3 == 0 || n % 5 == 0 || n % 7 == 0) {
            return n == 2 || n == 3 || n == 5 || n == 7;
        }
        long raiz = ((long) Math.sqrt(n)) + 1;
        long i = 11;
        while (i < raiz) {
            if (n % i == 0) {
                return false;
            }
            i += 2;
        }
        return true;
    }

    public boolean isPrimoModificada(long n) {
        if (n % 2 == 0) {
            return n == 2;
        }
        long raiz = ((long) Math.sqrt(n)) + 1;
        long i = 3;
        while (i < raiz) {
            if (n % i == 0) {
                return false;
            }
            i += 2;
        }
        return true;
    }

    public static void main(String args[]) {
        Exerc3 ex = new Exerc3();
        ex.run();
    }

}
