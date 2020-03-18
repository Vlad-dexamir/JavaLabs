package lab2;

public class Problem {
    private Depot[] depots;
    private Client[] clients;

    public void setDepots(Depot... depots) {
        this.depots = depots;
    }

    public Depot[] getDepots() {
        return depots;
    }

    public void setClients(Client... clients) {
        this.clients = clients;
    }

    public Client[] getClients() {
        return clients;
    }

    /**
     *
     * @return all vehicles from all depots;
     */
    public Vehicle[] getVehicles() {
        Vehicle[] vehicles = new Vehicle[100], depotVehicles;
        int vehicleNumber = 0;

        for(Depot depot: depots) {
            depotVehicles = depot.getVehicles();
            for(Vehicle depotVehicle: depotVehicles) {
                vehicles[vehicleNumber++] = depotVehicle;
            }
        }

        return vehicles;
    }

    @Override
    public String toString() {
        return "Problem";
    }
}
