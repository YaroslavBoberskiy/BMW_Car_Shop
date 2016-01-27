import java.util.ArrayList;

/**
 * Created by YB on 02.11.2015.
 */
public class Warehouse {

    ArrayList<Car> availableCarsDB = new ArrayList<Car>();

    // String vinCode, CarModel model, CarColor color, EngineType engineType, double engineSize, BodyType bodyType, double price
    // Test Data
    Car car1 = new Car("VIN1", CarModel.M3, CarColor.ALPINE_WHITE, EngineType.PETROL, 3.0, BodyType.CONVERTIBLE, 109000);
    Car car2 = new Car("VIN2", CarModel.X5, CarColor.BLACK_SAPPHIRE, EngineType.DIESEL, 3.3, BodyType.SUV, 77200);
    Car car3 = new Car("VIN3", CarModel.SERIES_1, CarColor.GLACIER_SILVER, EngineType.PETROL, 3.0, BodyType.HATCHBACK, 29000);
    Car car4 = new Car("VIN4", CarModel.SERIES_3, CarColor.IMPERIAL_BLUE, EngineType.PETROL, 2.0, BodyType.COUPE, 59000);
    Car car5 = new Car("VIN5", CarModel.SERIES_5, CarColor.MELBOURNE_RED, EngineType.DIESEL, 2.5, BodyType.SEDAN, 71000);

    public void fillDbWithTestCars() {
        availableCarsDB.add(car1);
        availableCarsDB.add(car2);
        availableCarsDB.add(car3);
        availableCarsDB.add(car4);
        availableCarsDB.add(car5);
    }

    public void addNewCarToDB(Car car) {
        if (car instanceof Car) {
            availableCarsDB.add(car);
        }
    }

    public void showAvailableCars() {
        for (int i = 0; i < availableCarsDB.size(); i++) {
            if (availableCarsDB.get(i) instanceof Car) {
                Car car = (Car) availableCarsDB.get(i);
//                System.out.println("Model: " + car.getModel());
//                System.out.println("VIN: " + car.getVinCode());
//                System.out.println("Price: " + car.getPrice());
            }
        }
    }

    public ArrayList<Car> getAvailableCarsDB() {
        return availableCarsDB;
    }

    public String[] getAvailableCarsDBbyVIN() {
        String[] carsByVIN = new String[availableCarsDB.size()];
        for (int i = 0; i < carsByVIN.length; i++) {
            carsByVIN[i] = availableCarsDB.get(i).getVinCode();
        }
        return carsByVIN;
    }
}
