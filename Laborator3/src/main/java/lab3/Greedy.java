package lab3;

import java.util.Comparator;
import java.util.List;

public class Greedy implements Algorithm {
    public Greedy(Knapsack problemInstance) {
        Solution(problemInstance);
    }

    /**
     *
     Simple Solution: Order the elements comparing value. Add (if it is possible) the most valuable element to the knapsack and its value to the sum.
     */
    @Override
    public void Solution(Knapsack problemInstance) {
        if (problemInstance.getItems().size() > 0) {
            problemInstance.getItems().sort((Comparator.comparingDouble(Item::getValue)));
        }

        double takenCapacity = 0;
        double maximumValue = 0;
        List<Item> items = problemInstance.getItems();

        for(int i= items.size() -1; i>=0; i--) {
            if(items.get(i).getWeight() + takenCapacity <= problemInstance.getCapacity()) {
                takenCapacity+= items.get(i).getWeight();
                problemInstance.addItem(items.get(i));
                maximumValue+= items.get(i).getValue();
            }
        }

        System.out.println("Maximum value " + maximumValue);
    }
}
