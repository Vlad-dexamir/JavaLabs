package lab2;

public class Tour {
    private Vehicle vehicle;
    private Client[] clients;

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setClients(Client[] clients) {
        this.clients = clients;
    }

    public Client[] getClients() {
        return clients;
    }

    @Override
    public String toString() {
        return "Tour";
    }
}
