package PartOneCollection;

import java.util.Scanner;

public class Part1Calculator {
    public static void main(String[] args) {
        String inputN;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter N: ");
        inputN = scanner.nextLine();
        System.out.println("Your enter is: " + inputN);
        try {
            int numberN = Integer.parseInt(inputN);
            int result = 0;
            for(int i = 0; i <= numberN ;i++){
                result += i;
            }
            System.out.println("Result is: " + result);
        } catch (Exception e){
            System.out.println("N is not number");
        }
    }
}
