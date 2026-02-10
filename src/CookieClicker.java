
import java.util.*;
class GameLogic {

    private int cookies = 0;
    private int autoClickers = 0;
    private int autoClickerCost = 10;

    public int getCookies() {
        return cookies;
    }

    public int getAutoClickers() {
        return autoClickers;
    }

    public int getAutoClickerCost() {
        return autoClickerCost;
    }

    public void clickCookie() {
        cookies+=12;
    }

    public void autoGenerateCookies() {
        cookies += autoClickers;
    }

    public boolean buyAutoClicker() {
        if (cookies >= autoClickerCost) {
            cookies -= autoClickerCost;
            autoClickers++;
            autoClickerCost += 5;
            return true;
        }
        return false;
    }

}
public class CookieClicker {
public static void main(String args[]){
    GameLogic game = new GameLogic();
    Scanner sc = new Scanner(System.in);

    int choice;

    Thread autoThread = new Thread(() -> {
        while (true) {
            try {
                Thread.sleep(2000); // 2 seconds
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            game.autoGenerateCookies();
        }
    });

    do {
        System.out.println("\n🍪 COOKIE CLICKER 🍪");
        System.out.println("1. Click Cookie");
        System.out.println("2. Buy Auto Clicker (Cost: " + game.getAutoClickerCost() + ")");
        System.out.println("3. Show Status");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");

        choice = sc.nextInt();

        switch (choice) {

            case 1:
                game.clickCookie();
                System.out.println("You clicked a cookie!");
                break;

            case 2:
                if (game.buyAutoClicker()) {
                    System.out.println("Auto clicker bought!");
                } else {
                    System.out.println("Not enough cookies!");
                }
                break;

            case 3:
                System.out.println("Cookies: " + game.getCookies());
                System.out.println("Auto Clickers: " + game.getAutoClickers());
                break;

            case 0:
                System.out.println("Exiting game...");
                break;

            default:
                System.out.println("Invalid choice");
        }

    } while (choice != 0);
    }
}
