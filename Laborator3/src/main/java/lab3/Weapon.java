package lab3;

public class Weapon<Type> implements Item {
    private Type type;
    private double weight;
    private double value;

    public Weapon(Type type, double weight, double value){
        this.type = type;
        this.weight = weight;
        this.value = value;
    }

    @Override
    public String getName(){
        return (String) type;
    }

    @Override
    public double getWeight(){
        return weight;
    }

    @Override
    public double getValue(){
        return value;
    }
}
