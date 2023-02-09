package dev.joeyk;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        introduction();
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(game());
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to play again? (y/n)");
        String continuePlaying = input.nextLine();
        while (continuePlaying.equals("y")){
            scores.add(game());
            System.out.println("Do you want to play again? (y/n)");
            continuePlaying = input.nextLine();
        }
        results(scores);
    }

    public static void introduction(){
        System.out.println("This program allows you to play a guessing game.\n" +
                "I will think of a number between 1 and \n" +
                "100 and will allow you to guess until\n" +
                "you get it.  For each guess, I will tell you\n" +
                "whether the right answer is higher or lower\n" +
                "than your guess.");
    }

    public static int game(){
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
        System.out.printf("You got it right in %s guesses\n", numberOfGuesses);
        return numberOfGuesses;
    }

    public static void results(List<Integer> scores){
        int guessSum = 0;
        for(Integer score : scores){
            guessSum += score;
        }
        System.out.println("Overall results:\n" +
                           "    total games   = " + scores.size() +"\n" +
                           "    total guesses = " + guessSum + "\n" +
                           "    guesses/game  = " + guessSum/scores.size() + "\n" +
                           "    best game     = " + Collections.min(scores));
    }
}