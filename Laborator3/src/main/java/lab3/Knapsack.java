package lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Knapsack {
    private double capacity;
    private List<Item> items;

    public Knapsack(double capacity, List<Item> items){
        this.capacity = capacity;
        this.items = items;
    }

    public Knapsack(){
        List<Item> items = new ArrayList<Item>();
        int[] capacity = IntStream.rangeClosed(1,50).toArray();

        Book book1 = new Book("Dragon Rising", 3, 5);
        items.add(book1);

        Book book2 = new Book("Norse Mythology", 3, 5);
        items.add(book2);

        Book book3 = new Book("David Copperfield", 3, 5);
        items.add(book3);

        Book book4 = new Book("Station Eleven", 2, 4);
        items.add(book4);

        Food food1 = new Food("Cabbage", 2, 4);
        items.add(food1);

        Food food2 = new Food("Steak", 2, 4);
        items.add(food2);

        Food food3 = new Food("French Fries", 1, 4);
        items.add(food3);

        Food food4 = new Food("Rice", 2, 4);
        items.add(food4);

        Weapon weapon1 = new Weapon("Sword", 5, 10);
        items.add(weapon1);

        Weapon weapon2 = new Weapon("Arbalest", 7, 12);
        items.add(weapon2);

        Weapon weapon3 = new Weapon("Knife", 2, 5);
        items.add(weapon3);

        Weapon weapon4 = new Weapon("Gun", 1, 3);
        items.add(weapon4);

        int randomCapacity = new Random().nextInt(capacity.length);
        this.capacity = randomCapacity;

        int[] randomItems = IntStream.rangeClosed(0, 11).toArray();
        int randomNumberOfItems = new Random().nextInt(randomItems.length);
        List<Item> knapsackItems = new ArrayList<>();

        for(int i = 0; i<randomNumberOfItems; i++) {
            knapsackItems.add(items.get(new Random().nextInt(randomItems.length)));
        }

        this.items = knapsackItems;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public List<Item> getItems(){
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public String toString(){
        return "Knapsack Problem";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Knapsack)) {
            return false;
        }
        Knapsack other = (Knapsack) obj;
        return items.equals(other.items);
    }


}
