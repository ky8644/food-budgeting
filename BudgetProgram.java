// Ellissya Tjhin, Katie Yang, Programmer
// Monday, 10/7
// Program to work with food budget

import java.util.Scanner;
import java.util.ArrayList;

public class BudgetProgram {
    public static void summary(double budget, double total, int counter, ArrayList<String> items,
            ArrayList<Double> prices) {
        System.out.println();
        System.out.println("---Summary---");
        System.out.println("Your budget: $" + budget);
        System.out.println("Amount spent: $" + total);
        System.out.println("Amount left: $" + (budget - total));
        System.out.println();
        System.out.println("---Item recount---");
        System.out.println("Number of items purchased: " + counter);
        for (int i = 0; i < counter; i++) {
            System.out.println(items.get(i) + ": $" + prices.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // input weekly budget
        System.out.print("Your weekly budget: $");
        double budget = scan.nextDouble();
        scan.nextLine();

        ArrayList<String> items = new ArrayList<String>(); // items bought
        ArrayList<Double> prices = new ArrayList<Double>(); // prices of items bought

        double total = 0; // total cost of items
        boolean cont = true;
        int counter = 0;

        System.out.println("You have $" + (budget - total) + ". Would you like to add an item? y/n");
        String reply = scan.nextLine();
        if (reply.equals("y"))
            cont = true;
        else
            cont = false;

        while (cont == true && total < budget) {
            System.out.println();
            System.out.println("---Adding an item---");
            System.out.print("Name of item: ");
            String item = scan.nextLine();

            System.out.print("Price of item: $");
            double price = scan.nextDouble();
            scan.nextLine();

            if (price > (budget - total)) {
                System.out.println("You don\'t have enough money in your budget left!");
                summary(budget, total, counter, items, prices);

            } else {
                items.add(item);
                prices.add(price);
                total += price;
                counter++;
            }

            if (budget - total != 0) {
                System.out.println();
                System.out.println("Would you like to see the items you got so far? y/n");
                String summary = scan.nextLine();
                if (summary.equals("y"))
                    summary(budget, total, counter, items, prices);

                System.out.println();
                System.out.println("You have $" + (budget - total) + " left, would you like to continue? y/n");
                reply = scan.nextLine();
                if (reply.equals("y"))
                    cont = true;
                else
                    cont = false;
            }
        }

        summary(budget, total, counter, items, prices);
    }
}