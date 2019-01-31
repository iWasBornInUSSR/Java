import java.util.Scanner;
//One cup of coffee made on this coffee machine contains 200 ml of water, 50 ml of milk, and 15 g of coffee beans.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need: ");
        int numberOfCups = scanner.nextInt();
        int amountOfWater = numberOfCups * 200;
        int amountOfMilk = numberOfCups * 50;
        int amountOfBeans = numberOfCups * 15;
        System.out.println("For " + numberOfCups + " cups of coffee you will need:");
        System.out.println(amountOfWater + " ml of water");
        System.out.println(amountOfMilk + " ml of milk");
        System.out.println(amountOfBeans + " g of coffee beans");
    }
}
