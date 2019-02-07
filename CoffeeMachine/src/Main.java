
import java.util.Scanner;

/*For the espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
For the latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
And for the cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee. It costs $6.
*/
public class Main {
    private static int waterSupply = 400;
    private static int milkSupply = 540;
    private static int beansSupply = 120;
    private static int disposableCupsSupply = 9;
    private static int moneySupply = 550;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isOver = false;
        while (!isOver) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String userChoice = scanner.next();
            switch (userChoice) {
                case "fill":
                    fillMachine(scanner);
                    break;
                case "take":
                    giveMoney();
                    break;
                case "buy":
                    makeCoffee(scanner);
                    break;
                case "remaining":
                    printMachinesState();
                    break;
                case "exit" : isOver = true; break;
                default:
                    break;
            }
        }
    }

    private static void printMachinesState() {
        System.out.println("The coffee machine has:");
        System.out.println(waterSupply + " of water");
        System.out.println(milkSupply + " of milk");
        System.out.println(beansSupply + " of coffee beans");
        System.out.println(disposableCupsSupply + " of disposable cups");
        System.out.println(moneySupply + " of money");
    }

    private static void fillMachine(Scanner scanner) {
        int added;
        System.out.println("Write how many ml of water do you want to add: ");
        added = scanner.nextInt();
        waterSupply += added;
        System.out.println("Write how many ml of milk do you want to add: ");
        added = scanner.nextInt();
        milkSupply += added;
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        added = scanner.nextInt();
        beansSupply += added;
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        added = scanner.nextInt();
        disposableCupsSupply += added;
    }

    private static void giveMoney() {
        System.out.println("I gave you $" + moneySupply);
        moneySupply = 0;
    }

    private static void makeCoffee(Scanner scanner) {
        int waterCost = 0;
        int milkCost = 0;
        int beansCost = 0;
        int profit = 0;
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String variant = scanner.next();
        if ("back".equals(variant)) return;
        int coffeeVariety = Integer.parseInt(variant);
        switch (coffeeVariety) {
            case 1:
                waterCost = 250;
                beansCost = 16;
                profit = 4;
                break;
            case 2:
                waterCost = 350;
                milkCost = 75;
                beansCost = 20;
                profit = 7;
                break;
            case 3:
                waterCost = 200;
                milkCost = 100;
                beansCost = 12;
                profit = 6;
                break;
            default:
                System.out.println("Error");
                break;
        }
        if (isEnoughRes(waterCost,beansCost,milkCost)) {
            waterSupply = waterSupply - waterCost;
            milkSupply = milkSupply - milkCost;
            beansSupply = beansSupply - beansCost;
            moneySupply = moneySupply + profit;
            disposableCupsSupply--;
        }
    }
    private static boolean isEnoughRes(int waterCost, int beansCost, int milkCost){
        String missingRes;
     if (waterCost > waterSupply)
         missingRes = "water";
     else if (beansCost > beansSupply)
         missingRes = "coffee beans";
     else  if (milkCost > milkSupply)
         missingRes = "milk";
     else if (disposableCupsSupply < 1)
         missingRes = "disposable cups";
     else {
         System.out.println("I have enough resources, making you a coffee!");
         return true;
     }
        System.out.println("Sorry, not enough " + missingRes + "!");
        return false;
    }
}

