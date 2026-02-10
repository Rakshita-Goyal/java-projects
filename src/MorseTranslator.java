
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class MorseTranslators {

    private Map<Character, String> textToMorse = new HashMap<>();
    private Map<String, Character> morseToText = new HashMap<>();

    public MorseTranslators() {
        add('A', ".-");
        add('B', "-...");
        add('C', "-.-.");
        add('D', "-..");
        add('E', ".");
        add('F', "..-.");
        add('G', "--.");
        add('H', "....");
        add('I', "..");
        add('J', ".---");
        add('K', "-.-");
        add('L', ".-..");
        add('M', "--");
        add('N', "-.");
        add('O', "---");
        add('P', ".--.");
        add('Q', "--.-");
        add('R', ".-.");
        add('S', "...");
        add('T', "-");
        add('U', "..-");
        add('V', "...-");
        add('W', ".--");
        add('X', "-..-");
        add('Y', "-.--");
        add('Z', "--..");

        add('0', "-----");
        add('1', ".----");
        add('2', "..---");
        add('3', "...--");
        add('4', "....-");
        add('5', ".....");
        add('6', "-....");
        add('7', "--...");
        add('8', "---..");
        add('9', "----.");
    }

    private void add(char c, String morse) {
        textToMorse.put(c, morse);
        morseToText.put(morse, c);
    }


    public String toMorse(String text) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toUpperCase().toCharArray()) {

            if (c == ' ') {
                result.append(" / ");
            } else if (textToMorse.containsKey(c)) {
                result.append(textToMorse.get(c)).append(" ");
            }

        }
        return result.toString();
    }

    public String toText(String morse) {
        StringBuilder result = new StringBuilder();
        String[] words = morse.split(" / ");

        for (String word : words) {
            String[] letters = word.split(" ");
            for (String l : letters) {
                if (morseToText.containsKey(l)) {
                    result.append(morseToText.get(l));
                }
            }
            result.append(" ");
        }
        return result.toString().trim();
    }


}
public class MorseTranslator {
    public static void main(String args[]){

        MorseTranslators translator = new MorseTranslators();
        Scanner sc = new Scanner(System.in);

        System.out.println("MORSE CODE TRANSLATOR");
        System.out.println("1. Text to Morse");
        System.out.println("2. Morse to Text");
        System.out.print("Choose: ");

        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            System.out.print("Enter text: ");
            String text = sc.nextLine();
            System.out.println("Morse: " + translator.toMorse(text));
        }
        else if (choice == 2) {
            System.out.print("Enter morse: ");
            String morse = sc.nextLine();
            System.out.println("Text: " + translator.toText(morse));
        }
        else {
            System.out.println("Invalid choice");
        }

        sc.close();
    }
}
