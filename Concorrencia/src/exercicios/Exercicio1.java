package Concorrencia.src.exercicios;

import static java.lang.System.out;


public class Exercicio1 extends Thread{
    private long inicio; //guardar o valor inicial da contagem
    private long fim;
    private long passo= 1_000_000;
    
    public Exercicio1(int n){
        //tem de receber o valor inicial 
        inicio= (n*passo) + 1;
        fim= inicio + (passo-1);  
        
    }
    
    
    @Override
    public void run(){
        int i=0;
        int contador=0;
        //faz um laço para testar 1 milhão
        while(i<passo){
            if (isPrimo(inicio+i)){ //testa os valores
                contador++; //armazena total de primos
            }            
            i++;
        }       
        //imprime na tela
        out.println("De "+ inicio + " até " + fim + " existem " +contador + " primos");

    }
    
    //-------------------- DETERMINA SE É PRIMO --------------------------------
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
    
    public static void main(String args[]){
        for (int i=0;i<20; i++){
            Exercicio1 ex= new Exercicio1(i);
            ex.run();
        }
    }  
    
}
