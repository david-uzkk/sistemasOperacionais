import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import static java.lang.System.out;

public class SOAtiv4 {
    File file;
    public String USER_DIR = System.getProperty("user.dir");
	public String SEPARATOR = System.getProperty("file.separator");
    public String [] nomes = new String [6];

    public SOAtiv4() {
        file = new File("C:\\Users\\cg3010333\\Desktop\\atividade 4");
    }

    public void criarDiretorio() {
        File file1 = new File(USER_DIR + SEPARATOR + "diretorio" );
        file1.mkdirs();
        String NEW_USER_DIR = USER_DIR + "/diretorio"; 
        try {
            for (int i = 1; i < 4; i++) {
                File file2 = new File(NEW_USER_DIR + SEPARATOR + "diretorio " + String.valueOf(i));
                file2.mkdirs();
            }
        } catch (Exception e) {
            out.println(e.getMessage());
        }
    }

    public void escreverNomes(){
        try{
            try (Scanner sc = new Scanner(System.in)) {
                for (int i = 1; i < 6; i++) {
                    System.out.printf("Digite o nome %d: ", i);
                    nomes [i] = sc.next();
                }
            }
            FileWriter escrever = new FileWriter(USER_DIR + "\\nomes.txt");
            BufferedWriter bfw = new BufferedWriter(escrever);
            String tmp = "";
            for (int i = 1; i < 6; i++) {
                tmp += nomes [i] + "\r\n";
            }
            bfw.write(tmp);
            bfw.close();
            escrever.close();
        }catch(Exception e){
           e.getMessage();
        } 
    }   

    public void letrasMaiuscula(){
        try{
            FileWriter escrever = new FileWriter(USER_DIR + "\\nomes.txt");
            BufferedWriter bfw = new BufferedWriter(escrever);
            String tmp = "";
            for (int i = 1; i < 6; i++) {
                nomes[i] = nomes[i].toUpperCase();
                tmp += nomes [i] + "\r\n";
            }
            bfw.write(tmp);
            bfw.close();
            escrever.close();
        }catch(Exception e){
           e.getMessage();
        }
    }

    public static void main(String[] args) {
        SOAtiv4 a = new SOAtiv4();
        a.criarDiretorio();
        a.escreverNomes();
        a.letrasMaiuscula();
    }
}
