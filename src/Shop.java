/**
 * Created by YB on 04.11.2015.
 */
public class Shop {

    private ClientsDB cdb = new ClientsDB();
    private Warehouse cwh = new Warehouse();
    private Transaction transact = new Transaction();

    public void fillShopWithTestData() {
        cdb.fillDbWithTestClients();
        cwh.fillDbWithTestCars();
    }

    public void addNewClient(Client client) {
        cdb.addNewClientToDB(client);
    }

    public void addNewCarToWarehouse(Car car) {
        cwh.addNewCarToDB(car);
    }

    public void showAllClients() {
        cdb.showClients();
    }

    public void showWarehouse() {
        cwh.showAvailableCars();
    }

    public void bayCar(String carVin, String clientFirstName, String clientLastName, String date) {

        Car car = null;
        Client client = null;

        for (int i = 0; i < cwh.getAvailableCarsDB().size(); i++) {
            if (cwh.getAvailableCarsDB().get(i).getVinCode() == carVin) {
                car = cwh.getAvailableCarsDB().get(i);
                cwh.getAvailableCarsDB().remove(i);
            }
        }

        for (int i = 0; i < cdb.getClientsDB().size(); i++) {
            if (cdb.getClientsDB().get(i).getFirstName() == clientFirstName && cdb.getClientsDB().get(i).getLastName() == clientLastName) {
                client = cdb.getClientsDB().get(i);
            }
        }

        transact.makeTransaction(new Transaction("TR:", date, car, client));
    }

    public void showAllOperations() {
        transact.printAllTransactions();
    }

    public String getCarInfoByVIN(String VIN) {
        String carInfo = "There is no cars available!";
        for (int i = 0; i < getCwh().getAvailableCarsDB().size(); i++) {
            if (getCwh().getAvailableCarsDB().get(i).getVinCode() == VIN) {
                carInfo = "Model: " + getCwh().getAvailableCarsDB().get(i).getModel() + "\n" +
                        "Body Type: " + getCwh().getAvailableCarsDB().get(i).getBodyType() + "\n" +
                        "Color: " + getCwh().getAvailableCarsDB().get(i).getColor() + "\n" +
                        "Engine type: " + getCwh().getAvailableCarsDB().get(i).getEngineType() + "\n" +
                        "Engine vol: " + getCwh().getAvailableCarsDB().get(i).getEngineSize() + "\n" +
                        "Price: " + getCwh().getAvailableCarsDB().get(i).getPrice();
            }
        }
        return carInfo;
    }

    public ClientsDB getCdb() {
        return cdb;
    }

    public Warehouse getCwh() {
        return cwh;
    }

}
