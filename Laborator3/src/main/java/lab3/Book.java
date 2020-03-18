package lab3;

public class Book implements Item {
    private String name;
    private int pageNumber;
    private double value;
    private double weight;

    public Book(String name, int weight, double value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    @Override
    public double getWeight() {
        return pageNumber / 100.00;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
