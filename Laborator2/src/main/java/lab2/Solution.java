package lab2;

public class Solution {

    public static void Solution(Problem problem) {
        /**
         We need the problem as parameter.
         From the problem we get the depots and the clients.
         The algorithm is based on traversing all depots and for each depot:
            1) get all depots vehicles
            2) for each vehicle from depot print the vehicleName and the depotName where the vehicle belong
            3) for each client check if the clientTime is longer than lastClientTime => if it's longer, alocate this trip to vehicle and mark this with 0
         **/
        Depot[] depots = problem.getDepots();
        Client[] clients = problem.getClients();
        int lastClientTime = 0;

        for (Depot depot : depots) {
            Vehicle[] vehicles = depot.getVehicles();

            for (Vehicle vehicle : vehicles) {
                System.out.printf("%s:", vehicle.getName());
                System.out.printf("%s ->", depot.getName());

                for (Client client : clients) {
                    if (client.getTime() > lastClientTime) {
                        lastClientTime = client.getTime();
                        System.out.printf("%s(%d) ->", client.getName(), client.getTime());
                        client.setTime(0);
                    }
                }
                lastClientTime = 0;
                System.out.printf("%s \n", depot.getName());
            }
        }
    }

}
