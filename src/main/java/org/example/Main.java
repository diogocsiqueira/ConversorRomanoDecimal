package org.example;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int option = 0;
        Scanner sc = new Scanner(System.in);
        RomanConverterInterface romanConverter = new RomanConverter();

        System.out.println("escolha:");
        System.out.println("1: converter valor romano para decimal");
        System.out.println("2: converter valor decimal para romano");

        option = sc.nextInt();

        switch (option) {
            case 1:
                System.out.println("Digite um valor em codigo romano: ");
                sc.nextLine();
                String romanCode = sc.nextLine();
                int decimalNumber = romanConverter.romanToDecimal(romanCode);
                System.out.println(romanCode + " em numero decimal fica: " + decimalNumber);
                break;

            case 2:
                System.out.println("Digite um valor em numero decimal (entre 1-3999): ");
                int number = sc.nextInt();
                String romanNumber = romanConverter.decimalToRoman(number);
                System.out.println(number + " em codigo romano fica: " + romanNumber);
                break;
            default:
                System.out.println("Escolha entre uma das alternativas dadas");
        }

    }
}