import org.jetbrains.annotations.Contract;

import java.util.Scanner;

//One cup of coffee made on this coffee machine contains 200 ml of water, 50 ml of milk, and 15 g of coffee beans.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has: ");
        int waterSupply = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milkSupply = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int beansSupply = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        int numberOfCups = scanner.nextInt();
        int minimal = min(milkSupply, beansSupply, waterSupply);
        if (numberOfCups > minimal) {
            System.out.println("No, I can make only " + minimal + " cup(s) of coffee");
        } else {
            if (numberOfCups < minimal) {
                System.out.println("Yes, I can make that amount of coffee (and even " + (minimal - numberOfCups) + " more than that)");
            }
            else { System.out.println("Yes, I can make that amount of coffee"); }
        }
    }

    private static int min(int milk, int beans, int water) {
        int cups;
        int minMilk = milk / 50;
        int minWater = water / 200;
        int minBeans = beans / 15;
        if (minMilk <= minWater && minMilk <= minBeans){
            cups = minMilk;}
        else if (minWater <= minMilk && minWater <= minBeans){
            cups = minWater;}
        else { cups = minBeans; }
        return cups;
    }
}

