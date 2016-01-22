import java.util.ArrayList;

/**
 * Created by YB on 02.11.2015.
 */
public class Transaction {

    private String transactionID;
    private String transactionDate;
    private Client client;
    private Car car;
    private String transactionInfo;
    private ArrayList<String> transactionsDB = new ArrayList<String>();
    private ArrayList<Car> soldCars = new ArrayList<Car>();

    Transaction() {
        transactionID = "-";
        transactionDate = "-";
        client = null;
        car = null;
        transactionInfo = null;
    }

    Transaction(String transactionID, String transactionDate, Car car, Client client) {
        this.transactionID = transactionID;
        this.transactionDate = transactionDate;
        this.car = car;
        this.client = client;
    }

    public void makeTransaction(Transaction tr) {

        transactionInfo = "ID: " + tr.transactionID + ", DATE: " + tr.transactionDate + ", CLIENT FIRST NAME: " +
                tr.client.getFirstName() + ", CLIENT LAST NAME: " + tr.client.getLastName() + ", CAR VIN: " +
                tr.car.getVinCode() + ", CAR MODEL: " + tr.car.getModel() + ", PRICE: " + tr.car.getPrice();

        transactionsDB.add(transactionInfo);
        if (tr.car instanceof Car) {
            soldCars.add(tr.car);
        }
    }

    public void printAllTransactions() {
        if (!transactionsDB.isEmpty()) {
            for (String transaction : transactionsDB) {
                System.out.println(transaction);
            }
        } else {
            System.out.println("There is no transactions in DB");
        }
    }

    public String getTransactionID() {
        return transactionID;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public Client getClient() {
        return client;
    }

    public Car getCar() {
        return car;
    }

    public ArrayList<Car> getSoldCars() {
        return soldCars;
    }

    public ArrayList<String> getTransactionsDB() {
        return transactionsDB;
    }
}
