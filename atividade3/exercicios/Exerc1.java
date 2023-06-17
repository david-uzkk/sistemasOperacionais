import static java.lang.System.out;

public class Exerc1 implements Runnable {

    @Override
    public void run() {
        boolean cond = true;
        long ant;
        long novo = 9999;
        long count = 1;
        while (cond) {
            ant = novo;
            if (isPrimo(count)) {
                novo = count;
                if (novo - 2 == ant) {
                    out.printf("O %d e o %d são números primos gêmeos!", ant, novo);
                    cond = false;
                }
            }
            count++;
        }
    }

    public boolean isPrimo(long n) {
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
        Exerc1 ex = new Exerc1();
        ex.run();
    }
}
