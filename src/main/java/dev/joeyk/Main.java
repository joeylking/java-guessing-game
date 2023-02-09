package dev.joeyk;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        introduction();
        game();
    }

    public static void introduction(){
        System.out.println("This program allows you to play a guessing game.\n" +
                "I will think of a number between 1 and \n" +
                "100 and will allow you to guess until\n" +
                "you get it.  For each guess, I will tell you\n" +
                "whether the right answer is higher or lower\n" +
                "than your guess.");
    }

    public static void game(){
        Random r = new Random();
        int number = r.nextInt(100) + 1;
        Scanner input = new Scanner(System.in);
        System.out.println("I'm thinking of a number between 1 and 100...\n" +
                "Your guess? ");
        int guess = input.nextInt();
        int numberOfGuesses = 1;
        while (guess != number){
            if (number > guess){
                System.out.println("It's higher.");
            } else System.out.println("It's lower");
            System.out.println("Your guess? ");
            guess = input.nextInt();
            numberOfGuesses ++;
        }
        System.out.printf("You got it right in %s guesses", numberOfGuesses);
    }
}