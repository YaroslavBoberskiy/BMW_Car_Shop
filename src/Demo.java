/**
 * Created by YB on 02.11.2015.
 */
public class Demo {

    public static void main(String[] args) {

        Shop bmwShop = new Shop();

        // Filling Shop DB with test data
        bmwShop.fillShopWithTestData();

        //Show all clients
        System.out.println("=== Clients ===");
        bmwShop.showAllClients();

        // Add new client
        Client c = new Client(TilteBeforeClientName.Dr, "Nestor", "Mann", "21.08.1958", "079-69-24-23", "nm@mail.com", "male", true);
        bmwShop.addNewClient(c);

        //Show all clients after adding new client
        System.out.println("=== Clients after adding new client ===");
        bmwShop.showAllClients();

        //Show warehouse
        System.out.println("=== BMW Shop Warehouse ===");
        bmwShop.showWarehouse();

        //Add new car to warehouse
        Car car = new Car("KJH6993GH", CarModel.X3, CarColor.ORION_SILVER, EngineType.DIESEL, 3.0, BodyType.SUV, 61000);
        bmwShop.addNewCarToWarehouse(car);

        //Show warehouse
        System.out.println("=== BMW Shop Warehouse after adding new car ===");
        bmwShop.showWarehouse();

        //Buy car
        System.out.println("=== Buy car ===");
        bmwShop.bayCar("KJF8843HH", "Elizabeth", "Koh", "04.11.2015");

        //Show bought cars
        System.out.println("=== Bought cars ===");
        bmwShop.showAllOperations();

        //Show warehouse after purchase
        System.out.println("=== BMW Shop Warehouse ===");
        bmwShop.showWarehouse();

        GUI gui = new GUI();
        gui.showGUI();

    }
}
