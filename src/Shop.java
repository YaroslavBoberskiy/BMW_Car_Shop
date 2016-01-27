import java.util.ArrayList;
import java.util.Date;

/**
 * Created by YB on 04.11.2015.
 */
public class Shop {

    private ClientsDB cdb = new ClientsDB();
    private Warehouse cwh = new Warehouse();
    private Transaction transact = new Transaction();
    private ArrayList<String> transactionsList = new ArrayList<String>();
    private int transactionID = 0;
    private final int COLUMN_COUNT_JTABLE = 7;
    private final int ROW_COUNT_JTABLE = 15;
    private String[][] jtableArr = new String[ROW_COUNT_JTABLE][COLUMN_COUNT_JTABLE];

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
        String[] transactionRowArr = new String[COLUMN_COUNT_JTABLE];

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

        setDiscount(car);

        transactionsList.add(Integer.toString(transactionID));
        transactionsList.add(date.toString());
        transactionsList.add(clientFirstName);
        transactionsList.add(clientLastName);
        transactionsList.add(carVin);
        transactionsList.add(car.getModel().toString());
        transactionsList.add(String.valueOf(car.getPrice()));

        transactionRowArr = transactionsList.toArray(transactionRowArr);

        for (String s : transactionRowArr) {
            System.out.println(s);
        }

        jtableArr[transactionID] = transactionRowArr;

        transactionID ++;

        transactionsList.clear();

        transact.makeTransaction(new Transaction("TR:" + transactionID, date.toString(), car, client));
    }

    public void setDiscount (Car car) {
        if (car.getPrice() >= 80000 && car.getPrice() < 100000) {
            car.setPrice(car.getPrice() - (car.getPrice()*0.05));
        }
        if (car.getPrice() >= 100000) {
            car.setPrice(car.getPrice() - (car.getPrice()*0.1));
        }
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

    public Date getDate() {
        return new Date();
    }

    public String[][] getJtableArr() {
        return jtableArr;
    }

}
