package primos;

public class Verificador {
    public long MAX= 100000;
    public long contador= 0;
    
    public Verificador() {
        init();
    }
    
    public boolean isPrimo(long n) {
        long i=2;
        if (n%2==00){
            return n==2;
        }
        while(i<n){
            if(n % i==0){
                return false;
            }
            i++;
        }
        return true;
    }
    
    public void init() {
        for(int i=0; i<MAX; i++)
            if(this.isPrimo(i)){
                contador++;
            }
    }
    
    public static void main(String args[]) {
        Cronometro cron= new Cronometro();
        Verificador v = new Verificador();
        System.out.println(v.contador);
        cron.parar();
        System.out.println("Primos = "+ v.contador);
        System.out.println("Tempo = "+ cron.exibir());
    }
}
