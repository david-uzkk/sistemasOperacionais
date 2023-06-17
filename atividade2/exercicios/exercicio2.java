package atividade2.exercicios;

import static java.lang.System.out;

public class exercicio2 implements Runnable {

    @Override
    public void run(){
        boolean flag = false;
        while (flag == false) {
            long n = (long) (Math.random() * Long.MAX_VALUE);
            if (n % 2 == 0) {
                n++;
            }
            if (isPrimo(n)) {
                out.println(n + " é primo.");
                flag = true;
            }
        }
    }

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

    public static void main(String args[]) {
        for (int i = 0; i < 20; i++) {
            exercicio2 ex = new exercicio2();
            Thread th = new Thread(ex);
            th.start();
        }
    }
}
