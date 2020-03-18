package lab2;

public class Main {

    public static void main(String[] args) {
        /**
         *
         *Each vehicle belongs to a single depot. It starts from there and it may return there at any time.
         * Each client has a name and a visiting time (a number of order, starting with 1).
         * Each vehicle will perform a single tour, consisting of one or more trips with strictly ascending visiting times, starting from its depot and ending in it.
         * Each trip in the timetable must be covered by a single vehicle.
         * A vehicle cannot be assigned to more than one trip at any point in time.
         *
        Problem input:
        There are 2 depots (D1,D2), D1 has 2 vehicles (V1,V2) and D2 has one vehicle (V3).
         There are 5 clients C1(1),C2(1),C3(2),C4(2),C5(3) (in parenthesis are the visiting times).
         A solution for this example might contain the following tours: V1: D1 -> C1 -> C3 -> C5 -> D1, V2: D1 -> C2 -> D1, V3: D2 -> C4 -> D3.
         **/
        Problem problem = new Problem();
        Depot D1 = new Depot("D1");
        Depot D2 = new Depot("D2");
        Vehicle V1 = new Car("V1");
        Vehicle V2 = new Drone("V2");
        Vehicle V3 = new Truck("V3");

        problem.setDepots(D1, D2);
        V1.setDepot(D1);
        V2.setDepot(D1);
        V3.setDepot(D2);
        D1.setVehicles(V1, V2);
        D2.setVehicles(V3);

        Client C1 = new Client("C1", 1);
        Client C2 = new Client("C2", 1);
        Client C3 = new Client("C3", 2);
        Client C4 = new Client("C4", 2);
        Client C5 = new Client("C5", 3);

        problem.setClients(C1, C2, C3, C4, C5);

        Vehicle[] vehicles = problem.getVehicles();

        System.out.print("All vehicles: ");
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null) {
                System.out.print(vehicle.getName() + " ");
            }
        }

        System.out.println();
        System.out.println(problem.toString());

        Solution.Solution(problem);
    }
}
