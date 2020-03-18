package lab3;

public class Food implements Item {
    private String name;
    private double weight;
    private double value;

    public Food(String name, double weight, double value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public double getWeight() {
        return weight;
    }

}
