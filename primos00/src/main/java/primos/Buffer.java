package primos;

public class Buffer {
    char v[]; //buffer
    int index;
    int size;
    char empty; //null
    
    public Buffer() {
        size= 15;
        v= new char[size];
        empty= '\0';
    }
    
    public void limpar(){ //flush
        for (int i=0; i< v.length; i++){
            v[i]=empty;
        }
        index=0;
    }
    
    public void gravar(String texto){
        System.out.println(texto);
        for (int i=0; i< texto.length(); i++){            
            if(index==(size)){
                index=0;
            }            
            v[index]= texto.charAt(i);   
            index++;
        }
    }
    
    public void exibirBuffer(){
        System.out.print(v);
        System.out.print('\n');
    }
    
    public static void main(String args[]){
        Buffer out = new Buffer();
        out.gravar("ABABAB");     
        out.gravar("CDCDCD");
        out.gravar("EFEFEF");
        out.exibirBuffer();
    }
}
