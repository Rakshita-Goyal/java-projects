//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

class Calculators {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}

public class Calculator{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculators calc = new Calculators();
        int choice;
        double num1, num2;


        while (true) {
            System.out.println("\nChoose Operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice == 5) {
                System.out.println("Calculator closed.");
                break;
            }


            System.out.print("Enter first number: ");
            num1 = sc.nextDouble();

            System.out.print("Enter second number: ");
            num2 = sc.nextDouble();

            try {
                switch (choice) {
                    case 1:
                        System.out.println("Result = " + calc.add(num1, num2));
                        break;

                    case 2:
                        System.out.println("Result = " + calc.subtract(num1, num2));
                        break;

                    case 3:
                        System.out.println("Result = " + calc.multiply(num1, num2));
                        break;

                    case 4:
                        System.out.println("Result = " + calc.divide(num1, num2));
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }



        }



    }
}