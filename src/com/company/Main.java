package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        ArrayList<String> grocery = new ArrayList<String>();
        grocery.add("Red-Hot Spicy Doritos");
        grocery.add("Cool Ranch Doritos");
        grocery.add("Coke");
        grocery.add("Pepsi");
        grocery.add("Diet Coke");
        grocery.add("5 Hour Energy");
        grocery.add("Mac Charger");
        grocery.add("Dell Charger");
        grocery.add("Sunflower Seeds");
        grocery.add("Peanuts");
        ArrayList<Double> Price = new ArrayList<Double>();
        Price.add(2.99);
        Price.add(2.99);
        Price.add(0.99);
        Price.add(0.99);
        Price.add(0.99);
        Price.add(3.99);
        Price.add(120.00);
        Price.add(50.00);
        Price.add(0.99);
        Price.add(0.99);

        ArrayList<String> customerItem = new ArrayList<String>();
        ArrayList<Integer> customerAmounts = new ArrayList<Integer>();
        String input;
        Scanner stringInput = new Scanner(System.in);

        String output = "";
        double total;
        double FinalTotal = 0;
        System.out.print("\nEnter customer name: ");
        while(!(input = stringInput.nextLine()).equalsIgnoreCase("no")){
            output += "\n" + input;
            total = 0;
            System.out.println("Enter the name of items: (0 to exit at any time)");
            while(!(input = stringInput.nextLine()).equalsIgnoreCase("0")) {
                for(String i:grocery) {
                    if(i.contains(input) || i.equalsIgnoreCase(input)) {
                        total += Price.get(grocery.indexOf(i));
                        output += "\n\t" + input;
                        if(!customerItem.contains(input)) {
                            customerItem.add(input);
                            customerAmounts.add(1);
                        }
                        else {
                            int index = customerItem.indexOf(input);
                            customerAmounts.set(index, customerAmounts.get(index) + 1);
                        }
                        break;
                    }
                }
            }
            output += "\n\t\t" + total + "\n";
            FinalTotal += total;
            System.out.print("\nEnter next customer name: (no to complete): ");
        }
        System.out.println("RECEIPT: \n" + output);
        System.out.println("\nInventory Sold: ");
        for(String i:customerItem) {
            System.out.println("\t" + i + " (" + customerAmounts.get(customerItem.indexOf(i)) + ")");
        }
        System.out.println("\nGRAND TOTAL: " + FinalTotal);
    }
}
