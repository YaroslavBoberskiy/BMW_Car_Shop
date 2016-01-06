/**
 * Created by YB on 02.11.2015.
 */
public class Warehouse {

    Car availableCarsDB[] = new Car[30];

    // String vinCode, CarModel model, CarColor color, EngineType engineType, double engineSize, BodyType bodyType, double price
    // Test Data
    Car car1 = new Car("KJH6543GH", CarModel.M3, CarColor.ALPINE_WHITE, EngineType.PETROL, 3.0, BodyType.CONVERTIBLE, 109000);
    Car car2 = new Car("KTH6883GH", CarModel.X5, CarColor.BLACK_SAPPHIRE, EngineType.DIESEL, 3.3, BodyType.SUV, 77200);
    Car car3 = new Car("KII6743HO", CarModel.SERIES_1, CarColor.GLACIER_SILVER, EngineType.PETROL, 3.0, BodyType.HATCHBACK, 29000);
    Car car4 = new Car("KJF8843HH", CarModel.SERIES_3, CarColor.IMPERIAL_BLUE, EngineType.PETROL, 2.0, BodyType.COUPE, 59000);
    Car car5 = new Car("KJH6543GH", CarModel.SERIES_5, CarColor.MELBOURNE_RED, EngineType.DIESEL, 2.5, BodyType.SEDAN, 71000);

    public void fillDbWithTestCars () {
        availableCarsDB[0] = car1;
        availableCarsDB[1] = car2;
        availableCarsDB[2] = car3;
        availableCarsDB[3] = car4;
        availableCarsDB[4] = car5;
    }

    public void addNewCarToDB(Car car) {
        for (int i = 0; i < availableCarsDB.length; i++) {
            if (availableCarsDB[i] == null) {
                availableCarsDB[i] = car;
                break;
            }
        }
    }


    public  void showAvailableCars() {
        for (int i = 0; i < availableCarsDB.length; i ++) {
            if (availableCarsDB[i] != null) {
                System.out.println(availableCarsDB[i].getModel() + ", VIN: " + availableCarsDB[i].getVinCode() + ", Price: " + availableCarsDB[i].getPrice());
            }
        }
    }

    public Car[] getAvailableCarsDB() {
        return availableCarsDB;
    }

    public String[] getAvailableCarsDBbyVIN() {
        String cars [] = new String[30];
        for (int i=0; i < getAvailableCarsDB().length; i++) {
            if (availableCarsDB[i] != null) {
                cars[i] = "VIN: " + getAvailableCarsDB()[i].getVinCode();
            }
        }
        return cars;
    }

    public void setAvailableCarsDB(Car[] availableCarsDB) {
        this.availableCarsDB = availableCarsDB;
    }
}
