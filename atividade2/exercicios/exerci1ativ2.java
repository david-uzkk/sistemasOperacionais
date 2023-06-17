package atividade2.exercicios;

public class exerci1ativ2 extends Thread{
    private long inicio;
    private long fim;
    private long passo = 1_000_000;

    public exerci1ativ2(int n){
        inicio = (n*passo) + 1;
        fim = inicio + (passo-1);
        System.out.println(inicio + " ate " + fim);
    }

    @Override
    public void run(){
        int i = 0;
        int contador = 0;

        while(i < passo) {
            if (isPrimo(inicio + i)) {
                contador++;
            }
            i++;
        }

        System.out.println("\nDe " + inicio + " ate " + fim + " existem " + contador + " primos ");

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

    public static void main(String args[]){
        for (int i=0; i<20; i++){
            exerci1ativ2 ex= new exerci1ativ2(i);
            ex.run();
        }
    }
}