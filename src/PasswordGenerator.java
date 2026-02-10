import java.util.Random;
import java.util.Scanner;

class Password{

    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+<>?";

    private static final String ALL_CHARS = UPPER + LOWER + DIGITS + SYMBOLS;

    private Random random;
    private Scanner scanner;

    public Password() {
        random = new Random();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.print("Enter password length: ");
        int length = scanner.nextInt();

        if (length < 4) {
            System.out.println("Password length must be at least 4.");
            return;
        }

        String password = generatePassword(length);
        System.out.println("Generated Password: " + password);
    }

    private String generatePassword(int length) {
        StringBuffer password = new StringBuffer();

        password.append(UPPER.charAt(random.nextInt(UPPER.length())));
        password.append(LOWER.charAt(random.nextInt(LOWER.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SYMBOLS.charAt(random.nextInt(SYMBOLS.length())));

        // remaining characters
        for (int i = 4; i < length; i++) {
            password.append(ALL_CHARS.charAt(random.nextInt(ALL_CHARS.length())));
        }
        return  shufflePassword(password.toString());
    }

    private String shufflePassword(String password) {

        char [] chars= password.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int randomIndex = random.nextInt(chars.length);
            char temp = chars[i];
            chars[i] = chars[randomIndex];
            chars[randomIndex] = temp;
        }

        return chars.toString();

    }


}

public class PasswordGenerator {
    public static void main(String args[]){
        Password generator = new Password();
        generator.start();

    }
}
