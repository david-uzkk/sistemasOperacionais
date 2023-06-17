package primos;

import java.util.Scanner;

public class primos {
    public static void main(String[] args) {
        int n;
        boolean primo = true;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Digite um numero: ");
            n = sc.nextInt();
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                primo = false;
            }
        }

        if (primo == false) {
            System.out.printf("\nO numero %d nao é primo!\n", n);
        }
        else {
            System.out.printf("\nO numero %d é primo!\n", n);
        }
    }
}
