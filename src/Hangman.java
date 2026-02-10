import java.util.Random;
import java.util.Scanner;

class HangmanGame{
    Random rand ;
    private String[] words = {"java", "computer", "program", "hangman", "keyboard"};
    private String word;
    private char[] guessedWord;
    private int lives = 6;

    public  HangmanGame(){
        rand= new Random();
        word = words[rand.nextInt(words.length)];
        guessedWord = new char[word.length()];

        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }
    }



    public void play() {
        Scanner sc = new Scanner(System.in);

        while (lives > 0 && !isWordGuessed()) {
            System.out.println("\nWord: " + String.valueOf(guessedWord));
            System.out.println("Lives left: " + lives);
            System.out.print("Guess a letter: ");

            char guess = sc.next().charAt(0);
            boolean correct = false;

            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    guessedWord[i] = guess;
                    correct = true;
                }
            }

            if (!correct) {
                lives--;
                System.out.println("Wrong guess!");
            }
        }

        if (isWordGuessed()) {
            System.out.println("\n🎉 You won! Word was: " + word);
        } else {
            System.out.println("\n💀 You lost! Word was: " + word);
        }
    }
    private boolean isWordGuessed() {
        return String.valueOf(guessedWord).equals(word);
    }
    }
public class Hangman {
    public static void main(String[] args) {
        HangmanGame game = new HangmanGame();
        game.play();
    }
}
