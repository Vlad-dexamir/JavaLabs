package lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /**
         * Compulsory
         */

        Book book1 = new Book("Dragon Rising", 3, 5);
        Book book2 = new Book("A Blade in the Dark", 3, 5);
        Food food1 = new Food("Cabbage", 2, 4);
        Food food2 = new Food("Rabbit", 2, 4);
        Weapon weapon = new Weapon("Sword", 5, 10);

        List<Item> knapsackItems = new ArrayList<Item>();

        Knapsack knapsack = new Knapsack(10, knapsackItems);

        knapsack.addItem(book1);
        knapsack.addItem(food1);
        knapsack.addItem(weapon);

        if (knapsackItems.size() > 0) {
            Collections.sort(knapsackItems, (object1, object2) -> object1.getName().compareTo(object2.getName()));
        }

        double totalWeight = 0;
        double totalValue = 0;

        for (Item item : knapsackItems) {
            System.out.println(item.getName());
            totalValue += item.getValue();
            totalWeight += item.getWeight();
        }

        System.out.println("Total weight: " + totalWeight);
        System.out.println("Total value: " + totalValue);


        /**
         * Optional
         */

        Knapsack problemInstance = new Knapsack();

        System.out.println();
        System.out.println("Greedy: ");
        long greedyStart = System.nanoTime();
        Greedy greedySoluton = new Greedy(problemInstance);
        long greedyEnd = System.nanoTime();
        long greedyTotal = greedyEnd - greedyStart;
        greedyTotal /= 1000000;
        System.out.println("Greedy algorithm went on for " + greedyTotal + " milliseconds");

        System.out.println();

        long dynamicStart = System.nanoTime();
        DynamicProgramming dynamicProgrammingSolution = new DynamicProgramming(problemInstance);
        long dynamicEnd = System.nanoTime();
        long dynamicTotal = dynamicEnd - dynamicStart;
        dynamicTotal/=1000000;
        System.out.println("The dynamic programming algorithm went on for "+ dynamicTotal + " milliseconds");

    }
}
