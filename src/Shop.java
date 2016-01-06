/**
 * Created by YB on 04.11.2015.
 */
public class Shop {

    private ClientsDB cdb = new ClientsDB();
    private Warehouse cwh = new Warehouse();
    private Transaction transact = new Transaction();
    private Car availableCarsDB[];

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

        int carNumInArray = 0;
        int clientNumInArray = 0;

        for (int i = 0; i < cwh.getAvailableCarsDB().length; i++) {
            if (carVin == (cwh.getAvailableCarsDB()[i].getVinCode().toString())) {
                carNumInArray = i;
                break;
            }
        }

        for (int i = 0; i < cdb.getClientsDB().length; i++) {
            if (clientFirstName == cdb.getClientsDB()[i].getFirstName() && clientLastName == cdb.getClientsDB()[i].getLastName()) {
                clientNumInArray = i;
                break;
            }
        }
            transact.makeTransaction(new Transaction("TR", date, cwh.getAvailableCarsDB()[carNumInArray], cdb.getClientsDB()[clientNumInArray]));
            availableCarsDB = cwh.getAvailableCarsDB();
            availableCarsDB[carNumInArray] = null;
            cwh.setAvailableCarsDB(availableCarsDB);
        }

    public void showAllOperations() {
        transact.printAllTransactions();
    }

    public ClientsDB getCdb() {
        return cdb;
    }

    public Warehouse getCwh() {
        return cwh;
    }

}
