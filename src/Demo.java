import java.awt.*;

/**
 * Created by YB on 02.11.2015.
 */
public class Demo {

    public static void main(String[] args) throws Exception{

        Shop bmwShop = new Shop();

        // Filling Shop DB with test data
        bmwShop.fillShopWithTestData();

        SplashScreen splash = SplashScreen.getSplashScreen();
        Thread.sleep(3500);
        Graphics2D graphics = splash.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.drawString("Loading...", 350, 300);
        splash.update();
        Thread.sleep(2000);

        splash.close();


        //Show all clients
//        System.out.println("=== Clients ===");
//        bmwShop.showAllClients();

        // Add new client
//        Client c = new Client(TilteBeforeClientName.Dr, "Nestor", "Mann", "21.08.1958", "079-69-24-23", "nm@mail.com", "male", true);
//        bmwShop.addNewClient(c);

        //Show all clients after adding new client
//        System.out.println("=== Clients after adding new client ===");
//        bmwShop.showAllClients();

        //Show warehouse
//        System.out.println("=== BMW Shop Warehouse ===");
//        bmwShop.showWarehouse();

        //Add new car to warehouse
//        Car car = new Car("VIN6", CarModel.X3, CarColor.ORION_SILVER, EngineType.DIESEL, 3.0, BodyType.SUV, 61000);
//        bmwShop.addNewCarToWarehouse(car);
//        Car car2 = new Car("VIN7", CarModel.X3, CarColor.ORION_SILVER, EngineType.DIESEL, 3.0, BodyType.SUV, 62000);
//        bmwShop.addNewCarToWarehouse(car2);

        //Show warehouse
//        System.out.println("=== BMW Shop Warehouse after adding new car ===");
//        bmwShop.showWarehouse();

        //Buy car
//        System.out.println("=== Buy car ===");
//        bmwShop.bayCar("KJF8843HH", "Elizabeth", "Koh", "04.11.2015");
//        bmwShop.bayCar("KJH6543GH", "Elizabeth", "Koh", "04.11.2015");
//        bmwShop.bayCar("KTH6883GH", "Elizabeth", "Koh", "04.11.2015");
//        bmwShop.bayCar("KII6743HO", "Elizabeth", "Koh", "04.11.2015");
//        bmwShop.bayCar("KJH6543GY", "Elizabeth", "Koh", "04.11.2015");

        //Show bought cars
//        System.out.println("=== Bought cars ===");
//        bmwShop.showAllOperations();

        //Show warehouse after purchase
//        System.out.println("=== BMW Shop Warehouse ===");
//        bmwShop.showWarehouse();

        GUI_Sell gui = new GUI_Sell(bmwShop);
        gui.showGUI();

    }
}
