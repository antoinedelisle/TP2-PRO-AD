package com.github.antoinedelisle;

import java.util.Optional;
import java.util.Scanner;

public class TP2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char boucle;

        do {
            System.out.println("Quelle opération arithmétique voulez vous effectuer? ");
            String op = sc.nextLine();
            Optional<String[]> opArgs = lireEntree(op);

            if(opArgs.isPresent()){
                float result = traiterArguments(opArgs.get());
                System.out.println(String.format("\nLa réponse à l'opération est : %.3f\n\n", result));
            }

            System.out.println("Voulez-vous faire une autre opération (y/N)? ");
            boucle = sc.next().charAt(0);
        } while(Character.toLowerCase(boucle) == 'y');

        sc.close();
    }

    public static Optional<String[]> lireEntree(String input){
        String[] tmp = input.split(" ");
        if(tmp.length != 3){
            return Optional.empty();
        }

        try{
            int i1 = Integer.parseInt(tmp[0]), i2 = Integer.parseInt(tmp[2]);
        }catch (NumberFormatException ex){
            return Optional.empty();
        }

        return Optional.of(tmp);
    }

    public static float traiterArguments(String[] args){
        float toReturn;
        int i1 = Integer.parseInt(args[0]), i2 = Integer.parseInt(args[2]);
        switch (args[1]){
            case "+":
                toReturn = addition(i1, i2);
                break;
            case "-":
                toReturn = soustraction(i1, i2);
                break;
            case "x":
            case "*":
                toReturn = multiplication(i1, i2);
                break;
            case "/":
            case "÷":
                toReturn = division(i1, i2);
                break;
            default:
                toReturn = 0;
        }
        return toReturn;
    }

    public static float addition(int i1, int i2){
        return i1 + i2;
    }

    public static float soustraction(int i1, int i2){
        return i1 - i2;
    }

    public static float multiplication(int i1, int i2){
        return i1 * i2;
    }

    public static float division(int i1, int i2){
        return ((float)i1) / i2;
    }

}
