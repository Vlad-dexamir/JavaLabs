package lab3;

import java.util.List;

public class DynamicProgramming implements Algorithm {
    public DynamicProgramming(Knapsack problemInstance) {
        Solution(problemInstance);
    }

    /**
     *
     * Solution:
     * Build a 2dimensional array called profit array where :
        profitArray[i,j]= the best profit it could be choosing ones of first i objects obtaining j weight.
     */
    @Override
    public void Solution(Knapsack problemInstance) {


        int capacity = (int) problemInstance.getCapacity();
        int numberOfItems = problemInstance.getItems().size();
        List<Item> items = problemInstance.getItems();
        int[][] profitArray = new int[numberOfItems + 1][capacity + 1];
        for (int i = 0; i <= numberOfItems; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    profitArray[i][j] = 0;
                } else if (items.get(i - 1).getWeight() <= j) {
                    profitArray[i][j] = (int) Math.max(items.get(i - 1).getValue() + profitArray[i - 1][(int) (j - items.get(i - 1).getWeight())], profitArray[i - 1][j]);
                } else {
                    profitArray[i][j] = profitArray[i - 1][j];
                }
            }
        }
        System.out.println("Maximum value: " + profitArray[numberOfItems][capacity] / 2.0);
    }
}
